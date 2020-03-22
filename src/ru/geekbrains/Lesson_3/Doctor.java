package ru.geekbrains.Lesson_3;

public class Doctor implements Person {

    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
