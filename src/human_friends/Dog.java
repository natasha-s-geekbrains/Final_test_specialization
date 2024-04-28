package human_friends;

import human_friends.Animal;

import java.time.LocalDate;

public class Dog extends Animal {

    private String type = "human_friends.Dog";

    public Dog(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
