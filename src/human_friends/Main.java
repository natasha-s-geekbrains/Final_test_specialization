package human_friends;

import human_friends.model.service.Service;
import human_friends.view.ConsoleUI;
import human_friends.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();
    }
}