package com.codegravity.exampleCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegravity.exampleCRUD.entity.Employee;
import com.codegravity.exampleCRUD.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	//For Get
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	//For Post or Create
	
	public Employee createEmployee(Employee newEmployee) {
		return employeeRepository.save(newEmployee);	
	}
	
	//For Delete
	
	public void deleteEmployee(int id) throws Exception {
		Optional<Employee> deleteEmployee = employeeRepository.findById(id);
		if (deleteEmployee.isPresent()) {
			employeeRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Invalid ID");
		}
		
	}

	//For PUT/Update
	public Employee updateEmployee(Employee putEmployee) throws Exception {
		Optional<Employee> editEmployee = employeeRepository.findById(putEmployee.getId());
		
		if (editEmployee.isPresent()) {
			Employee updatedEmployee = editEmployee.get();
			updatedEmployee.setFirstName(putEmployee.getFirstName());
			updatedEmployee.setLastName(putEmployee.getLastName());
			updatedEmployee.setDob(putEmployee.getDob());
			updatedEmployee.setSsn(putEmployee.getSsn());
			return employeeRepository.save(updatedEmployee);
		}
		else {
			throw new RuntimeException("Invalid ID");

		}
		
	}
	
}
