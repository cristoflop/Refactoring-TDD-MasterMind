package usantatecla.utils;

public abstract class WithConsoleView {

    protected Console console;

    protected WithConsoleView() {
        this.console = new Console();
    }

    public void newLine() {
        this.console.writeln();
    }

}
