package Lecture9;

import org.testng.annotations.*;

public class Lecture9_1Test {

    @BeforeTest(groups = "test9")
    public void beforeTest () {
        System.out.println("Hello im BeforeTest");
    }

    @BeforeMethod(groups = {"test9new", "test9"})
    public void beforeMethod () {
        System.out.println("Hello im BeforeMethod");
    }

    @BeforeClass(groups = "test9")
    public void beforeClass () {
        System.out.println("Hello im BeforeClass");
    }

    @BeforeSuite(groups = "test9")
    public void beforeSuite () {
        System.out.println("Hello im BeforeSuite");
    }

    @BeforeGroups(groups = "test9")
    public void beforeGroups () {
        System.out.println("Hello im BeforeGroups");
    }

    @Test(groups = "test9")
    public void test1() {
        System.out.println("Hello im @Test 1");
    }

    @Test(groups = "test9new")
    public void test2() {
        System.out.println("Hello im @Test 2");
    }

    @AfterTest(groups = "test9")
    public void afterTest() {
        System.out.println("Hello im AfterTest");
    }

    @AfterSuite(groups = "test9")
    public void afterSuite() {
        System.out.println("Hello im AfterSuite");
    }

    @AfterGroups(groups = "test9")
    public void afterGroups() {
        System.out.println("Hello im AfterGroups");
    }

    @AfterMethod(groups = {"test9new", "test9"})
    public void afterMethod() {
        System.out.println("Hello im AfterMethod");
    }

    @AfterClass(groups = "test9")
    public void afterClass() {
        System.out.println("Hello im AfterClass");
    }
}
