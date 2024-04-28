package human_friends.presenter;

import human_friends.model.service.Service;
import human_friends.ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
}
