package com.example.CRUDExample.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CRUDExample.model.Employee;
import com.example.CRUDExample.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
	private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping
    public List<Employee> getAllEmploy(){
		System.out.println("I am inside controller");
    	return employeeService.getAllEmployee();
    }

    @PostMapping("/post")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.deleteById(id);
    }

    @PutMapping("/edit")
    public Employee updateEmployee(@RequestBody long id, @RequestBody Employee employeeDetails) {
    	Employee updatedEmployee = employeeService.editEmployee(employeeDetails, id);
    	return employeeService.editEmployee(employeeDetails, id);

    }
}
