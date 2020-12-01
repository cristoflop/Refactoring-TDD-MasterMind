package usantatecla.mastermind.models;

import org.junit.Before;
import org.junit.Test;
import usantatecla.mastermind.types.Error;

import static org.junit.Assert.*;

public class SessionTest {

    private ColorBuilder colorBuilder;
    private SessionBuilder sessionBuilder;
    private Session session;
    private Session expectedSession;
    private final int seed = 10;

    @Before
    public void before() {
        this.sessionBuilder = new SessionBuilder();
        this.colorBuilder = new ColorBuilder();
        this.session = sessionBuilder.build(StateValue.IN_GAME, this.seed);

    }

    @Test
    public void testGivenSessionWhenAddProposalCorrectThenOk() {
        this.addProposal("rgbo");
        this.setExpectedSession(this.sessionBuilder
                .addProposal("rgbo")
                .build(StateValue.IN_GAME, this.seed));
        assertEquals(this.session, this.expectedSession);
    }

    @Test
    public void testGivenSessionWhenAddProposalWrongLengthThenError() {
        Error error = this.addProposal("rgboy");
        assertNotNull(error);
        assertEquals(error, Error.WRONG_LENGTH);
    }

    @Test
    public void testGivenSessionWhenUndoThenUndoProposal() {
        this.setExpectedSession(this.sessionBuilder
                .addProposal("rgbo")
                .build(StateValue.IN_GAME, this.seed));
        this.expectedSession.undo();
        assertEquals(this.session, this.expectedSession);
    }

    @Test
    public void testGivenSessionWhenRedoThenRedoProposal() {
        this.addProposal("rgbo");
        this.setExpectedSession(this.sessionBuilder
                .addProposal("rgbo")
                .addProposal("rgpo")
                .build(StateValue.IN_GAME, this.seed));
        this.expectedSession.undo();
        this.expectedSession.redo();
        assertNotEquals(this.session, this.expectedSession);
    }

    @Test
    public void testGivenSessionWhenNextThenStateChange() {
        this.session.next();
        assertEquals(this.session.getValueState(), StateValue.FINAL);
    }

    private void setExpectedSession(Session session) {
        this.expectedSession = session;
    }

    private Error addProposal(String proposal) {
        return this.session.addProposedCombination(colorBuilder.build(proposal));
    }

}
