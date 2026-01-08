package com.Cohort.WebLayers.WebLayer.Service;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;                // Interfaces cannot be instantiated directly, but frameworks like Spring can create runtime proxy implementations and inject them as beans.
    private  final ModelMapper modelmapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelmapper)
    {
        this.employeeRepository = employeeRepository;
        this.modelmapper = modelmapper;
    }

    //1     @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity =   employeeRepository.findById(id).orElse(null);
       return modelmapper.map(employeeEntity, EmployeeDTO.class);       // returning after converting Entity into DTO using map method
    }

    // 2        GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities.stream()
                .map(employeeEntitiy -> modelmapper.map(employeeEntitiy, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO addEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity employeeEntity = modelmapper.map(inputEmployee, EmployeeEntity.class);           // convert first in Entity before saving
        EmployeeEntity savedEntity =  employeeRepository.save(employeeEntity);          // save entity

        return modelmapper.map(savedEntity, EmployeeDTO.class);         // return converting entity in Dto to Controller

    }
}
