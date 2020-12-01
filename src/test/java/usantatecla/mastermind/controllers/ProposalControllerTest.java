package usantatecla.mastermind.controllers;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.console.ProposalView;

import static org.junit.Assert.assertTrue;

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

    @Test
    public void test() {
        assertTrue(true);
    }

}
