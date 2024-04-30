package human_friends.view.commands;

import human_friends.view.ConsoleUI;

public class GetCommandListInfo extends Command {

    public GetCommandListInfo(ConsoleUI consoleUI) {
        super("Проверить список команд конкретного животного", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getCommandListInfo();
    }
}

