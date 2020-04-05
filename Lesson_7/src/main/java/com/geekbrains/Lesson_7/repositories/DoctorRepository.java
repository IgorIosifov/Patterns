package com.geekbrains.Lesson_7.repositories;

import com.geekbrains.Lesson_7.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
