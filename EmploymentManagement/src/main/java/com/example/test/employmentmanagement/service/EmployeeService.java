package com.example.test.employmentmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.test.employmentmanagement.models.Employee;

@Service
public interface EmployeeService {

	public ResponseEntity<String> saveEmployee(Employee employee);
	public ResponseEntity<String> removeEmployee(long empid);
	public List<Employee> getAllEmployeeDetails();
    public List<Employee> getEmployeeByName(String firstname);

}
