package human_friends.animal.types;

import human_friends.animal.Animal;

import java.time.LocalDate;

public class Cat extends Animal {

    private String type = "Cat";

    public Cat(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
