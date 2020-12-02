package usantatecla.mastermind;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import usantatecla.mastermind.controllers.AllControllerTest;
import usantatecla.mastermind.models.AllModelTest;
import usantatecla.mastermind.views.AllViewTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllControllerTest.class,
        AllModelTest.class,
        AllViewTest.class
})
public class AllTest {
}
