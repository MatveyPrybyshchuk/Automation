package pageObjects.herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ContextMenuPage extends BasePage {
    private By hotspotMenu = By.id("hot-spot");

    public ContextMenuPage clickContext() {
        actions.contextClick(driver.findElement(hotspotMenu)).build().perform();
        return this;
    }

    public ContextMenuPage verifyAlert(String expectedText) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedText);
        alert.accept();
        return this;
    }
}
