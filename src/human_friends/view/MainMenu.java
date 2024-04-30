package human_friends.view;

import human_friends.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddAnimal(consoleUI));
        commands.add(new GetAnimalListInfo(consoleUI));
        commands.add(new AddCommandToAnimal(consoleUI));
        commands.add(new GetCommandListInfo(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ваши возможные действия:");
        sb.append("\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
