package human_friends.view.counter;

public class Counter implements AutoCloseable {

    private int currentCounterValue = 0;

    @Override
    public void close() {
    }

    public void add() {
        currentCounterValue++;
    }

    public int getCurrentCounterValue() {
        return currentCounterValue;
    }
}


