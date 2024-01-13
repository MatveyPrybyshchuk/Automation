package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;

public class HeaderPage extends BasePage {
    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");

    public void clickBasketBtn() {
        click(basketBtn);
    }

    public void clickNavigationBtn() {
        click(navigationBtn);
    }
}
