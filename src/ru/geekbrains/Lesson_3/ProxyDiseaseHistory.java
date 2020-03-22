package ru.geekbrains.Lesson_3;

public class ProxyDiseaseHistory implements PatientDoctorService{

    String currentUser;
    Person patient;
    Person doctor;
    DiseaseHistory diseaseHistory;

    public ProxyDiseaseHistory(String currentUser, Person patient, Person doctor) {
        this.currentUser = currentUser;
        this.patient = patient;
        this.doctor = doctor;
        this.diseaseHistory = new DiseaseHistory(patient,doctor);
    }

    @Override
    public Person getPatient() {
        if (currentUser.equals(diseaseHistory.getPatient().getName()) || currentUser.equals(diseaseHistory.getDoctor().getName())) {
            return diseaseHistory.getPatient();
        }
        return null;
    }

    @Override
    public Person getDoctor() {
        if (currentUser.equals(diseaseHistory.getPatient().getName()) || currentUser.equals(diseaseHistory.getDoctor().getName())) {
            return diseaseHistory.getDoctor();
        }
        return null;
    }
}
