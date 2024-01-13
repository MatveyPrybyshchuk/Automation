package Lecture6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import static driver.SimpleDriver.getWebDriver;

public class Lecture6 {

    @BeforeTest
    public void precondotions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/v1/");    }

    //@Test
    public void test() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();

        //elementExist(By.linkText("Facebook"));
        //elementExist(By.linkText("Twi"));
        elementExist(By.className("app_logo"));
    }
    @Test
    public void aboveTest2() {
        getWebDriver().findElement(with(By.tagName("input")).above(By.name("password"))).sendKeys("above");

    }

    @AfterTest
    public void postconditions() {
        //getWebDriver().close();
    }


    private void elementExist(By by) {
        Assert.assertEquals(getWebDriver().findElements(by).size(), 1);
    }
}
