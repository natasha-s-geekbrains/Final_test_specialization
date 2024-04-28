package human_friends.model.service;

import human_friends.model.animal.Animal;
import human_friends.model.animal_builder.AnimalBuilder;
import human_friends.model.registry.Registry;

import java.time.LocalDate;

public class Service {

    private Registry registry;
    private AnimalBuilder builder;

    public Service() {
        registry = new Registry();
        builder = new AnimalBuilder();
    }

    public void addAnimal(String name, LocalDate birthdate, String type){
        Animal animal = builder.build(name, birthdate, type);
        registry.addAnimal(animal);
    }

    public String getAnimalListInfo() {
        return registry.getAnimalListInfo();
    }
}

