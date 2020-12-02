package usantatecla.mastermind.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.models.ColorBuilder;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.SessionBuilder;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.views.console.ConsolePlayMenu;
import usantatecla.mastermind.views.console.GameView;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.verify;

public class PlayControllerTest {

    private int seed = 20;
    private ColorBuilder colorBuilder;
    private Session session;

    @Mock
    private ConsolePlayMenu consoleMenu;
    @Mock
    private GameView gameView;
    @Mock
    private ProposalController proposalController;
    @Mock
    private RedoController redoController;
    @Mock
    private UndoController undoController;
    @InjectMocks
    private PlayController playController;

    @Before
    public void initMocks() {
        this.colorBuilder = new ColorBuilder();
        this.session = new SessionBuilder()
                .addProposal("rgbo")
                .build(StateValue.IN_GAME, this.seed);
        this.playController = new PlayController(session);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayControllerWhenTryToUndoWithOneProposalThenReturnNotUndoableAgain() {
        this.playController.undo();
        assertFalse(this.playController.undoable());
    }

    @Test(expected = Exception.class)
    public void testGivenPlayControllerWhenTryToRedoWithoutProposalThenReturnError() {
        this.session.redo();
    }

    @Test(expected = Exception.class)
    public void testGivenPlayControllerWhenTryToUndoWithoutPossibilitiesThenThrowException() {
        this.session.undo();
        this.session.undo();
    }

    @Test
    public void testGivenPlayControllerWhenControlWithPlayOptionThenAddNewProposal() {
        this.playController.addProposedCombination();
        verify(this.proposalController).readProposal();
        verify(this.gameView).writeAttempts(this.playController.getAttempts());
    }

    @Test
    public void testGivenPlayControllerWhenControlWithUndoOptionThenUndoMovement() {
        this.playController.undo();
        verify(this.undoController).undo();
        verify(this.gameView).writeAttempts(this.playController.getAttempts());
    }

    @Test
    public void testGivenPlayControllerWhenControlWithRedoOptionThenRedoMovement() {
        this.playController.redo();
        verify(this.redoController).redo();
        verify(this.gameView).writeAttempts(this.playController.getAttempts());
    }

}
