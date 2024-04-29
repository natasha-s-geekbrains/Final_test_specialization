package human_friends.view;

import human_friends.model.AnimalCommand;
import human_friends.presenter.Presenter;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в реестр домашних животных!");
        while (work) {
            printMenu();
            choice();
        }
    }

    private void choice() {
        String strChoice = scanner.nextLine();
        if (isNumeric(strChoice)) {
            int choice = Integer.parseInt(strChoice);
            if (choiceInMenu(choice)) {
                menu.execute(choice);
            }
        }
    }

    private boolean choiceInMenu(int choice) {
        if (choice <= menu.size()) {
            return true;
        } else {
            errorText();
            return false;
        }
    }

    private void printMenu() {
        System.out.println( menu.menu());
        System.out.println("Укажите номер пункта из меню выше:");
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void addCommandToAnimal() {
        System.out.println("Введите ID животного:");
        int animalId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите цифру команды, которую нужно добавить, из списка ниже:\n" +
                "1. Иди\n" +
                "2. Бежать\n" +
                "3. Стоять\n" +
                "4. Голос\n" +
                "5. Рядом\n" +
                "6. Взять\n" +
                "7. Сидеть:");
        String strAnimalCommandId = scanner.nextLine();
        if (isNumeric(strAnimalCommandId)) {
            int animalCommandId = Integer.parseInt(scanner.nextLine());
            presenter.addCommandToAnimal(animalId, animalCommandId);
        }
    }

    public void getCommandListInfo() {
        System.out.println("Введите ID животного:");
        String animalId = scanner.nextLine();
        if (isNumeric(animalId)) {
            int idAnimal = Integer.parseInt(scanner.nextLine());
            presenter.getCommandListInfo(idAnimal);
        }
    }

    public void getAnimalListInfo() {
        presenter.getAnimalListInfo();
    }

    public void addAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите через тире год, месяц и день рождения животного (например, 2000-01-31):");
        String strDate = scanner.nextLine();
        System.out.println("Введите тип животного латинскими буквами (dog, cat или hamster):");
        String type = scanner.nextLine();
        System.out.println("У нас пока только одна группа, поэтому введите латинскими буквами с пробелом\n " +
                "home animal:");
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
        System.out.println("Введено неверное значение\n");
    }

    public boolean isNumeric(String str) {
        if (str.matches("[0-9]+")) {
            return true;
        } else {
            errorText();
            return false;
        }
    }

}
