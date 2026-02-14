package com.codingshuttle.springboot0To100.hospitalManagementSystem.service;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.PatientEntity;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService
{
    private final PatientRepository patientRepository;

    @Transactional
    public  void testPatientTransaction()
    {
        PatientEntity p1 = patientRepository.findById(1L).orElse(null);
        PatientEntity p2 = patientRepository.findById(1L).orElse(null);         // tryng to find same used 2 times

        System.out.println(p1) ;
        System.out.println(p2);
        System.out.println(p1==p2);


    }
}
