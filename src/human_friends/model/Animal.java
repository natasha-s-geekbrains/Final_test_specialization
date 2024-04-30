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

    public AnimalCommand getCommandNameFromCommandId(String strAnimalCommandNum) {
        AnimalCommand animalCommand;
        switch (strAnimalCommandNum) {
            case "1":
                animalCommand  = AnimalCommand.Go;
                break;
            case "2":
                animalCommand  = AnimalCommand.Run;
                break;
            case "3":
                 animalCommand  = AnimalCommand.Stay;
                break;
            case "4":
                 animalCommand  = AnimalCommand.Voice;
                break;
            case "5":
                 animalCommand  = AnimalCommand.Near;
                break;
            case "6":
                 animalCommand  = AnimalCommand.Take;
                break;
            case "7":
                 animalCommand  = AnimalCommand.Sit;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strAnimalCommandNum);
        }
        return animalCommand;
    }
}
