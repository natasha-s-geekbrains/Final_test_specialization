package human_friends.model.registry;

import human_friends.model.Animal;
import human_friends.model.AnimalCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry implements Iterable<Animal> {
    private List<Animal> animalList;

    public Registry() {
        this(new ArrayList<>());
    }

    public Registry(List<Animal> animalList) {
        this.animalList = animalList;
    }


    public Animal getByName(String name) {
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public String addAnimal(Animal animal) {
        animalList.add(animal);
        return "Животное успешно добавлено!";
    }

    public Animal getById(int animalId) {
        for (Animal animal : animalList) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

    public String getAnimalListInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список животных:\n");
        for (Animal animal : animalList) {
            sb.append(animal);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getAnimalListInfo();
    }

    @Override
    public Iterator<Animal> iterator() {
        return new AnimalIterator(animalList);
    }


    public String getAnimalCommandList(Animal animal) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список команд:\n");
        // assert animal != null;
        for (AnimalCommand animalCommand : animal.getAnimalCommandList()) {
            sb.append(animalCommand);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getCommandListInfo(int animalId) {
        Animal animal = getById(animalId);
        return getAnimalCommandList(animal);
    }

    public String addCommandToAnimal(int animalId, String strCommandId) {
        Animal animal = getById(animalId);
        AnimalCommand animalCommand = animal.getCommandNameFromCommandId(strCommandId);
        animal.addCommand(animalCommand);
        return "Команда успешно добавлена! Проверьте список команд животного (п.3 меню)";
    }
}
