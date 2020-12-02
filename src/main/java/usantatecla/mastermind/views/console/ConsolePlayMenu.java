package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Menu;

public class ConsolePlayMenu extends Menu {

    public ConsolePlayMenu(PlayController playController) {
        this.addCommand(new PlayCommand(playController));
        this.addCommand(new RedoCommand(playController));
        this.addCommand(new UndoCommand(playController));
    }

}
