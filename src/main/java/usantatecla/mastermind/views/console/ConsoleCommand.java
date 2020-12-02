package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Command;

public abstract class ConsoleCommand extends Command {

    protected PlayController playController;

    public ConsoleCommand(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }
}
