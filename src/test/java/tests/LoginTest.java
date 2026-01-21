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

        // Validación: Si aparece "Sign Off" es que entramos con éxito
        Assert.assertTrue(driver.getPageSource().contains("Sign Off"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}