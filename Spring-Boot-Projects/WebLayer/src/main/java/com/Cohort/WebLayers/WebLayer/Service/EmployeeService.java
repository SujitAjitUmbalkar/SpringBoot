package com.Cohort.WebLayers.WebLayer.Service;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Exceptions.NoResourceFoundException;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    public Optional<EmployeeDTO> getEmployeeById(Long id)
    {
        Optional<EmployeeEntity> employeeEntity =   employeeRepository.findById(id);
        return employeeEntity.map(employeeEntity1 -> modelmapper.map(employeeEntity1, EmployeeDTO.class));

//        return employeeRepository.findById(id).map(employee -> modelmapper.map(employee, EmployeeDTO.class));
    }

    // 2        GetMapping
    public List<EmployeeDTO> getAllEmployees()
    {
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
//    @PostMapping
    public EmployeeDTO addEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity employeeEntity = modelmapper.map(inputEmployee, EmployeeEntity.class);           // convert first in Entity before saving
        EmployeeEntity savedEntity =  employeeRepository.save(employeeEntity);          // save entity

        return modelmapper.map(savedEntity, EmployeeDTO.class);         // return converting entity in Dto to Controller
    }

    // Put
    public EmployeeDTO updateEmployeeById(EmployeeDTO inputEmployee, Long id)
    {
        checkIfEmployeeExists(id);

        EmployeeEntity existingemployeeEntity =employeeRepository.findById(id).get();

        inputEmployee.setId(existingemployeeEntity.getId());
        modelmapper.map(inputEmployee, existingemployeeEntity);     // convert DTO in Existing repo using map mthod

        EmployeeEntity updatedEntity = employeeRepository.save(existingemployeeEntity);     // update existing entity

        return modelmapper.map(updatedEntity, EmployeeDTO.class);

        // IMPORTANT: preserve ID
        // map method will not set id because i didn't sent id from json , passed through browser
        // therefore modelmapper wont set id of Entity , that's why 500 error occues
        // inshort , set id manually
        // don't use .class because it will create new object
    }

    public void checkIfEmployeeExists(Long id)
    {
        boolean  exists = employeeRepository.existsById(id);
        if(!exists) {    throw new NoResourceFoundException("Employee not found with id "+ id);  }
    }

// Delete
    public boolean  deleteEmployeeById(Long employeeId)
    {
         checkIfEmployeeExists(employeeId);
         employeeRepository.deleteById(employeeId);
         return true;

    }

    //patch
    public EmployeeDTO patchEmployeeById(Long employeeId, Map<String, Object> update)
    {
        checkIfEmployeeExists(employeeId);

        EmployeeEntity employeeExistingEntity = employeeRepository.findById(employeeId).get();      // use get() when you are 100% sure that resource will found otherwise use orElse(null);

        for (Map.Entry<String, Object> entry : update.entrySet())
        {
            String field = entry.getKey();
            Object value = entry.getValue();
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, field);
            if (fieldToBeUpdated != null)
            {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeExistingEntity, value);
            }
        }
        EmployeeEntity savedEntity = employeeRepository.save(employeeExistingEntity);
        return modelmapper.map(savedEntity, EmployeeDTO.class);
    }
}
