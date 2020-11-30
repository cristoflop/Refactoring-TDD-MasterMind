package usantatecla.mastermind.controllers;


import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.console.ProposalView;

public class ProposalControllerTest {

    private Session session;
    private State state;
    private Game game;
    @Mock
    private ProposalView proposalView;
    @InjectMocks
    private ProposalController proposalController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

}
