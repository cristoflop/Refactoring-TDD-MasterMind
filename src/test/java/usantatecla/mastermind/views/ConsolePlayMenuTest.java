package usantatecla.mastermind.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.views.console.ConsolePlayMenu;
import usantatecla.utils.Command;
import usantatecla.utils.Console;

import java.util.List;

import static org.mockito.Mockito.*;

public class ConsolePlayMenuTest {

    @Mock
    private List<Command> commands;
    @Mock
    private Console console;
    @Mock
    private PlayController playController;
    @InjectMocks
    private ConsolePlayMenu consolePlayMenu;

    @Before
    public void initMocks() {
        this.commands = new CommandListBuilder().build(this.playController);
        this.consolePlayMenu = new ConsolePlayMenu(playController);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenConsolePlayMenuWhenExecuteWithInvalidOptionThenError() {
        /*int expectedAttempts = this.playController.getAttempts() + 1;
        when(this.consoleMenu.read())
                .thenReturn(null)
                .thenReturn(new PlayCommand());*/
        /*when(this.proposalView.readProposal()).thenReturn(this.colorBuilder.build("rgby"));
        this.playController.control();
        assertEquals(this.playController.getAttempts(), expectedAttempts);
        verify(this.proposalView).writeError(any());*/
        // when(activeCommands.size()).thenReturn(3);

        when(this.console.readInt(anyString())).thenReturn(23).thenReturn(1);
        this.consolePlayMenu.execute();
        verify(this.playController).addProposedCombination();
    }

    @Test
    public void testGivenConsolePlayMenuWhenExecuteWithProposeOptionThenAddNewProposal() {
        when(this.console.readInt(anyString())).thenReturn(1);
        this.consolePlayMenu.execute();
        verify(this.playController).addProposedCombination();
    }

    @Test
    public void testGivenConsolePlayMenuWhenExecuteWithUndoOptionThenCallUndoMethod() {
        when(this.console.readInt(anyString())).thenReturn(2);
        this.consolePlayMenu.execute();
        verify(this.playController).undo();
    }

    @Test
    public void testGivenConsolePlayMenuWhenExecuteWithRedoOptionThenCallRedoMethod() {
        when(this.console.readInt(anyString())).thenReturn(3);
        this.consolePlayMenu.execute();
        verify(this.playController).redo();
    }


}
