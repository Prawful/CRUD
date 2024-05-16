package com.example.CRUDExample.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUDExample.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}
