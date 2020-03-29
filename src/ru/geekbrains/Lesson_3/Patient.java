package ru.geekbrains.Lesson_3;

public class Patient implements Person {

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
