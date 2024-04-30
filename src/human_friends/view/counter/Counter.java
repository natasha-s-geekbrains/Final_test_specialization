package human_friends.view.counter;

public class Counter implements AutoCloseable {

    private int currentCounterValue = 0;

    @Override
    public void close() {
        System.out.println("Counter closed!");
        System.out.println(currentCounterValue);
    }

    public void add() {
        currentCounterValue++;
    }
}

