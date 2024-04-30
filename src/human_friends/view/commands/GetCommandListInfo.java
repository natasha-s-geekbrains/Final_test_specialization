package human_friends.view.commands;

import human_friends.view.ConsoleUI;

public class GetCommandListInfo extends Command {

    public GetCommandListInfo(ConsoleUI consoleUI) {
        super("Проверить список команд конкретного животного.\n" +
                "Укажите ID животного из списка выше", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getCommandListInfo();
    }
}

