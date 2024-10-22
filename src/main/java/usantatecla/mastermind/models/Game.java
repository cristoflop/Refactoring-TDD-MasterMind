package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public class Game {

    private static final int MAX_LONG = 10;

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    public Game() {
        this.clear();
    }

    public Game(int seed) {
        this.clear(seed);
    }

    public void clear() {
        this.initSecretCombination(-1);
        this.init();
    }

    public void clear(int seed) {
        this.initSecretCombination(seed);
        this.init();
    }

    public void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    public boolean isLooser() {
        return this.attempts == Game.MAX_LONG;
    }

    public boolean isWinner() {
        return this.results.get(this.attempts - 1).isWinner();
    }

    public int getAttempts() {
        return this.attempts;
    }

    public List<Color> getColors(int position) {
        return this.proposedCombinations.get(position).colors;
    }

    public int getBlacks(int position) {
        return this.results.get(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.results.get(position).getWhites();
    }

    public int getWidth() {
        return Combination.getWidth();
    }

    public Combination getSecretCombination() {
        return this.secretCombination;
    }

    public GameMemento createMemento() {
        return new GameMemento(this.secretCombination, this.proposedCombinations, this.results, this.attempts);
    }

    public void set(GameMemento gameMemento) {
        this.secretCombination = gameMemento.getSecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>(gameMemento.getProposedCombinations());
        this.results = new ArrayList<Result>(gameMemento.getResults());
        this.attempts = gameMemento.getAttempts();
    }

    private void initSecretCombination(int seed) {
        if (seed == -1) {
            this.secretCombination = new SecretCombination();
        } else {
            this.secretCombination = new SecretCombination(seed);
        }
    }

    private void init() {
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
        this.attempts = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        return this.secretCombination.equals(other.secretCombination) &&
                this.proposedCombinations.equals(other.proposedCombinations);
    }

}
