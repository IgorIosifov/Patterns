package com.geekbrains.Lesson_7.repositories;

import com.geekbrains.Lesson_7.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
