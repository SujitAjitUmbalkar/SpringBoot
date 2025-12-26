package com.Cohort.WebLayers.WebLayer.Controllers;

import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@RestController
//public class EmployeeController
//{
//      @GetMapping(path = "/getMyMassage")
//          public String getMyMassage()
//          {
//              return "Secret Masssage : Hello Secretly  ";
//          }
//      }


@RestController
@RequestMapping("/employees")
class EmployeeController
    {
        @GetMapping("/{employeeId}")
        public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id)
        {
            return new EmployeeDTO("Sujit" , id , "Sujit@gmail.com", 23 , LocalDate.of(2024 , 1 , 2 ), true);
        }

        @GetMapping
        public String getAllEmployees(@RequestParam(required = false, name = "InputAge") Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            return "hii , Age is " + age + " "+ sortBy ;
        }

        @PostMapping
        public String addEmployee()
        {
            return "Return from PostMapping ";
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



