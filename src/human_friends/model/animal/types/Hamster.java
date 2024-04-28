package human_friends.model.animal.types;

import human_friends.model.animal.Animal;

import java.time.LocalDate;

public class Hamster extends Animal {

    private String type = "Hamster";

    public Hamster(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
