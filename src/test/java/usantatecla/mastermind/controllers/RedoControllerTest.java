package usantatecla.mastermind.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionBuilder;
import usantatecla.mastermind.models.StateValue;

import static org.junit.Assert.assertEquals;

public class RedoControllerTest {

    private final int seed = 1;
    private Session session;
    private RedoController redoController;

    @Before
    public void before() {
        this.session = new SessionBuilder().addProposal("rgby").build(StateValue.IN_GAME, this.seed);
        this.redoController = new RedoController(this.session);
    }

    @Test
    public void testGivenRedoControllerWhenRedoThenGameChange() {
        Session expectedSession = new SessionBuilder().addProposal("rgby").build(StateValue.IN_GAME, this.seed);
        this.session.undo();
        this.redoController.redo();
        assertEquals(this.session, expectedSession);
    }

}
