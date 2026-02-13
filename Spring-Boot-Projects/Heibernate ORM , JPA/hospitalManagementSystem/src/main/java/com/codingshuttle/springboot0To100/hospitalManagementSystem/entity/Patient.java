package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;


import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDate birthDate;

    private String email;

    private String gender;
}