package com.codegravity.exampleCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegravity.exampleCRUD.entity.Employee;
import com.codegravity.exampleCRUD.service.EmployeeService;

@RestController
@RequestMapping("/employees")

public class EmployeeController {

	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<Employee> findAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/post")
	public Employee addEmployee(@RequestBody Employee employee ){
		return employeeService.createEmployee(employee);
		
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editingEmployee(@RequestBody Employee employee){
		try {
			Employee updatedEmployee = employeeService.updateEmployee(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
		catch (Exception error) {
			return ResponseEntity.status(404).body(error.getMessage());
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletingEmployee(@PathVariable int id){
		try {
			employeeService.deleteEmployee(id);
			return ResponseEntity.ok("Deleted Successfully");
		}
		catch (Exception error){
			return ResponseEntity.status(404).body(error.getMessage());
		}
	}
	
}
