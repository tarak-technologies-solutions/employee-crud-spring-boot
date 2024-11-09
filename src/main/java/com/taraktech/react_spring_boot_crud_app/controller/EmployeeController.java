package com.taraktech.react_spring_boot_crud_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taraktech.react_spring_boot_crud_app.entity.Employee;
import com.taraktech.react_spring_boot_crud_app.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> allEmployee(){
		return new ResponseEntity<>(service.getAllEmployees(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
		return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(service.saveEmployee(employee),HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(service.updateEmployee(employee),HttpStatus.CREATED);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		return new ResponseEntity<>(service.deleteEmployee(null),HttpStatus.OK);
	}
}
