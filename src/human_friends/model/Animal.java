package human_friends.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private int id;
    private String name;
    private LocalDate birthDate;
    private List<AnimalCommand> commandList;
    private String type;
    private String group;

    public Animal(int id, String name, LocalDate birthDate, String type, String group) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
        this.group = group;
        commandList = new ArrayList<>();
    }

    public Animal(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        commandList = new ArrayList<>();
    }

    public Animal() {
    }

    public boolean addCommand(AnimalCommand animalCommand) {
        if (!commandList.contains(animalCommand)) {
            commandList.add(animalCommand);
            return true;
        }
        return false;
    }

    public List<AnimalCommand> getAnimalCommandList() {
        return commandList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Animal { "
                + "Group: "
                + group
                + ", Type: "
                + type + ", id: "
                + id + ", name: "
                + name
                + ", Date of Birth: "
                + birthDate + " }";
    }

    public AnimalCommand getCommandNameFromCommandId(int animalCommandId) {
        AnimalCommand animalCommand = switch (animalCommandId) {
            case 1 -> AnimalCommand.Go;
            case 2 -> AnimalCommand.Run;
            case 3 -> AnimalCommand.Stay;
            case 4 -> AnimalCommand.Voice;
            case 5 -> AnimalCommand.Near;
            case 6 -> AnimalCommand.Take;
            case 7 -> AnimalCommand.Sit;
            default -> throw new IllegalStateException("Unexpected value: " + animalCommandId);
        };
        return animalCommand;
    }
}
