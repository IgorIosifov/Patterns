package ru.geekbrains.Lesson_3;

import java.util.List;

import static java.lang.Thread.sleep;

public class Operator extends Handler implements Person{

    private String name;
    private final double probability = 0.5;

    private List<String> requests;

    @Override
    public void handle(Request request) {
        if (!getRequests().contains(request.getReason()) && getNext() != null) {
            System.out.println(name + " :I'll redirect you");
            super.handle(request);
        } else {
            if(isBusy()) {
                System.out.println(name + ": I'm busy");
                super.handle(request);
            } else {
                System.out.println(name +" :I'll do it right now");

            System.out.println(getName() + " starts to work on job " + request.getReason());
            System.out.println(getName() + " finished to work on job " + request.getReason());
            }
        }
    }

    public Operator(String name, List<String> requests) {
        this.name = name;
        this.requests = requests;
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isBusy() {
        return Math.random() < probability;
    }

    public List<String> getRequests() {
        return requests;
    }
}
