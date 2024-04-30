package human_friends.model.registry;

import human_friends.model.Animal;

import java.util.Iterator;
import java.util.List;

public class AnimalIterator implements Iterator<Animal> {

    private int index = 0;

    private List<Animal> animalList;

    public AnimalIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return index < animalList.size();
    }

    @Override
    public Animal next() {
        return animalList.get(index++);
    }
}
