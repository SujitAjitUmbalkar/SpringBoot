package com.Cohort.WebLayers.WebLayer.Controllers;

import com.Cohort.WebLayers.WebLayer.Service.EmployeeService;
import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id)
        {
           Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
           return
                   employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1) )
                           .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        }

        @ExceptionHandler(NoSuchElementException.class)
        public ResponseEntity<String> HandleException(NoSuchElementException e)
        {
            return new  ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }


        //2
        @GetMapping
        public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            List<EmployeeDTO>  employeeDTOList = employeeService.getAllEmployees();
            return ResponseEntity.ok(employeeDTOList);          // no need for optional , because service layer finds all entities
        }

        //3
        @PostMapping
        public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @NotNull EmployeeDTO InputEmployee)
        {
            EmployeeDTO savedEmployee = employeeService.addEmployee( InputEmployee);
             return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
        }

        //4
        @PutMapping("/{employeeId}")
        public ResponseEntity<EmployeeDTO> updateEmployee( @PathVariable("employeeId") Long id, @RequestBody EmployeeDTO inputEmployee)
        {
            EmployeeDTO updatedEmployee = employeeService.updateEmployeeById(inputEmployee, id );
            return ResponseEntity.ok(updatedEmployee);
        }

        @DeleteMapping("/{employeeId}")
        public ResponseEntity <Boolean>  deleteEmployeeById(@PathVariable Long employeeId)
        {
           Boolean isDeleted  = employeeService.deleteEmployeeById(employeeId);
            if(isDeleted == true) {   return ResponseEntity.ok(true);   }
            else {   return ResponseEntity.notFound().build(); }
        }

        @PatchMapping("/{employeeId}")
        public ResponseEntity<EmployeeDTO>  patchEmployeeById(  @PathVariable Long employeeId , Map<String , Object> update)
        {
            EmployeeDTO updatedEmployee = employeeService.patchEmployeeById(employeeId, update);
            if (updatedEmployee == null) {return ResponseEntity.notFound().build();}
            else {return ResponseEntity.ok(updatedEmployee); }
        }
    }



