package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    ConfigReader config;

    @BeforeMethod
    public void setup() {
        config = new ConfigReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(config.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.escribirUsuario(config.getProperty("usuario"));
        loginPage.escribirPassword(config.getProperty("password"));
        loginPage.hacerClicEnLogin();

        // Esperamos un momento para que la URL cambie (esto ayuda a la sincronización)
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        String urlActual = driver.getCurrentUrl();
        System.out.println("URL tras el login: " + urlActual);

        // Verificamos si la URL contiene 'main.jsp' (que es la página interna del banco)
        boolean esUrlCorrecta = urlActual.contains("main.jsp");

        // Si la URL es correcta, buscamos el texto. Si no, fallará con un mensaje claro.
        Assert.assertTrue(esUrlCorrecta, "No se redirigió a la página principal. URL actual: " + urlActual);

        boolean tieneTextoBienvenida = driver.getPageSource().contains("Hello John Smith");
        Assert.assertTrue(tieneTextoBienvenida, "Login exitoso pero no se encontró el mensaje de bienvenida.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}