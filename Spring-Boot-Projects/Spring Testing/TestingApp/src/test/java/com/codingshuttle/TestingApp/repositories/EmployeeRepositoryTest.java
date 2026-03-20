package com.codingshuttle.TestingApp.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)     // another temp database will be used for tests
class EmployeeRepositoryTest
{
    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee()            // renamed
    {

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList()
    {

    }
}