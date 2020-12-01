package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class SessionBuilder {

    private Session session;
    private List<String> proposals;

    public SessionBuilder() {
        this.proposals = new ArrayList<>();
    }

    public Session build(StateValue stateValue, int seed) {
        this.session = new Session(seed);
        for (String proposal : this.proposals) {
            this.session.addProposedCombination(new ColorBuilder().build(proposal));
        }
        while (this.session.getValueState() != stateValue) {
            this.session.next();
        }
        return this.session;
    }

    public SessionBuilder addProposal(String proposal) {
        this.proposals.add(proposal);
        return this;
    }

}
