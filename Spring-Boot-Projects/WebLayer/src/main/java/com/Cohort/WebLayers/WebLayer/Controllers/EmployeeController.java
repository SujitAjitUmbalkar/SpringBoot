package com.Cohort.WebLayers.WebLayer.Controllers;

import com.Cohort.WebLayers.WebLayer.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     class EmployeeController
    {
        // Concept Of  @PathVariable
        // use path variables when the parameter is and essential part of the url path that identifies a resource
        @GetMapping("/employees/{employeeId}")
        public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)
        {
            return new EmployeeDTO("Sujit" , employeeId , "Sujit@gmail.com", 23 , LocalDate.of(2024 , 1 , 2 ), true);
        }

        @GetMapping(path="/employees")
        public String getAllEmployees(@RequestParam(required = false) Integer age,
                                                            @RequestParam(required = false) String sortBy)
        {
            return "hii , Age is " + age + " "+ sortBy ;
        }
    }



