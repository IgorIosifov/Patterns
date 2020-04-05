package ru.geekbrains.Lesson_3;

import java.util.List;

public abstract class Handler {

    private Handler next;

    private boolean isBusy;

    public void handle (Request request) {
        if (next!=null) {
            next.handle(request);
        }
    }

    Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public Handler getNext() {
        return next;
    }

}
