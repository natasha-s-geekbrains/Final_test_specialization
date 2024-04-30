package human_friends.model.home_animal.type;

import human_friends.model.Animal;

import java.time.LocalDate;

public class Dog extends Animal {
    /*
     * не справилась использовать эти классы: не хватило опыта и времени */
    private String type = "dog";
    private String group = "home animal";

    public Dog(int id, String name, LocalDate birthDate, String type, String group) {
        super(id, name, birthDate);
        this.type = type;
        this.group = group;
    }
}
