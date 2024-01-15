package Lecture8;

import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import org.testng.annotations.Test;
import pageObjects.saucedemo.ProductPage;

public class Lecture8_1 extends BaseTest {

    @Test
    public void login() {
        new LoginPage()
                .open()
                .enterUsername("performance_glitch_user")
                .enterPassword("secret_sauce")
                .clickLoginBtn()
                .verifyLoginPageIsClosed();
        new ProductPage().verifyPageTitle();
    }
}
