package Lecture5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static driver.SimpleDriver.getWebDriver;

public class Lecture5_2 {

    @BeforeTest
        public void precondotions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://13gp.by/%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8F/%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%B8%D0%B5-%D0%BA%D0%B0%D0%BB%D1%8C%D0%BA%D1%83%D0%BB%D1%8F%D1%82%D0%BE%D1%80%D1%8B/%D1%80%D0%B0%D1%81%D1%87%D0%B5%D1%82-%D1%81%D0%BA%D0%BE%D1%80%D0%BE%D1%81%D1%82%D0%B8-%D0%BA%D0%BB%D1%83%D0%B1%D0%BE%D1%87%D0%BA%D0%BE%D0%B2%D0%BE%D0%B9-%D1%84%D0%B8%D0%BB%D1%8C%D1%82%D1%80%D0%B0%D1%86%D0%B8%D0%B8-%D1%81%D0%BA%D1%84");    }

    @Test
        public void  test1() {
        //женский
        select("1");
        enter("oCr", "75");
        enter("oAge", "23");
        enter("oWeight", "55");
        enter("oHeight", "170");
        submit();

        List<String> actualData = getActualData();
        List<String> expectedData = new ArrayList<>() {{
            add("MDRD: 88 (мл/мин/1,73кв.м)");
            add("ХБП: 2 стадия (при наличии почечного повреждения)");
            add("Cockroft-Gault: 86 (мл/мин)");
            add("Поверхность тела:1.63 (кв.м)");
        }};
        Assert.assertEquals(actualData, expectedData);
    }

    @Test
    public void  test2() {
        //мужской
        select("0");
        enter("oCr", "68");
        enter("oAge", "27");
        enter("oWeight", "78");
        enter("oHeight", "179");
        submit();

        List<String> actualData = getActualData();
        List<String> expectedData = Arrays.asList(
                "MDRD: 96 (мл/мин/1,73кв.м)",
                "ХБП: 1 стадия (при наличии почечного повреждения)",
        "Cockroft-Gault: 130 (мл/мин)",
        "Поверхность тела:1.97 (кв.м)"
        );

        Assert.assertEquals(actualData, expectedData);
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    private void enter(String id, String value) {
        getWebDriver().findElement(By.id(id)).clear();
        getWebDriver().findElement(By.id(id)).sendKeys(value);
    }
    private void select(String value) {
        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue(value);
    }
    private List<String> getActualData() {
        List<String> actualData = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("li div[id]"));

        result.forEach(webElement -> {
            System.out.println(webElement.getText());
            actualData.add(webElement.getText());
        });
        return actualData;
    }
    private void submit() {
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
    }
}
