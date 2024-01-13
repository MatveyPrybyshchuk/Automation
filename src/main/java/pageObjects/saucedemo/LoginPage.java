package pageObjects.saucedemo;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;

import java.time.Duration;

import static driver.SimpleDriver.getWebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this; //this- каждый из методов возвращает ссылку на данный объект
    }

    public LoginPage open(String url) {
        driver.get(url);
        return this; //this- каждый из методов возвращает ссылку на данный объект
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }


    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage verifyLoginPageIsClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginBtn));
        return this;
    }

    public LoginPage clickLoginBtn() {
        click(loginBtn);
        return this;
    }
}
