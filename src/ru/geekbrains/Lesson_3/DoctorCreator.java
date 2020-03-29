package ru.geekbrains.Lesson_3;

public class DoctorCreator extends Creator {

    @Override
    public Person createPerson(String name) {
        return new Doctor(name);
    }
}
