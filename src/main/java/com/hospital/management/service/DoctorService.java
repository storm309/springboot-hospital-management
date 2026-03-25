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

import com.hospital.management.model.Doctor;
import com.hospital.management.repository.DoctorRepository;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor save(Doctor doctor) {
        logger.info("Saving doctor: {}", doctor);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAll() {
        logger.info("Fetching all doctors");
        return doctorRepository.findAll();
    }

    public Page<Doctor> getPage(int page, int size, String sortBy, String direction) {
        logger.info("Fetching doctors page: page={}, size={}, sortBy={}, direction={}", page, size, sortBy, direction);
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return doctorRepository.findAll(pageable);
    }

    public Optional<Doctor> getById(Long id) {
        logger.info("Fetching doctor by id: {}", id);
        return doctorRepository.findById(id);
    }

    public void delete(Long id) {
        logger.info("Deleting doctor by id: {}", id);
        doctorRepository.deleteById(id);
    }
}
