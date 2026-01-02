package com.Cohort.WebLayers.WebLayer.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Employee")                 // if this is not done , then name of the table will be saved as EmployeeEntity in database
public class EmployeeEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String name;
    private Long id;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isactive;
}

