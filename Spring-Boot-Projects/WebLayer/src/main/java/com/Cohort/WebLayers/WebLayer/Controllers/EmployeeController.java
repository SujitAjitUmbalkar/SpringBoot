package com.Cohort.WebLayers.WebLayer.Controllers;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
class EmployeeController
    {
        private final EmployeeRepository employeeRepository;

        public EmployeeController(EmployeeRepository employeeRepository)
        {
                this.employeeRepository = employeeRepository;
        }
                    // now we can use methods from employeeEntity interface

        @GetMapping("/{employeeId}")
        public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id)
        {
//            return  EmployeeRepository.findById(id);          if it returns null , nullpointerexception can be occure
               return  employeeRepository.findById(id).orElse(null);
        }

        @GetMapping
        public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            return employeeRepository.findAll();
        }

        @PostMapping
        public EmployeeEntity addEmployee(@RequestBody EmployeeEntity InputEmployee)
        {
            return  employeeRepository.save(InputEmployee);
        }

        @PutMapping
        public String updateEmployeeById()
        {
            return "Return from PutMapping ";
        }

        @DeleteMapping
        public String deleteEmployeeById()
        {
            return "Return from DeleteMapping";
        }

        @PatchMapping
        public String patchEmployeeById()
        {
            return "Return from PatchMapping";
        }

    }



