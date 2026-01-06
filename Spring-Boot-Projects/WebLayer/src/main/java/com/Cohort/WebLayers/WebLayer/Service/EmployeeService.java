package com.Cohort.WebLayers.WebLayer.Service;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;                // Interfaces cannot be instantiated directly, but frameworks like Spring can create runtime proxy implementations and inject them as beans.

    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
//1     @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }

    // 2        GetMapping
    public List<EmployeeEntity> getAllEmployees()
    {
        return employeeRepository.findAll();
    }


    public EmployeeEntity addEmployee(EmployeeEntity inputEmployee)
    {
        return employeeRepository.save(inputEmployee);
    }
}
