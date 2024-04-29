package human_friends.view.commands;

import human_friends.view.ConsoleUI;

public class GetAnimalListInfo extends Command {

    public GetAnimalListInfo(ConsoleUI consoleUI) {
        super("Вывести список всех животных, внесенных в реестр", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAnimalListInfo();
    }
}