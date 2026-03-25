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

import com.hospital.management.model.Appointment;
import com.hospital.management.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment save(Appointment appointment) {
        logger.info("Saving appointment: {}", appointment);
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        logger.info("Fetching all appointments");
        return appointmentRepository.findAll();
    }

    public Page<Appointment> getPage(int page, int size, String sortBy, String direction) {
        logger.info("Fetching appointments page: page={}, size={}, sortBy={}, direction={}", page, size, sortBy, direction);
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return appointmentRepository.findAll(pageable);
    }

    public Optional<Appointment> getById(Long id) {
        logger.info("Fetching appointment by id: {}", id);
        return appointmentRepository.findById(id);
    }

    public void delete(Long id) {
        logger.info("Deleting appointment by id: {}", id);
        appointmentRepository.deleteById(id);
    }
}
