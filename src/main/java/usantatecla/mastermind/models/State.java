package usantatecla.mastermind.models;

public class State {

    private StateValue stateValue;

    public State() {
        this.stateValue = StateValue.INITIAL;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
    }

    public void reset() {
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        State other = (State) obj;
        return this.stateValue == other.stateValue;
    }
}
