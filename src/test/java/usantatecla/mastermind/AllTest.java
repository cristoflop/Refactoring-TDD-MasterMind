package usantatecla.mastermind;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import usantatecla.mastermind.controllers.AllControllerTest;
import usantatecla.mastermind.models.AllModelTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllControllerTest.class,
        AllModelTest.class
})
public class AllTest {
}
