package com.hospital.management.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hospital.management.model.Patient;
import com.hospital.management.repository.PatientRepository;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        logger.info("Saving patient: {}", patient);
        return patientRepository.save(patient);
    }

    public List<Patient> getAll() {
        logger.info("Fetching all patients");
        return patientRepository.findAll();
    }

    public Page<Patient> getPage(int page, int size, String sortBy, String direction) {
        logger.info("Fetching patients page: page={}, size={}, sortBy={}, direction={}", page, size, sortBy, direction);
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return patientRepository.findAll(pageable);
    }

    public Optional<Patient> getById(Long id) {
        logger.info("Fetching patient by id: {}", id);
        return patientRepository.findById(id);
    }

    public void delete(Long id) {
        logger.info("Deleting patient by id: {}", id);
        patientRepository.deleteById(id);
    }
}
