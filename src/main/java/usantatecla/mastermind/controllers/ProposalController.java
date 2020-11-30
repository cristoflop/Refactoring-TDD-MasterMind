package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.console.ProposalView;

import java.util.List;

public class ProposalController extends Controller implements InteractorController {

    private ProposalView proposalView;

    public ProposalController(Game game, State state) {
        super(game, state);
        this.proposalView = new ProposalView();
    }

    public void control() {
        this.readProposal(this.proposalView);
        this.proposalView.writeAttempts(this.getAttempts());
        this.proposalView.writeSecret(this.getWidth());
        this.writeProposedCombinations(this.proposalView);
        this.writeIfWinner(this.proposalView);
        this.proposalView.newLine();
    }

    public Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i + 1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error == null) {
            this.game.addProposedCombination(colors);
            if (this.game.isWinner() || this.game.isLooser()) {
                this.state.next();
            }
        }
        return error;
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }

    public int getBlacks(int position) {
        return this.game.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.game.getWhites(position);
    }

    public void readProposal(ProposalView proposalView) {
        Error error;
        do {
            List<Color> colors = proposalView.readProposal();
            error = this.addProposedCombination(colors);
            if (error != null) {
                proposalView.writeError(error);
            }
        } while (error != null);
        proposalView.newLine();
    }

    public void writeProposedCombinations(ProposalView proposalView) {
        for (int i = 0; i < this.getAttempts(); i++) {
            proposalView.writeColors(this.getColors(i));
            proposalView.writeResult(this.getBlacks(i), this.getWhites(i));
        }
    }

    public void writeIfWinner(ProposalView proposalView) {
        if (this.isWinner()) {
            proposalView.writeWinner();
        } else if (this.isLooser()) {
            proposalView.writeLoser();
        }
    }

}
