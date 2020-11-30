package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {

    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;
    private int attempts;

    public GameMemento(SecretCombination secretCombination, List<ProposedCombination> proposedCombinations, List<Result> results, int attempts) {
        this.secretCombination = secretCombination.copy();
        this.proposedCombinations = new ArrayList<>(proposedCombinations);
        this.results = new ArrayList<>(results);
        this.attempts = attempts;
    }

    public SecretCombination getSecretCombination() {
        return secretCombination;
    }

    public List<ProposedCombination> getProposedCombinations() {
        return proposedCombinations;
    }

    public List<Result> getResults() {
        return results;
    }

    public int getAttempts() {
        return attempts;
    }

}
