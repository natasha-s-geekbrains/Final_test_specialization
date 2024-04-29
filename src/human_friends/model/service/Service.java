package human_friends.model.service;

import human_friends.model.Animal;
import human_friends.model.AnimalCommand;
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

    public String addAnimal(String name, LocalDate birthdate, String type, String group) {
        Animal animal = builder.build(name, birthdate, type, group);
        return registry.addAnimal(animal);
    }

    public String getAnimalListInfo() {
        return registry.getAnimalListInfo();
    }

    public String getCommandListInfo(int animalId) {
        return registry.getCommandListInfo(animalId);
    }

    public String addCommandToAnimal(int animalId, int animalCommandId) {
        return registry.addCommandToAnimal(animalId, animalCommandId);
    }


}

