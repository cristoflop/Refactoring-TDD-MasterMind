package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

import java.util.List;

public class ProposalView extends GameView {

    public List<Color> readProposal() {
        return new ProposedCombinationView().read();
    }

}
