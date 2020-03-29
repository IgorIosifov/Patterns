package ru.geekbrains.Lesson_3;

public class Main {

    public static void main(String[] args) {
        Creator doctorCreator = new DoctorCreator();
        Person doctor1 = doctorCreator.createPerson("Doctor Bob");
        Person doctor2 = doctorCreator.createPerson("Doctor John");

        Creator patientCreator = new PatientCreator();
        Person patient1 = patientCreator.createPerson("Patient Susan");
        Person patient2 = patientCreator.createPerson("Patient Max");

        System.out.println(doctor1.getClass() + " Name: " + doctor1.getName());
        System.out.println(doctor2.getClass() + " Name: " + doctor2.getName());
        System.out.println(patient1.getClass() + " Name: " + patient1.getName());
        System.out.println(patient2.getClass() + " Name: " + patient2.getName());
    }
}
