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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProposalControllerTest {

    private ColorBuilder colorBuilder;

    private final String winnerCombination = "rbgp";
    private final int seed = 30;
    private Session session;
    @Mock
    private ProposalView proposalView;
    @InjectMocks
    private ProposalController proposalController;

    @Before
    public void initMocks() {
        this.colorBuilder = new ColorBuilder();
        this.session = new SessionBuilder()
                .addProposal("rgbo")
                .addProposal("rgyb")
                .addProposal("ogyb")
                .addProposal("rpog")
                .addProposal("brog")
                .addProposal("ygpo")
                .addProposal("ypob")
                .addProposal("opbr")
                .addProposal("orbp")
                .build(StateValue.IN_GAME, this.seed);
        this.proposalController = new ProposalController(this.session);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenProposalControllerWhenContolThenReturnErrorIfProposalIsWrong() {
        when(this.proposalView.readProposal())
                .thenReturn(this.colorBuilder.build("gbopr"))
                .thenReturn(this.colorBuilder.build("gbop"));
        this.proposalController.readProposal();
        verify(this.proposalView).writeError(any());
        // verify(this.proposalView).writeAttempts(this.proposalController.getAttempts()); // AHORA ESTO PASA AL GAMEVIEW
    }

    @Test
    public void testGivenProposalControllerWhenControlThenCheckIfWin() {
        when(this.proposalView.readProposal())
                .thenReturn(this.colorBuilder.build("gbop"));
        this.proposalController.readProposal();
        assertFalse(this.proposalController.isWinner());
    }

    @Test
    public void testGivenProposalControllerWhenWinTheGameThenGameEnds() {
        System.out.println(this.session.getSecretCombination());
        when(this.proposalView.readProposal())
                .thenReturn(this.colorBuilder.build(this.winnerCombination));
        this.proposalController.readProposal();
        assertTrue(this.proposalController.isWinner());
    }

}
