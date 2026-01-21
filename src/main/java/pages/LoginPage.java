package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 1. Localizadores (Los IDs y nombres que inspeccionamos en la web)
    private By txtUsuario = By.id("uid");
    private By txtPassword = By.name("passw");
    private By btnLogin = By.name("btnSubmit");

    // 2. Constructor (Para que la página use el navegador que abramos)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Acciones (Los pasos que un humano haría)
    public void escribirUsuario(String usuario) {
        driver.findElement(txtUsuario).sendKeys(usuario);
    }

    public void escribirPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void hacerClicEnLogin() {
        driver.findElement(btnLogin).click();
    }
}