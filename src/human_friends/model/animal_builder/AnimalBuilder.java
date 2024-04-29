package human_friends.model.animal_builder;

import human_friends.model.Animal;

import java.time.LocalDate;

public class AnimalBuilder {
    private int id;

    public Animal build(String name, LocalDate birthdate, String type, String group) {
        return new Animal(id++, name, birthdate, type, group);
    }
}
