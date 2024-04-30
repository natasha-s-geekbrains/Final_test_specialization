package human_friends.presenter;

import human_friends.model.service.Service;
import human_friends.view.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Presenter {

    private View view;
    private Service service;
    private DateTimeFormatter formatter;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public void addAnimal(String name, String strDate, String type, String group) {
        LocalDate birthdate = LocalDate.parse(strDate, formatter);
        String answer = service.addAnimal(name, birthdate, type, group);
        view.printAnswer(answer);
    }

    public boolean strDateIsValid(String dateStr) {
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public boolean ifAnimalIdValid(int animalId) {
        return service.ifAnimalIdValid(animalId);
    }

    public void getAnimalInfo(int idAnimal) {
        String answer = service.getAnimalInfo(idAnimal);
        view.printAnswer(answer);
    }

    public boolean animalListIsEmpty() {
        return service.animalListIsEmpty();
    }
}


