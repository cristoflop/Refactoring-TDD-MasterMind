package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

public class RedoCommand extends ConsoleCommand {

    public RedoCommand(PlayController playController) {
        super(MessageView.REDO.getMessage(), playController);
    }

    public void execute() {
        this.playController.redo();
    }

    public boolean isActive() {
        return this.playController.redoable();
    }
}
