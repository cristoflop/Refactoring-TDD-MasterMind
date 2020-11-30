package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.views.console.ResumeView;

public class ResumeController extends Controller implements InteractorController {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void control() {
        ResumeView resumeView = new ResumeView();
        this.resume(resumeView.writeln());
        resumeView.newLine();
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.game.clear();
            this.state.reset();
        } else {
            this.state.next();
        }
    }

}
