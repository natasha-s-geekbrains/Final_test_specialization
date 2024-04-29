package human_friends.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private int id;
    private String name;
    private LocalDate birthDate;
    private List<String> commandList;
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

    public boolean addCommand(String command) {
        if (!commandList.contains(command)) {
            commandList.add(command);
            return true;
        }
        return false;
    }

    public List<String> getCommandList() {
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
}
