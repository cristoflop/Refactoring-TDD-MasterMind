package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class AttemptsView extends WithConsoleView {

    void writeln(int attempts) {
        this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
                "" + attempts));
    }

}
