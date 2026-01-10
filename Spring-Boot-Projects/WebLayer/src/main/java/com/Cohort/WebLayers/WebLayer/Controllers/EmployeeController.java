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
public class  EmployeeController
    {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
        //1
        @GetMapping("/{employeeId}")
        public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id)
        {
//            return  EmployeeRepository.findById(id);          if it returns null , nullpointerexception can be occure
               return  employeeService.getEmployeeById(id);
        }

        //2
        @GetMapping
        public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            return employeeService.getAllEmployees();
        }

        //3
        @PostMapping
        public EmployeeDTO addEmployee(@RequestBody EmployeeDTO InputEmployee)
        {
            return  employeeService.addEmployee(InputEmployee);
        }

        //4
        @PutMapping("/{employeeId}")
        public EmployeeDTO updateEmployee( @PathVariable("employeeId") Long id, @RequestBody EmployeeDTO inputEmployee)
        {
            return employeeService.updateEmployeeById(inputEmployee, id);
        }

        @DeleteMapping("/{employeeId}")
        public String deleteEmployeeById(@PathVariable Long employeeId) {
            return "Deleted employee " + employeeId;
        }

        @PatchMapping("/{employeeId}")
        public String patchEmployeeById(@PathVariable Long employeeId) {
            return "Patched employee " + employeeId;
        }

    }



