package com.example.test.employmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.test.employmentmanagement.dao.EmployeeDao;
import com.example.test.employmentmanagement.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empdao;
	
	
	@Override
	public ResponseEntity<String> saveEmployee(Employee employee) {
		
		return empdao.saveEmployee(employee);
	}


	@Override
	public ResponseEntity<String> removeEmployee(long empid) {
		return empdao.removeEmployee(empid);
	}


	@Override
	public List<Employee> getAllEmployeeDetails() {
		return empdao.getAllEmployeeDetails();
	}


	@Override
	public List<Employee> getEmployeeByName(String firstname) {
		
		return empdao.getEmployeeByName(firstname);
	}

}
