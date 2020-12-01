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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProposalControllerTest {

    private ColorBuilder colorBuilder;

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
                .build(StateValue.IN_GAME, this.seed);
        this.proposalController = new ProposalController(this.session);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenProposalControllerWhenContolThenReturnErrorIfProposalIsWrong() {
        when(this.proposalView.readProposal())
                .thenReturn(this.colorBuilder.build("gbopr"))
                .thenReturn(this.colorBuilder.build("gbop"));
        this.proposalController.control();
        verify(this.proposalView).writeError(any());
        verify(this.proposalView).writeAttempts(this.proposalController.getAttempts());
    }

    @Test
    public void testGivenProposalControllerWhenContolThenCheckIfWin() {
        when(this.proposalView.readProposal())
                .thenReturn(this.colorBuilder.build("gbop"));
        this.proposalController.control();
        assertFalse(this.proposalController.isWinner());
    }

}
