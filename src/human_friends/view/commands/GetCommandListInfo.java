package human_friends.view.commands;

import human_friends.view.ConsoleUI;

public class GetCommandListInfo extends Command {

    public GetCommandListInfo(ConsoleUI consoleUI) {
        super("Посмотреть, какие команды выполняет конкретное животное.\n" +
                "Для этого вам нужно знать ID животного =>\n" +
                "=> Выберите пункт №2, чтобы узнать ID нужного вам животного.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getCommandListInfo();
    }
}

