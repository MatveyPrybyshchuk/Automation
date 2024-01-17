package Lecture7;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;

public class BedoreLecture_7 {
    @BeforeTest
    public static void preconditions() {
        SimpleDriver simpledriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
    }


    @Test
    public static void test1() {
        findAndSendKeys("user-name", "standard_user");
        findAndSendKeys("password", "secret_sauce");
        getWebDriver().findElement(By.id("login-button")).click();

        //Проверка соответствии цены для одного товара
        String productName = "Sauce Labs Backpack";
        String productName2 = "Sauce Labs Bike Light";
        String price = getElementProduct(productName).findElement(By.className("inventory_item_price")).getText();
        String price1 = getElementProduct(productName2).findElement(By.className("inventory_item_price")).getText();
        getElementProduct(productName).findElement(By.tagName("button")).click(); //adding 1st good
        getElementProduct(productName2).findElement(By.tagName("button")).click(); // adding second good
        getWebDriver().findElement(By.className("shopping_cart_link")).click();
        String cartPrice = getElementCartItem(productName).findElement(By.className("inventory_item_price")).getText();
        String cartPrice1 = getElementCartItem(productName2).findElement(By.className("inventory_item_price")).getText();
        Assert.assertEquals(price, cartPrice);
        Assert.assertEquals(price1, cartPrice1);
    }


    @AfterTest
    public static void postconditions() {
        getWebDriver().close();
    }


    public static void findAndSendKeys(String path, String data) {
        getWebDriver().findElement(By.id(path)).sendKeys(data);
    }

    private static WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class='inventory_item_name ' and text()='" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private static WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item']"));
    }
}
