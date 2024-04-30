package human_friends.model.service;

import human_friends.model.Animal;
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
        try {
            Animal animal = builder.build(name, birthdate, type, group);
            return registry.addAnimal(animal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAnimalListInfo() {
        return registry.getAnimalListInfo();
    }

    public String getCommandListInfo(int animalId) {
        return registry.getCommandListInfo(animalId);
    }

    public String addCommandToAnimal(int animalId, String strAnimalCommandNum) {
        return registry.addCommandToAnimal(animalId, strAnimalCommandNum);
    }

    public boolean ifAnimalIdValid(int animalId) {
        return registry.checkAnimalId(animalId);
    }

    public String getAnimalInfo(int idAnimal) {
        return registry.getAnimalInfo(idAnimal);
    }
}

