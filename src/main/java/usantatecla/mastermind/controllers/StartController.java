package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.views.console.StartView;

public class StartController extends Controller implements InteractorController {

    public StartController(Session session) {
        super(session);
    }

    public void control() {
        this.start();
        StartView startView = new StartView();
        startView.writeln(this.getWidth());
        startView.writeSecretCombination(this.session.getSecretCombination().toString());
        startView.newLine();
    }

    public void start() {
        this.session.next();
    }

}
