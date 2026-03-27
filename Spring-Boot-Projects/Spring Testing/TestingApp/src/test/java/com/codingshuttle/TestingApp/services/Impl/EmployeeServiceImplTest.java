package com.codingshuttle.TestingApp.services.Impl;

import com.codingshuttle.TestingApp.repositories.EmployeeRepository;
import com.codingshuttle.TestingApp.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)     // another temp database will be used for tests
class EmployeeServiceImplTest
{
    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks            // mocks will be injected here
    private EmployeeServiceImpl employeeService;

    @Test
    void testgetEmployeeById_whenEmployeeIdIsPresent_ThenReturnEmployeeDTO()
    {
        employeeService.getEmployeeById(1L);
    }

}