package com.Cohort.WebLayers.WebLayer.Service;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        EmployeeEntity employeeEntity =   employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id "+ id ));
       return modelmapper.map(employeeEntity, EmployeeDTO.class);       // returning after converting Entity into DTO using map method
    }

    // 2        GetMapping
    public List<EmployeeDTO> getAllEmployees() {
//        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
//
//        return employeeEntities.stream()
//                .map(employeeEntitiy -> modelmapper.map(employeeEntitiy, EmployeeDTO.class))
//                .collect(Collectors.toList());

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities)
        {
            EmployeeDTO employeeDTO = modelmapper.map(employeeEntity, EmployeeDTO.class);
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

    public EmployeeDTO addEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity employeeEntity = modelmapper.map(inputEmployee, EmployeeEntity.class);           // convert first in Entity before saving
        EmployeeEntity savedEntity =  employeeRepository.save(employeeEntity);          // save entity

        return modelmapper.map(savedEntity, EmployeeDTO.class);         // return converting entity in Dto to Controller
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO inputEmployee, Long id)
    {
        EmployeeEntity existingemployeeEntity =employeeRepository.findById(id)      // first find if that Enity is present
                        .orElseThrow(() -> new RuntimeException("Employee not found")); // if not return exception

        // IMPORTANT: preserve ID
        inputEmployee.setId(existingemployeeEntity.getId());        // map method will not set id because i didn't sent id from json , passed through browser
        // therefore modelmapper wont set id of Entity , that's why 500 error occues
        // inshort , set id manually
        modelmapper.map(inputEmployee, existingemployeeEntity);     // convert DTO in Existing repo using map mthod
        // don't use .class because it will create new object

        EmployeeEntity updatedEntity = employeeRepository.save(existingemployeeEntity);     // update existing entity

        return modelmapper.map(updatedEntity, EmployeeDTO.class);
    }

    public boolean checkIfEmployeeExists(Long id)
    {
        boolean  exists = employeeRepository.existsById(id);
        if(exists) {    return true;   }
        else    {   return false;   }
    }

    public boolean  deleteEmployeeById(Long employeeId)
    {
        boolean exists = checkIfEmployeeExists(employeeId);
        if(exists )
        {   employeeRepository.deleteById(employeeId);
            return true;
        }
        else{   return false;   }
    }

    public EmployeeDTO patchEmployeeById(Long employeeId, Map<String, Object> update)
    {
        EmployeeEntity employeeExistingEntity = employeeRepository.findById(employeeId)         // check if employee exists
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + employeeId));

        update.forEach((field, value) ->
        {
//            find the exact field (variable) named field inside the EmployeeEntity class
//            and returns it as a Field object, throwing an error if that field does not exist.

            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);

            if(fieldToBeUpdated != null)
            {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeExistingEntity, value);
            }

            fieldToBeUpdated.setAccessible(true);

            ReflectionUtils.setField(
                    fieldToBeUpdated,
                    employeeExistingEntity,
                    value
            );
        });

        return modelmapper.map(
                employeeRepository.save(employeeExistingEntity),
                EmployeeDTO.class
        );
    }

}
