package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;

public abstract class Controller {

    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void next() {
        this.state.next();
    }

    public void clear() {
        this.game.clear();
    }

}
