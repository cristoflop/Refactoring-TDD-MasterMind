package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public int getWidth() {
        return this.session.getWidth();
    }

    public void next() {
        this.session.next();
    }

    public void clear() {
        this.session.reset();
    }

}
