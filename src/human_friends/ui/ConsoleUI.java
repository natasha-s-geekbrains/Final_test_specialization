package human_friends.ui;

import human_friends.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }
    @Override
    public void start() {
        System.out.println("Добро пожаловать! Укажите номер пункта меню:");
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
