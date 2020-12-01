package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.types.Color;

public abstract class Combination {

    private static final int WIDTH = 4;

    protected List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<Color>();
    }

    public static int getWidth() {
        return Combination.WIDTH;
    }

    @Override
    public String toString() {
        return "{" +
                " colors = " + colors +
                " }";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Combination other = (Combination) obj;
        if (this.colors.size() != other.colors.size())
            return false;
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i) != other.colors.get(i))
                return false;
        }
        return true;
    }

}
