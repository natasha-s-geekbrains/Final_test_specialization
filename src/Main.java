import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();
        service.addAnimal("Bobik", LocalDate.of(2022, 10, 12),"Dog");
        service.addAnimal("Murka", LocalDate.of(2021, 3, 26),"Cat");
        service.addAnimal("Hummi", LocalDate.of(2023, 12, 10),"Humster");

        System.out.println(service.getAnimalListInfo());

    }
}