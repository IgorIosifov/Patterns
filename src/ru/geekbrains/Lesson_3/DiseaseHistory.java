package ru.geekbrains.Lesson_3;

public class DiseaseHistory implements PatientDoctorService {
    Person patient;
    Person doctor;

    public DiseaseHistory(Person patient, Person doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public Person getPatient() {
        return patient;
    }

    @Override
    public Person getDoctor() {
        return doctor;
    }
}
