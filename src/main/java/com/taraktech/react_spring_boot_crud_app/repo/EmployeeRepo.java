package com.taraktech.react_spring_boot_crud_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taraktech.react_spring_boot_crud_app.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
}
