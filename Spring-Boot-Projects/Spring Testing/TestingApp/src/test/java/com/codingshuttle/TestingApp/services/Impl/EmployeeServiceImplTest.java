package com.codingshuttle.TestingApp.services.Impl;

import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import com.codingshuttle.TestingApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.shaded.org.apache.commons.lang3.ObjectUtils;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)     // another temp database will be used for tests
class EmployeeServiceImplTest
{
    @Mock
    EmployeeRepository employeeRepository;

//    @Mock
    @Spy
    ModelMapper modelMapper;

    @InjectMocks            // mocks will be injected here
    private EmployeeServiceImpl employeeService;

    @Test
    void testgetEmployeeById_whenEmployeeIdIsPresent_ThenReturnEmployeeDTO()
    {
        // arrange
        Long id = 1L;
        Employee mockedEmployee = Employee.builder()
                .id(id)
                .name("Sujit")
                .email("jeetumbalkar@gmail.com")
                .salary(50000L)
                .build();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockedEmployee));              // stubbing

        //act
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);

        // Assert
        assertThat(employeeDto.getId()).isEqualTo(id);
        assertThat(  employeeDto.getEmail()   ).isEqualTo(mockedEmployee.getEmail());

    }

}