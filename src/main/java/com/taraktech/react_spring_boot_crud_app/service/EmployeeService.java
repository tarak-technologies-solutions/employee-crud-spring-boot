package com.taraktech.react_spring_boot_crud_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taraktech.react_spring_boot_crud_app.entity.Employee;
import com.taraktech.react_spring_boot_crud_app.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> getAllEmployees(){
		List<Employee> emps = new ArrayList<>();
	    emps = repo.findAll();
	    if (emps.isEmpty()) {
			throw new RuntimeException("No employees are available..!!");
		}
		return emps;
	}
	
	public Employee getEmployeeById(Integer id) {
		return repo.findById(id).orElseThrow(() ->  new RuntimeException("There no employee with provided id..!!"));
	}
	
	public String saveEmployee(Employee employee) {
		Optional<Employee> emp = repo.findById(employee.getEno());
		if (emp.isEmpty()) {
			throw new RuntimeException("Employee already exits with given id..!!");
		}else {
			repo.save(employee);
		}
		return "Success";
	}
	public String updateEmployee(Employee employee) {
		Employee uemployee = new Employee();
		Optional<Employee> emp = repo.findById(employee.getEno());
		if (emp.isEmpty()) {
			throw new RuntimeException("There is employee with provided id..!!");
		}else {
			Employee employee2 = emp.get();
			uemployee.setEname(employee2.getEname());
			uemployee.setEmail(employee2.getEmail());
			uemployee.setCity(employee2.getCity());
			uemployee.setJob(employee2.getJob());
			uemployee.setSalary(employee2.getSalary());
			repo.save(uemployee);
		}
		return "Success";
	} 
	
	public String deleteEmployee(Integer id) {
		repo.deleteById(id);
		return "Deleted";	
	}
}
