package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.console.ConsolePlayMenu;
import usantatecla.mastermind.views.console.GameView;

import java.util.List;

public class PlayController extends Controller implements InteractorController {

    private ConsolePlayMenu consolePlayMenu;
    private GameView gameView;

    private ProposalController proposalController;
    private RedoController redoController;
    private UndoController undoController;

    PlayController(Session session) {
        super(session);
        this.consolePlayMenu = new ConsolePlayMenu(this);
        this.gameView = new GameView();
        this.proposalController = new ProposalController(session);
        this.redoController = new RedoController(session);
        this.undoController = new UndoController(session);
    }

    public void addProposedCombination() {
        this.proposalController.control();
        this.writeState();
    }

    public void undo() {
        this.undoController.undo();
        this.writeState();
    }


    public void redo() {
        this.redoController.redo();
        this.writeState();
    }

    public boolean isWinner() {
        return this.proposalController.isWinner();
    }

    public boolean isLooser() {
        return this.proposalController.isLooser();
    }

    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    public List<Color> getColors(int position) {
        return this.proposalController.getColors(position);
    }

    public int getBlacks(int position) {
        return this.proposalController.getBlacks(position);
    }

    public int getWhites(int position) {
        return this.proposalController.getWhites(position);
    }

    public boolean undoable() {
        return this.undoController.undoable();
    }

    public boolean redoable() {
        return this.redoController.redoable();
    }

    public void writeProposedCombinations() {
        for (int i = 0; i < this.getAttempts(); i++) {
            this.gameView.writeColors(this.getColors(i));
            this.gameView.writeResult(this.getBlacks(i), this.getWhites(i));
        }
    }

    public void writeIfWinner() {
        if (this.getAttempts() > 0 && this.isWinner()) {
            this.gameView.writeWinner();
        } else if (this.isLooser()) {
            this.gameView.writeLoser();
        }
    }

    public void writeState() {
        this.gameView.writeAttempts(this.getAttempts());
        this.gameView.writeSecret(this.getWidth());
        this.writeProposedCombinations();
        this.writeIfWinner();
        this.gameView.newLine();
    }

    @Override
    public void control() {
        this.consolePlayMenu.execute();
    }

}
