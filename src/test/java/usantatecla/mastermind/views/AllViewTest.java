package usantatecla.mastermind.views;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RedoCommandTest.class,
        UndoCommandTest.class,
        PlayCommandTest.class
})
public class AllViewTest {
}
