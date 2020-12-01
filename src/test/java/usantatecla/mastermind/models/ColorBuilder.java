package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ColorView;

import java.util.ArrayList;
import java.util.List;

public class ColorBuilder {

    public static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    public List<Color> build(String colors) {
        List<Color> colorList = new ArrayList<>();
        for (char c : colors.toCharArray()) {
            for (int i = 0; i < ColorBuilder.INITIALS.length; i++) {
                if (ColorView.INITIALS[i] == c) {
                    colorList.add(Color.values()[i]);
                }
            }
        }
        return colorList;
    }

}
