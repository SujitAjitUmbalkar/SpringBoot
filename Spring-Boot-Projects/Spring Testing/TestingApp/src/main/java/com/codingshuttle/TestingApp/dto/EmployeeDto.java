package com.codingshuttle.TestingApp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String email;
    private String name;
    private Long salary;

    @Override
    public boolean equals(Object o)     // accepts object
    {
        if (this == o) return true;     // 1. check if objects are same
        if (!(o instanceof EmployeeDto)) return false;  // 2. if not , then check o is instance of EmployeeDto

        EmployeeDto other = (EmployeeDto) o;        // 3. if not then convert object in dto and check variables

        return Objects.equals(id, other.id) &&
                Objects.equals(email, other.email) &&
                Objects.equals(name, other.name) &&
                Objects.equals(salary, other.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getName(), getSalary());
    }
}


/*
We override equals() so that two objects can be compared based on their data.
 2) By default, Java compares memory addresses, not the values inside the object.
 3) If two objects have the same data but different memory locations, Java will say they are not equal.
 4) Implementing equals() allows frameworks like AssertJ or JUnit to compare objects correctly in tests.
5) It is also useful when storing objects in collections like HashSet or HashMap.
6. no need when you comapre premitive datatypes
 */