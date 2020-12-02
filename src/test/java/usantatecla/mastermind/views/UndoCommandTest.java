package usantatecla.mastermind.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.console.UndoCommand;

import static org.mockito.Mockito.verify;

public class UndoCommandTest {

    @Mock
    private PlayController playController;
    @InjectMocks
    private UndoCommand undoCommand;

    @Before
    public void intiMocks() {
        this.undoCommand = new UndoCommand(this.playController);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayCommandWhenAddNewProposalThenCallMethodToAddNewProposal() {
        this.undoCommand.execute();
        verify(this.playController).undo();
    }

}
