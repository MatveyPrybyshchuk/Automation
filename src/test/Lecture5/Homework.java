package Lecture5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Homework {

    @BeforeTest
        public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
        public void test1() throws InterruptedException {
        //параметры пола
        //sendKeys("calc_roomwidth","6");
        //sendKeys("calc_roomheight","3");
        getWebDriver().findElement(By.name("calc_roomwidth")).click();
        var elem = getWebDriver().findElement(By.name("calc_roomwidth"));
        new Actions(getWebDriver()).doubleClick(elem);
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("2");




        //getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys("2");

        //параметры ламината
//        sendKeys("calc_lamwidth","1300");
//        sendKeys("calc_lamheight","192");
//        sendKeys("calc_inpack","12");
//        sendKeys("calc_price","500");
//        //укладка
//        selectUkladka("tow");
//        //смещение рядов
//        sendKeys("calc_bias", "300");
//        //Отступ от стены
//        sendKeys("calc_walldist", "10");
//
//        pressButton("[value='Рассчитать']");
//
//        //Actual Result:
//        List<String> actualResult = getActualData();
//        //Expected Result:
//        List<String> expectedResult = Arrays.asList(
//                "145.04 м2.",
//                "31 шт.",
//                "1 шт.",
//                "250250000 руб.",
//                "69 шт.",
//                "7 шт."
//        );
//        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterTest
        public void postconditions() {
        //getWebDriver().close();
    }



//    private void sendKeys(String locator, String value) {
//        getWebDriver().findElement(By.name(locator)).click();
//        getWebDriver().findElement(By.name(locator)).sendKeys(value);
//    }
//    private void selectUkladka(String value) {
//        Select selectUkladka = new Select(getWebDriver().findElement(By.name("calc_direct")));
//        selectUkladka.selectByValue(value);
//    }
//    private void pressButton(String selector) {
//        getWebDriver().findElement(By.cssSelector(selector)).click();
//    }
//
//    private List<String> getActualData() {
//        List<String> actualData = new ArrayList<>();
//        List<WebElement> resultFromPage = getWebDriver().findElements(By.cssSelector("span[id]"));
//        resultFromPage.forEach(element -> {
//            actualData.add(element.getText());
//            System.out.println(element.getText());
//        });
//        return actualData;
//    }
}