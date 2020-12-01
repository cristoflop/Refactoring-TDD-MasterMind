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
import usantatecla.mastermind.views.console.ProposalView;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayControllerTest {

    private int seed = 20;
    private ColorBuilder colorBuilder;
    private Session session;

    @Mock
    private ConsoleMenu consoleMenu;
    @Mock
    private ProposalView proposalView;
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
        assertFalse(this.playController.isUndoable);
    }

    @Test(expected = Exception.class)
    public void testGivenPlayControllerWhenTryToRedoWithoutProposalThenReturnError() {
        this.playController.redo();
    }

    @Test
    public void testGivenPlayControllerWhenControlWithInvalidOptionThenError() {
        int expectedAttempts = this.playController.getAttempts() + 1;
        when(this.consoleMenu.read())
                .thenReturn(null)
                .thenReturn(new PlayCommand());
        when(this.proposalView.readProposal()).thenReturn(this.colorBuilder.build("rgby"));
        this.playController.control();
        assertEquals(this.playController.getAttempts(), expectedAttempts);
        verify(this.proposalView).writeError(any());
    }

    @Test
    public void testGivenPlayControllerWhenControlWithPlayOptionThenAddNewProposal() {
        int expectedAttempts = this.playController.getAttempts() + 1;
        when(this.consoleMenu.read()).thenReturn(new PlayCommand());
        when(this.proposalView.readProposal()).thenReturn(this.colorBuilder.build("rgby"));
        this.playController.control();
        assertEquals(this.playController.getAttempts(), expectedAttempts);
    }

    @Test
    public void testGivenPlayControllerWhenControlWithPlayOptionThenAddNewProposal() {
        int expectedAttempts = this.playController.getAttempts() + 1;
        when(this.consoleMenu.read()).thenReturn(new PlayCommand());
        when(this.proposalView.readProposal()).thenReturn(this.colorBuilder.build("rgby"));
        this.playController.control();
        assertEquals(this.playController.getAttempts(), expectedAttempts);
    }

    @Test
    public void testGivenPlayControllerWhenControlWithUndoOptionThenUndoMovement() {
        int expectedAttempts = this.playController.getAttempts() - 1;
        when(this.consoleMenu.read()).thenReturn(new UndoCommand());
        this.playController.control();
        assertEquals(this.playController.getAttempts(), expectedAttempts);
    }

}
