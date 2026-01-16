package com.Cohort.WebLayers.WebLayer.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Employee")                 // if this is not done , then name of the table will be saved as EmployeeEntity in database
public class EmployeeEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isactive")
    private Boolean isactive;
}

