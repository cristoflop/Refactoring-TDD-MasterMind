package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.console.ResumeView;

public class ResumeController extends Controller implements InteractorController {

    public ResumeController(Session session) {
        super(session);
    }

    public void control() {
        ResumeView resumeView = new ResumeView();
        this.resume(resumeView.writeln());
        resumeView.newLine();
    }

    public void resume(boolean newGame) {
        if (newGame) {
            this.session.reset();
        } else {
            this.session.next();
        }
    }

}
