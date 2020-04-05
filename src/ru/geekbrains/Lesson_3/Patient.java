package ru.geekbrains.Lesson_3;

public class Patient implements Person {

    private int id;
    private String name;

    public Patient() {
    }

    public Patient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

       return id == patient.id;
    }

    @Override
    public int hashCode() {
       return id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
