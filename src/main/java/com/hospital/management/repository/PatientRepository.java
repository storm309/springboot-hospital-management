package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
