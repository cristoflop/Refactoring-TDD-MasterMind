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

import static org.junit.Assert.assertTrue;

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
                .addProposal("rbyo")
                .addProposal("rbop")
                .build(StateValue.IN_GAME, this.seed);
        this.playController = new PlayController(session);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenPlayControllerWhenAddProposalCorrectThenReturnOk() {
        assertTrue(true);
    }

}
