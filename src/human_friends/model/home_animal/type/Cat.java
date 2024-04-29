package human_friends.model.home_animal.type;

import human_friends.model.Animal;

import java.time.LocalDate;

public class Cat extends Animal {

    private String type = "cat";
    private String group = "home animal";

    public Cat(int id, String name, LocalDate birthDate, String type, String group) {
        super(id, name, birthDate);
        this.type = type;
        this.group = group;
    }
}
