package com.geekster.doctorapp.dao;

import com.geekster.doctorapp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
