package human_friends.animal_types;

import human_friends.Animal;

import java.time.LocalDate;

public class Hamster extends Animal {

    private String type = "Hamster";

    public Hamster(int id, String name, LocalDate birthDate, String type) {
        super(id, name, birthDate);
        this.type = type;
    }
}
