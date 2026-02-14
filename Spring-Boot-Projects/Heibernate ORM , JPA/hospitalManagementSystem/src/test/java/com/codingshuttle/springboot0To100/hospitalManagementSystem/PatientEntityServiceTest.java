package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PatientEntityServiceTest
{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatient()
    {
        patientService.testPatientTransaction();
    }
}
