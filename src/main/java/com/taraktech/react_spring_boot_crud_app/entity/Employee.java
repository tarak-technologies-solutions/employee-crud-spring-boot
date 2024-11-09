package com.taraktech.react_spring_boot_crud_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "emp_tbl")
public class Employee {
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Integer eno;
	private String ename;
	private String email;
	private String job;
	private String city;
	private Double salary;
}
