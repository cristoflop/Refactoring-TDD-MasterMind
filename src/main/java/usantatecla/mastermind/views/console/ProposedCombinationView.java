package usantatecla.mastermind.views.console;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.MessageView;
import usantatecla.utils.WithConsoleView;

import java.util.ArrayList;
import java.util.List;

class ProposedCombinationView extends WithConsoleView {

    void write(List<Color> colors) {
        for (Color color : colors) {
            new ColorView(color).write();
        }
    }

    List<Color> read() {
        String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
        List<Color> colors = new ArrayList<Color>();
        for (int i = 0; i < characters.length(); i++) {
            colors.add(ColorView.getInstance(characters.charAt(i)));
        }
        return colors;
    }

}
