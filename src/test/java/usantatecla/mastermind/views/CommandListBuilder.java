package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.console.PlayCommand;
import usantatecla.mastermind.views.console.RedoCommand;
import usantatecla.mastermind.views.console.UndoCommand;
import usantatecla.utils.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandListBuilder {

    public List<Command> build(PlayController playController) {
        List<Command> commands = new ArrayList<>();

        PlayCommand playCommand = new PlayCommand(playController);
        commands.add(playCommand);

        UndoCommand undoCommand = new UndoCommand(playController);
        commands.add(undoCommand);

        RedoCommand redoCommand = new RedoCommand(playController);
        commands.add(redoCommand);

        return commands;
    }

}
