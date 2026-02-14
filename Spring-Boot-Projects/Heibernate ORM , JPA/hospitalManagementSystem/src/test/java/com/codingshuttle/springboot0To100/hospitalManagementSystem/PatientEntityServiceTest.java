package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStatsDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.cPatientInfoDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.iPatientInfoDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class PatientEntityServiceTest
{
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient()
    {
        List<BloodGroupStatsDTO> bloodGroupStatsDTOList =patientRepository.getBloodGroupStats();

        for( var p: bloodGroupStatsDTOList )
        {
            System.out.println(p);
        }
    }
}
