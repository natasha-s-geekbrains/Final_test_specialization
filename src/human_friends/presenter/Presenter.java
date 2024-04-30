package human_friends.presenter;

import human_friends.model.service.Service;
import human_friends.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addAnimal(String name, String strDate, String type, String group) {
        LocalDate birthDate = getLocalDate(strDate);
        String answer = service.addAnimal(name, birthDate, type, group);
        view.printAnswer(answer);
    }

    private LocalDate getLocalDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(strDate, formatter);
    }

    public void getAnimalListInfo() {
        String answer = service.getAnimalListInfo();
        view.printAnswer(answer);
    }

    public void getCommandListInfo(int animalId) {
        String answer = service.getCommandListInfo(animalId);
        view.printAnswer(answer);
    }

    public void addCommandToAnimal(int animalId, String strAnimalCommandNum) {
        String answer = service.addCommandToAnimal(animalId, strAnimalCommandNum);
        view.printAnswer(answer);
    }
}
