package com.codingshuttle.TestingApp.repositories;

import com.codingshuttle.TestingApp.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)     // another temp database will be used for tests
class EmployeeRepositoryTest
{
    @Autowired
    private  EmployeeRepository employeeRepository;

//        1. create resources ,
//        2. Arrange , given
//        3.  Act , when
//        4. Assert , then

    private Employee employee;      // 1.  create resources

    @BeforeEach                 //   run before each method
    void setUp()
    {
        //        1. provide resources
        employee = Employee.builder()                       // 1. created resource
                .id(5L)
                .email("jeetumbalkar@gmail.com")
                .salary(50000L)
                .name("Sujit")
                .build();
    }

    // @BeforeEach → only create objects
    //@Test → save + execute + assert

    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee()            // renamed
    {
//        2. Arrange , given
        employeeRepository.save(employee);

//        3.  Act , when
        List<Employee> employeeList  = employeeRepository.findByEmail(employee.getEmail());

    //        4. Assert , then
        assertThat(employeeList).isNotEmpty();
        assertThat(employeeList).isNotNull();

//        isNotNull() → only checks object exists
//        isNotEmpty() → checks object exists + has data

        // check we fetched right emplyee
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList()
    {
        String email = "notFound@gmail.com";

        List<Employee> employeeList  = employeeRepository.findByEmail(email);

        assertThat(employeeList).isEmpty();
        assertThat(employeeList).isNotNull();

    }
}