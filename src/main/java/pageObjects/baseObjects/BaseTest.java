package pageObjects.baseObjects;

import driver.SimpleDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static driver.SimpleDriver.getWebDriver;

// класс содержит методы, которые могут быть многократно использованы в конкретных классах страниц
public class BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("I started new wed driver!");
        new SimpleDriver(); //instance объекта обращение к конструктору объекта
    }

    @AfterTest
    public void stop() {
        System.out.println("I closed wed driver!");
        getWebDriver().quit();

    }
}
