package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ColorView;

import java.util.ArrayList;
import java.util.List;

public class ColorBuilder {

    public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    private List<Color> colors;

    public ColorBuilder() {
        this.colors = new ArrayList<>();
    }

    public List<Color> build(String colors) {
        this.colors.clear();
        for (char c : colors.toCharArray()) {
            for (int i = 0; i < ColorBuilder.INITIALS.length; i++) {
                if (ColorView.INITIALS[i] == c) {
                    this.colors.add(Color.values()[i]);
                }
            }
        }
        return this.colors;
    }

}
