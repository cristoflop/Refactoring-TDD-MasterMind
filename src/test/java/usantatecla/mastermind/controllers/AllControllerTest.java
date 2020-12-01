package usantatecla.mastermind.controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProposalControllerTest.class,
        RedoControllerTest.class,
        UndoControllerTest.class,
        PlayController.class
})
public final class AllControllerTest {
}