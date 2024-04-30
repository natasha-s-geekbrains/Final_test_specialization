package human_friends.model.animal_builder;

import human_friends.model.Animal;
import human_friends.model.animal_counter.Counter;

import java.time.LocalDate;

public class AnimalBuilder {

    Counter counter = new Counter();

    private int getNextIdValue() {
        int nextIdValue = counter.getCurrentCounterValue();
        counter.add();
        return nextIdValue;
    }

    public Animal build(String name, LocalDate birthdate, String type, String group) {
        int id = getNextIdValue();
        return new Animal(id, name, birthdate, type, group);
    }
}
