package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;
import usantatecla.utils.YesNoDialog;

public class ResumeView extends WithConsoleView {

    public boolean writeln() {
        return new YesNoDialog().read(MessageView.RESUME.getMessage());
    }

}
