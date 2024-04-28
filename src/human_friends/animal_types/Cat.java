package human_friends.animal_types;

import human_friends.Animal;

import java.time.LocalDate;

public class Cat extends Animal {

    private String type = "Cat";

    public Cat(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
