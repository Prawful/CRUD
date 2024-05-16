package com.example.CRUDExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUDExample.model.Employee;
import com.example.CRUDExample.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAllEmployee(){
		 return employeeRepository.findAll();
   
	}
	
	public Employee getById(long id) {
		Optional <Employee> employee = employeeRepository.findById(id) ;
		if (employee.isPresent())
				return employee.get();
		else {
			throw new RuntimeException("Employee not found with id " + id);
		}
	}
	
	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee createEmployee(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}
	
	public Employee editEmployee(Employee employeeDetails, long id) {
		Employee employee = employeeRepository.findById(employeeDetails.getId()).orElse(null);
				employee.setId(employeeDetails.getId());	
				employee.setFirstName(employeeDetails.getFirstName());
        		employee.setLastName(employeeDetails.getLastName());
        		employee.setDob(employeeDetails.getDob());
        		employee.setSsn(employeeDetails.getSsn());
        		return employeeRepository.save(employee);

	}
	
}
