package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;

import com.codingshuttle.springboot0To100.hospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
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

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinColumn(name = "patient_insurance", unique = true) // by default it is unique because onetoone mapping
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")                // inverse side of relationship (mappeedby
    private List<Appointment> appointments =  new ArrayList<>();


}