package ru.geekbrains.Lesson_3;

public class Main {

    public static void main(String[] args) {
        Creator doctorCreator = new DoctorCreator();
        Person doctor1 = doctorCreator.createPerson("Doctor Bob");
        Person doctor2 = doctorCreator.createPerson("Doctor John");

        Creator patientCreator = new PatientCreator();
        Person patient1 = patientCreator.createPerson("Patient Susan");
        Person patient2 = patientCreator.createPerson("Patient Max");

        String currentUser = "Wrong user"; //emulation of context working method

        PatientDoctorService diseaseHistory1 = new ProxyDiseaseHistory(currentUser, doctor1, doctor2);

        System.out.println("Patient name: " + diseaseHistory1.getPatient() +" Doctor name: " + diseaseHistory1.getDoctor());

        currentUser = doctor2.getName(); //emulation of context working method

        PatientDoctorService diseaseHistory2 = new ProxyDiseaseHistory(currentUser, patient2, doctor2);

        System.out.println("Patient name: " + diseaseHistory2.getPatient().getName() +" Doctor name: " + diseaseHistory2.getDoctor().getName());

    }
}
