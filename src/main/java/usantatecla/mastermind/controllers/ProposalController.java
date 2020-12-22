package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.console.ProposalView;

import java.util.List;

public class ProposalController extends Controller {

    private ProposalView proposalView;

    public ProposalController(Session session) {
        super(session);
        this.proposalView = new ProposalView();
    }

    public Error addProposedCombination(List<Color> colors) {
        return this.session.addProposedCombination(colors);
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public boolean isLooser() {
        return this.session.isLooser();
    }

    public int getAttempts() {
        return this.session.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.session.getColors(position);
    }

    public int getBlacks(int position) {
        return this.session.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.session.getWhites(position);
    }

    public void control() {
        Error error;
        do {
            List<Color> colors = this.proposalView.readProposal();
            error = this.addProposedCombination(colors);
            if (error != null) {
                this.proposalView.writeError(error);
            }
        } while (error != null);
        this.proposalView.newLine();
    }


}
