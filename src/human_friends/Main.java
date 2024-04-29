package human_friends;

import human_friends.model.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        service.addAnimal(
                "Bobik", LocalDate.of(2022, 10, 12),"Dog", "home animal");
        service.addAnimal(
                "Murka", LocalDate.of(2021, 3, 26),"Cat", "home animal");
        service.addAnimal(
                "Hummi", LocalDate.of(2023, 12, 10),"Humster", "home animal");

        System.out.println(service.getAnimalListInfo());

    }
}