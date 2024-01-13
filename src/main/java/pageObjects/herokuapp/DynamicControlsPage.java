package pageObjects.herokuapp;

import org.openqa.selenium.By;

public class DynamicControlsPage {
    private By checkbox = By.id("checkbox"); //"//div[text()=' A checkbox']/input[@type='checkbox']" - для бокса и текста
    private By removeBtn = By.xpath("//form[@id='checkbox-example']/button[text()='Remove']");

    private By TextItsGone = By.id("message");
    private By inputField = By.xpath("//input[@type='text'] ");
    private By enableBtn = By.xpath("//form[@id='input-example']/button[text()='Enable']");
    private By enabmeStatus = By.xpath("//form[@id='input-example']/p[@id='message']");
}
