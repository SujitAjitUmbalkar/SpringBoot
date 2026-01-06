package com.Cohort.WebLayers.WebLayer.Controllers;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import com.Cohort.WebLayers.WebLayer.Repository.EmployeeRepository;
import com.Cohort.WebLayers.WebLayer.Service.EmployeeService;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
class EmployeeController
    {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
        //1
        @GetMapping("/{employeeId}")
        public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id)
        {
//            return  EmployeeRepository.findById(id);          if it returns null , nullpointerexception can be occure
               return  employeeService.getEmployeeById(id);
        }
        //2
        @GetMapping
        public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            return employeeService.getAllEmployees();
        }
        //3
        @PostMapping
        public EmployeeEntity addEmployee(@RequestBody EmployeeEntity InputEmployee)
        {
            return  employeeService.addEmployee(InputEmployee);
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



