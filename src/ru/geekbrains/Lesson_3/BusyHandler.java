package ru.geekbrains.Lesson_3;

import java.util.List;

public class BusyHandler extends Handler {

    private Request request;

    private List<String> responsibilities;

    public BusyHandler(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public void handle(Request request) {
        if(this.request == request) {
            System.out.println("All operators are busy, please wait");
            super.handle(request);
        } else if (!responsibilities.contains(request.getReason())) {
            System.out.println("Sorry, I need to consulate with my boss");
        } else {
            this.request = request;
            super.handle(request);
        }
    }
}
