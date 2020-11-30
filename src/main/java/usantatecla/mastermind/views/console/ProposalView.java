package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

import java.util.List;

public class ProposalView extends WithConsoleView {

    public List<Color> readProposal() {
        return new ProposedCombinationView().read();
    }

    public void writeColors(List<Color> colors) {
        new ProposedCombinationView().write(colors);
    }

    public void writeResult(int blacks, int whites) {
        new ResultView().writeln(blacks, whites);
    }

    public void writeError(Error error) {
        new ErrorView(error).writeln();
    }

    public void writeAttempts(int attempts) {
        new AttemptsView().writeln(attempts);
    }

    public void writeSecret(int width) {
        new SecretCombinationView().writeln(width);
    }

    public void writeWinner() {
        this.console.writeln(MessageView.WINNER.getMessage());
    }

    public void writeLoser() {
        this.console.writeln(MessageView.LOOSER.getMessage());
    }

}
