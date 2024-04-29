package human_friends.view;

import human_friends.model.AnimalCommand;
import human_friends.presenter.Presenter;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в реестр домашних животных!");
        System.out.println("1. Добавить новое животное в реестр");
        System.out.println("2. Вывести список животных, внесенных в реестр");
        System.out.println("3. Посмотреть, какие команды выполняет конкретное животное" +
                "(для этого вам нужно знать ID животного. " +
                "Выберите пункт №2, чтобы узнать ID нужного вам животного.)");
        System.out.println("4. Добавить новую выученную команду конкретному животному");
        System.out.println("9. Завершить работу в реестре");
        System.out.println("Укажите номер пункта из меню выше:");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                addAnimal();
                break;
            case "2":
                getAnimalListInfo();
                break;
            case "3":
                getCommandListInfo();
                break;
            case "4":
                addCommandToAnimal();
                break;
            case "9":
                break;
        }
    }

    private void addCommandToAnimal() {
        System.out.println("Введите ID животного:");
        int animalId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите цифру команды, которую нужно добавить, из списка ниже:" +
                "1. Иди" +
                "2. Бежать" +
                "3. Стоять" +
                "4. Голос" +
                "5. Рядом" +
                "6. Взять" +
                "7. Сидеть:");
        String strCommandId = scanner.nextLine();
        presenter.addCommandToAnimal(animalId, strCommandId);
    }

    private void getCommandListInfo() {
        System.out.println("Введите ID животного:");
        int animalId = Integer.parseInt(scanner.nextLine());
        presenter.getCommandListInfo(animalId);
    }

    private void getAnimalListInfo() {
        presenter.getAnimalListInfo();
    }

    private void addAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите через тире год, месяц и день рождения животного (например, 2000-01-31):");
        String strDate = scanner.nextLine();
        System.out.println("Введите тип животного латинскими буквами (Dog, Cat или Hamster):");
        String type = scanner.nextLine();
        System.out.println("Введите группу животного латинскими буквами с пробелом" +
                "(home animal):");
        String group = scanner.nextLine();
        presenter.addAnimal(name, strDate, type, group);
    }

    @Override
    public void printAnswer(String answer) {
        if (answer != null) {
            System.out.println(answer);
        } else {
            errorText();
        }
    }

    private void errorText() {
        System.out.println("Введено неверное значение");
    }

}
