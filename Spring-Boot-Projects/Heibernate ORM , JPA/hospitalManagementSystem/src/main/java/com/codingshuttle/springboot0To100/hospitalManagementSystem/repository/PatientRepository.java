package com.codingshuttle.springboot0To100.hospitalManagementSystem.repository;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStatsDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.cPatientInfoDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.iPatientInfoDTO;
import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long>
{
    @Query("select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<iPatientInfoDTO> getAllPatientsInfo();

    @Query("select new com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.cPatientInfoDTO(p.id, p.name) " +
            "from PatientEntity p")
    List<cPatientInfoDTO> getAllPatientsInfoConcrete();

    @Query("select new com.codingshuttle.springboot0To100.hospitalManagementSystem.dto.BloodGroupStatsDTO(p.bloodGroup, " +
            "COUNT(p)) from PatientEntity p group by p.bloodGroup order by COUNT(p) DESC")
    List<BloodGroupStatsDTO> getBloodGroupStats();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

}