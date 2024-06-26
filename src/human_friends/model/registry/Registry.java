package human_friends.model.registry;

import human_friends.model.Animal;
import human_friends.model.AnimalCommand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry implements Iterable<Animal> {
    private List<Animal> animalList;

    public Registry() {
        animalList = new ArrayList<>();
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
        if (checkAnimalId(animalId)) {
            for (Animal animal : animalList) {
                if (animal.getId() == animalId) {
                    return animal;
                }
            }
        }
        return null;
    }

    public boolean checkAnimalId(int id) {
        if (id >= animalList.size() || id < 0) {
            return false;
        }
        for (Animal animal : animalList) {
            if (animal.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String getAnimalListInfo() {
        String emptyList = "Список животных пуст!";
        if (animalList.isEmpty()) {
            return emptyList;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Список животных:\n");
            for (Animal animal : animalList) {
                sb.append(animal);
                sb.append("\n");
            }
            return sb.toString();
        }
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
        String emptyList = "Список команд пуст!";
        if (animal.getAnimalCommandList().isEmpty()) {
            return emptyList;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Список команд:\n");
            for (AnimalCommand animalCommand : animal.getAnimalCommandList()) {
                sb.append("***" + animalCommand);
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public String getCommandListInfo(int animalId) {
        String answer = "Сожалеем, но животного с таким ID нет в реестре.";
        Animal animal;
        if (getById(animalId) == null) {
            return answer;
        } else
            animal = getById(animalId);
        return getAnimalCommandList(animal);
    }

    public String addCommandToAnimal(int animalId, String strAnimalCommandNum) {
        Animal animal;
        animal = getById(animalId);
        if (animal.getCommandNameFromCommandId(strAnimalCommandNum) == null) {
            return "Сожалеем, вы ввели неверный номер команды";
        } else {
            AnimalCommand animalCommand = animal.getCommandNameFromCommandId(strAnimalCommandNum);
            animal.addCommand(animalCommand);
            StringBuilder sb = new StringBuilder();
            sb.append("Команда успешно добавлена!\n");
            sb.append(animal);
            sb.append("\n");
            sb.append(getCommandListInfo(animalId));
            return sb.toString();
        }
    }

    public String getAnimalInfo(int idAnimal) {
        Animal animal = getById(idAnimal);
        return String.valueOf(animal);
    }

    public boolean animalListIsEmpty() {
        return animalList.isEmpty();
    }
}