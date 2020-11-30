package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {


    public void writeln(int width) {
        for (int i = 0; i < width; i++) {
            this.console.write(MessageView.SECRET.getMessage());
        }
        this.console.writeln();
    }

    public void writeSecretCombination(String combination) {
        this.console.writeln(combination);
    }

}
