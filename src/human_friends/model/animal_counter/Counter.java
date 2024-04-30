package human_friends.model.animal_counter;

public class Counter implements AutoCloseable {

    private int currentCounterValue = 0;

    @Override
    public void close() throws Exception {
        System.out.println("Counter closed!");
    }

    public void add(){
        currentCounterValue ++;
    }

    public int getCurrentCounterValue() {
        return currentCounterValue;
    }
}
