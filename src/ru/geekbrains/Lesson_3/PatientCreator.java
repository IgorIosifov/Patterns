package ru.geekbrains.Lesson_3;

public class PatientCreator extends Creator {

    @Override
    public Person createPerson(String name) {
        return new Patient(name);
    }
}
