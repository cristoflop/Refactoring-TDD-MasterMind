package usantatecla.mastermind.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.console.RedoCommand;

import static org.mockito.Mockito.verify;

public class RedoCommandTest {

    @Mock
    private PlayController playController;
    @InjectMocks
    private RedoCommand redoCommand;

    @Before
    public void intiMocks() {
        this.redoCommand = new RedoCommand(this.playController);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayCommandWhenAddNewProposalThenCallMethodToAddNewProposal() {
        this.redoCommand.execute();
        verify(this.playController).redo();
    }

}
