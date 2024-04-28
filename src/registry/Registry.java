package registry;

import human_friends.Animal;
import human_friends.AnimalIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Registry implements Iterable<Animal>{
    private List<Animal> animalList;

    public Registry() {
        this(new ArrayList<>());
    }
    public Registry(List<Animal> animalList){
        this.animalList = animalList;
    }

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    public Animal getByName(String name){
        for (Animal animal: animalList){
            if (animal.getName().equals(name)){
                return animal;
            }
        }
        return null;
    }

    public Animal getById(int idAnimal){
        for (Animal animal: animalList){
            if (animal.getId() == idAnimal){
                return animal;
            }
        }
        return null;
    }

    public String getAnimalListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список животных:\n");
        for (Animal animal: animalList){
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
}
