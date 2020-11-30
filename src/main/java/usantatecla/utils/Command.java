package usantatecla.utils;

public abstract class Command {

    private String title;

    public Command(String title) {
        this.title = title;
    }

    public abstract void execute();

    public abstract boolean isActive();

    public String getTitle() {
        return this.title;
    }

}
