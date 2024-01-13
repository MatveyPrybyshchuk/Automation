package Lecture6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;

public class HomeWork {

    @BeforeTest
    public static void preconditions() {
        SimpleDriver simpledriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public static void FindByID() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @Test
    public static void FindByName() {
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
    }

    //XPath:
    @Test
    public static void FindByAttribute() {
        getWebDriver().findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("1");
    }
    @Test
    public static void FindByText() {
        System.out.println(getWebDriver().findElement(By.xpath("//h4[text()='Password for all users:']")).getText());
    }
    @Test
    public static void FindByContainsAttribute() {
        getWebDriver().findElement(By.xpath("//input[contains(@data-test, 'username')]")).sendKeys("ContainsByTag1");
    }
    @Test
    public static void FindByContainsText() {
        System.out.println(getWebDriver().findElement(By.xpath("//h4[contains(text(), 'rname')]")).getText());
    }
    @Test
    public static void FindByAncestor() {
        getWebDriver().findElement(By.xpath("//input[@id='login-button']/ancestor::div[@class='login-box']//input[@data-test='password']")).sendKeys("Ancestor");
    }
    @Test
    public static void FindByDescendant() {
        getWebDriver().findElement(By.xpath("//form/descendant::input[@name='password']")).sendKeys("descendant");
    }
    @Test
    public static void FindByFollowing() {
        System.out.println(getWebDriver().findElement(By.xpath("//following::h4[text()='Password for all users:']")).getText());
    }
    @Test
    public static void FindByParent() {
        getWebDriver().findElement(By.xpath("//input[@id='login-button']/parent::*/input[@id='login-button']")).sendKeys("parent");
    }
    @Test
    public static void FindUsingAND() {
        getWebDriver().findElement(By.xpath("//input[@class='input_error form_input' and @type='password']")).sendKeys("AND");
    }

    //CSS
    @Test
    public static void FindByClass1() {
        getWebDriver().findElement(By.cssSelector(".login-box div [name='user-name']")).sendKeys(".class");
    }
    @Test
    public static void FindByClass2() {
        getWebDriver().findElement(By.cssSelector(".input_error.form_input[name='user-name']")).sendKeys(".class");
    }


    @AfterTest
    public static void postconditions() {
        getWebDriver().close();
    }
}
