package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;
import pageObjects.baseObjects.BaseTest;

public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.id("start");
    private By loading = By.id("loading");
    private By finish = By.id("finish");

    public By getByLink (String textlink) {
        return By.partialLinkText(textlink);
    }
    public DynamicLoadingPage clickOnExample(String text) {
        click(getByLink(text));
        return this;
    }
    public  DynamicLoadingPage clickOnStart() {
        actions.click(driver.findElement(startBtn)).build().perform();
        //click(startBtn);
        return this;
    }
    public String pageIsLoaded() {
        wait.until(ExpectedConditions.textToBe(loading, "Loading"));
        return getText(loading);
    }
}
