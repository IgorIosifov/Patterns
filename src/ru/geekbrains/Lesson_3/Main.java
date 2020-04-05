package ru.geekbrains.Lesson_3;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Connection connection;

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

        List<String> responsibilities = new ArrayList<>();
        responsibilities.add("a");
        responsibilities.add("b");
        responsibilities.add("c");
        Handler handler = new BusyHandler(responsibilities);
        Operator a = new Operator("First line operator", responsibilities.subList(0, 1));
        Operator b = new Operator("Second line operator", responsibilities.subList(0, 2));
        Operator c = new Operator("Third line operator", responsibilities.subList(0, 3));

        handler.setNext(a).setNext(b).setNext(c).setNext(handler);


        for (int i = 0; i < 10; i++) {
            Random rdm = new Random();
            int reasonIndex = rdm.nextInt(3);
            System.out.println(responsibilities.get(reasonIndex));
            Request rq =new Request(responsibilities.get(reasonIndex));
            handler.handle(rq);
        }
        handler.handle(new Request("d"));

        PersonMapper personMapper = new PersonMapper(connection);
        personMapper.findById(1, Patient.class);
        personMapper.selectAll(connection, Patient.class);

    }
}
