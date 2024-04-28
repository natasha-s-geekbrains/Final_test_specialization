package human_friends.animal_types;

import human_friends.Animal;

import java.time.LocalDate;

public class Dog extends Animal {

    private String type = "Dog";

    public Dog(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
