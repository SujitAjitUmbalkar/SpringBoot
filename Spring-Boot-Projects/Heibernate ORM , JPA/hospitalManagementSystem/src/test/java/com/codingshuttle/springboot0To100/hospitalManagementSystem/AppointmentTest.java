package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.Appointment;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@ActiveProfiles("test")
public class AppointmentTest
{
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createNewAppointment()
    {
        Appointment newAppointment =  Appointment.builder()
                .appointmentTime(LocalDateTime.now())
                .reason("fever")
                .build();

        appointmentService.createNewAppointment(newAppointment , 1L , 1L );

        System.out.println(newAppointment);

    }

}
