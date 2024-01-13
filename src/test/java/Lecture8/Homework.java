package Lecture8;

import org.testng.annotations.Test;
import pageObjects.herokuapp.Navigation;

import static pageObjects.herokuapp.NavigationItems.*;

public class Homework {

    @Test
    public void taskB () {
        new Navigation().
                navigateTo(DUNAMIC_CONTROLS);

    }
}
