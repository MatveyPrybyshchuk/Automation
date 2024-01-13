package Lecture7;

import driver.SimpleDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class lecture7_1 extends BaseTest {

    @Test
    public void loginTest1(){
        //авторизация
        LoginPage loginPage = new LoginPage(); //объект класса LoginPage
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginBtn();
        // проверка, что мы попали на страницу с продуктами
        ProductPage productsPage = new ProductPage();
        productsPage.verifyPageTitle();
    }


}
