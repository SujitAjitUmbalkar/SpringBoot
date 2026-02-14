package com.codingshuttle.springboot0To100.hospitalManagementSystem.dto;

import lombok.Data;

@Data
public class cPatientInfoDTO
{
    private final Long id;              // added final so the AllArgsConnstructor could fill it without RequiredArgsConstructor
    private final String name;
}
