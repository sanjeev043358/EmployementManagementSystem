package com.example.test.employmentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.employmentmanagement.models.Employee;
import com.example.test.employmentmanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee_management")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	//test Method For request and response
	@GetMapping("/test")
	public String test() {
		logger.info("test Method For request and response - Method- test");
		return "success test";
	}
	
    //Insert Employee Details in Database
	@PostMapping("/saveemployee")
	public ResponseEntity saveEmployee(@Valid @RequestBody Employee employee){
		logger.info("Insert Employee Details in Database  - Method- saveEmployee");
		return empservice.saveEmployee(employee);
	}

	//Get All Employee Details from Database
	@GetMapping("/getallemployeedetails")
	public List<Employee> getAllEmployeeDetails(){
		logger.info("Get All Employee Details from Database - Method- getAllEmployeeDetails");
		return empservice.getAllEmployeeDetails();
	}
	
	//Get  Employee Details By Firstname from Database
	@GetMapping("/getemployee/{firstname}")
	public List<Employee> getEmployeeByName(@PathVariable String firstname){
		logger.info("Get  Employee Details By Firstname from Database - Method- getEmployeeByName");
		return empservice.getEmployeeByName(firstname);
	}

	//Delete Specfice Employee Detail on Base of Employee id
	@DeleteMapping("/removeemployee/{empid}")
	public ResponseEntity<String> removeEmployee(@PathVariable long empid){
		logger.info("Delete Specfice Employee Detail on Base of Employee id- Method- removeEmployee");
		return empservice.removeEmployee(empid);
	}
}
