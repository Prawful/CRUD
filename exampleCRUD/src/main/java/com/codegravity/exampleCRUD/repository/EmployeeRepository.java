package com.codegravity.exampleCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegravity.exampleCRUD.entity.Employee;

public interface EmployeeRepository extends	JpaRepository<Employee, Integer> {
	

}
