package human_friends.view.commands;

import human_friends.view.ConsoleUI;

public class AddCommandToAnimal extends Command {

    public AddCommandToAnimal(ConsoleUI consoleUI) {
        super("Добавить новую выученную команду конкретному животному", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addCommandToAnimal();
    }
}

