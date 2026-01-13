package com.Cohort.WebLayers.WebLayer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO
{
   private String name;
   private Long id;
   private String email;
   private Integer age;
   private LocalDate dateOfJoining;
   @JsonProperty("isactive")                // using this we can use diffenent variable names in postman and in backend
   private Boolean isactiveEmployee;

}
