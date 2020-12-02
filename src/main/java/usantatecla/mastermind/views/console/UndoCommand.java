package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.MessageView;

public class UndoCommand extends ConsoleCommand {

    public UndoCommand(PlayController playController) {
        super(MessageView.UNDO.getMessage(), playController);
    }

    public void execute() {
        this.playController.undo();
    }

    public boolean isActive() {
        return this.playController.undoable();
    }
}
