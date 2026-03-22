package com.codingshuttle.TestingApp.repositories;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)     // another temp database will be used for tests
class EmployeeRepositoryTest
{
    @Autowired
    private  EmployeeRepository employeeRepository;

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee()            // renamed
    {
        employeeRepository.findByEmail(" ");
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList()
    {

    }
}