package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int blacks, int whites) {
        this.console.writeln(MessageView.RESULT.getMessage()
                .replaceFirst("#blacks", "" + blacks)
                .replaceFirst("#whites", "" + whites));
    }

}
