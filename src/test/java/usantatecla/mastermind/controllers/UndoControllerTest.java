package usantatecla.mastermind.controllers;

import org.junit.Before;
import org.junit.Test;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionBuilder;
import usantatecla.mastermind.models.StateValue;

import static org.junit.Assert.assertEquals;

public class UndoControllerTest {

    private final int seed = 1;
    private Session session;
    private UndoController undoController;

    @Before
    public void before() {
        this.session = new SessionBuilder().addProposal("rgby").build(StateValue.IN_GAME, this.seed);
        this.undoController = new UndoController(this.session);
    }

    @Test
    public void testGivenRedoControllerWhenRedoThenGameChange() {
        Session expectedSession = new SessionBuilder().build(StateValue.IN_GAME, this.seed);
        this.redoController.undo();
        assertEquals(this.session, expectedSession);
    }

}
