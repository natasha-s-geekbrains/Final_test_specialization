package human_friends;

import java.time.LocalDate;

public class AnimalBuilder {
    private int id;
    public Animal build(String name, LocalDate birthdate, String type){
        return new Animal(id++, name, birthdate, type);
    }
}
