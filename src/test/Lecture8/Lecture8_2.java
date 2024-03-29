package Lecture8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.NavigationItems.*;

public class Lecture8_2 extends BaseTest {

    @BeforeMethod
    public void precondition() {
        new Navigation()
                .open();
    }

    @Test (enabled = false)
    public void dynamicLoading_Test() {
        new Navigation()
                .navigateTo(DYNAMIC_LOADING);
        String result = new DynamicLoadingPage()
                .clickOnExample("Example 1")
                .clickOnStart()
                .pageIsLoaded();


        System.out.println(result);
    }

    @Test (enabled = true)
    public void scrollPageTest() {
        new Navigation()
                .navigateTo(INFINITE_SCROLL);
        new InfiniteScrollPage().infiniteScroll(10);
    }

    @Test (enabled = false)
    public void contextMenu_Test() {
        new Navigation()
                .navigateTo(CONTEXT_MENU);
        new ContextMenuPage().clickContext().verifyAlert("You selected a context menu");
    }

    @Test (enabled = false)
    public void FrameTest() {
        new Navigation()
                .navigateTo(FRAMES);
        new FramesPage().
                clickFrameLink("iFrame").
                switchToFrame().
                enterText("Hello World!").
                unSwitchFrame().
                clickBoldText();
    }


}
