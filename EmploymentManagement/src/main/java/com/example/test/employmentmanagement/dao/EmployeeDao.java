package com.example.test.employmentmanagement.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.test.employmentmanagement.models.Employee;

@Repository
public interface EmployeeDao {

	public ResponseEntity<String> saveEmployee(Employee employee);
	public ResponseEntity<String> removeEmployee(long empid);
	public List<Employee> getAllEmployeeDetails();
	public List<Employee> getEmployeeByName(String firstname);
}
