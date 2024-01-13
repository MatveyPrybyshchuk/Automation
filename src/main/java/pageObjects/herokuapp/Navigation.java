package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BaseTest;
import pageObjects.baseObjects.BasePage;

public class Navigation extends BasePage {

    public By getByLink (String textlink) {
        return By.partialLinkText(textlink);
    }
    public Navigation open() {
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public Navigation navigateTo (NavigationItems navigationItems) {
        click(getByLink(navigationItems.getItem()));
        return this;
    }
}
