package Lecture4;

import com.google.j2objc.annotations.Property;
import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static driver.SimpleDriver.getWebDriver;

import java.time.Duration;

public class Lecture4_2 {

    @BeforeTest
        public void precondotions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @BeforeMethod
        public void beforeMethod() {
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
        public void test1() {
        WebElement zip_code = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zip_code.sendKeys("1234");
        continueButton.click();
        pause(1);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertTrue(updatedZipCode.isDisplayed());
    }
    @Test
    public void test2() {
        WebElement zip_code = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zip_code.clear();
        zip_code.sendKeys("12345");
        continueButton.click();
        pause(1);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(updatedZipCode.isDisplayed());
    }
    @Test
    public void test3() {
        WebElement zip_code = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zip_code.clear();
        zip_code.sendKeys("123456");
        continueButton.click();
        pause(1);
        WebElement updatedZipCode = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(updatedZipCode.isDisplayed());
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
