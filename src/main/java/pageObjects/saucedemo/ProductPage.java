package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage extends BasePage {
    private final By title = By.xpath("//span[@class='title']"); //значение доступно только в данном классе не может быть изменено в будущем

    //метод, который позволяет обратиться к форме товара
    private WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class='inventory_item_name' and text()='"+ productName +"']/ancestor::div[@class='inventory_item']"));
    }

    private WebElement getProductPrice(String productName) {
        return getElementProduct(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement(By.tagName("button"));
    }


    //тк uri уникальна для данной страницы, проверку можно вызвать при создании сущности
    public ProductPage() {
        verifyPageUri();
    }


    //проверка Uri страницы
    public void verifyPageUri() {
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("inventory.html"));
    }

    //метод, который проверяет что title существует(т.е текст из элемента title соответствует PRODUCTS
    public void verifyPageTitle(){
        Assert.assertEquals(getWebDriver().findElement(title).getText(), "Products");
    }

    public void addProductToBasket(String productName) {
        click(getAddToCartBtn(productName));
    }

    public String getProductCost(String productName) {
        return getText(getProductPrice(productName));
    }
}