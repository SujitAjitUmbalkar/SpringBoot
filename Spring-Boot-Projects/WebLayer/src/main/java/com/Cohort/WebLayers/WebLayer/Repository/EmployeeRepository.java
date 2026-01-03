package com.Cohort.WebLayers.WebLayer.Repository;

import com.Cohort.WebLayers.WebLayer.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long>      // crud operations will be implemented internally
{

}
