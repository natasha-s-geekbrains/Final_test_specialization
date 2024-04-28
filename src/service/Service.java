package service;

import human_friends.Animal;
import human_friends.AnimalBuilder;
import registry.Registry;

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

