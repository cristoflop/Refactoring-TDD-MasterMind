package usantatecla.mastermind.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.console.PlayCommand;

import static org.mockito.Mockito.verify;

public class PlayCommandTest {

    @Mock
    private PlayController playController;
    @InjectMocks
    private PlayCommand playCommand;

    @Before
    public void intiMocks() {
        this.playCommand = new PlayCommand(this.playController);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayCommandWhenAddNewProposalThenCallMethodToAddNewProposal() {
        this.playCommand.execute();
        verify(this.playController).addProposedCombination();
    }

}
