package com.codingshuttle.springboot0To100.hospitalManagementSystem.repository;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Appointment;
import org.springframework.data.repository.Repository;

public interface AppointmentRepository extends Repository<Appointment, Long> {
}