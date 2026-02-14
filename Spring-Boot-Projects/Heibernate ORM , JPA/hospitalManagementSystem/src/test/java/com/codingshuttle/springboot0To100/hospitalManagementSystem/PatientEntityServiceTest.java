package com.codingshuttle.springboot0To100.hospitalManagementSystem;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.iPatientInfoDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
//         List<PatientEntity> patientEntityList =  patientRepository.findAll();

        List<iPatientInfoDTO> iPatientInfoDTOList =  patientRepository.getAllPatientsInfo();

        for( iPatientInfoDTO p: iPatientInfoDTOList )
        {
            System.out.println(p);
        }

        System.out.println(iPatientInfoDTOList.size());
    }

}
