package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class Session {

    private Game game;
    private State state;
    private GameRegistry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new GameRegistry(game);
    }

    public StateValue getValueState() {
        return this.state.getValueState();
    }

    public void next() {
        this.state.next();
    }

    public void reset() {
        this.game.clear();
        this.state.reset();
        this.registry = new GameRegistry(game);
    }

    public Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != this.getWidth()) {
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
            System.out.println("ESTA BIEN");
            this.game.addProposedCombination(colors);
            this.registry.register();
            if (this.game.isWinner() || this.game.isLooser()) {
                this.state.next();
            }
        } else {
            System.out.println("ESTA MAL");
        }
        return error;
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
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

    public Combination getSecretCombination() {
        return this.game.getSecretCombination();
    }

    public int getWidth() {
        return Combination.getWidth();
    }

    public void undo() {
        this.registry.undo();
    }

    public boolean undoable() {
        return this.registry.isUndoable();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.isRedoable();
    }

}
