package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.console.StartView;

public class StartController extends Controller implements InteractorController {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void control() {
        this.start();
        StartView startView = new StartView();
        startView.writeln(this.getWidth());
        startView.writeSecretCombination(this.game.getSecretCombination().toString());
        startView.newLine();
    }

    public void start() {
        this.state.next();
    }

}
