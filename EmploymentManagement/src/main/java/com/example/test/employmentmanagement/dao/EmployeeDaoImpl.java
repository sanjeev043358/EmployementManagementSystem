package com.example.test.employmentmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.test.employmentmanagement.models.Address;
import com.example.test.employmentmanagement.models.Employee;
import com.example.test.employmentmanagement.repositry.EmplyeeRepositry;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EmplyeeRepositry emprepo;

	@Autowired
	EntityManager entity;

    //Insert Employee Details in Database
	@Override
	public ResponseEntity saveEmployee(Employee employee) {
		Address addr = employee.getAddress();
		Address address = new Address(addr.getHousenumber(),addr.getCity(),addr.getPhone(),employee);
	    employee.setAddress(address);
		Employee emp = emprepo.save(employee);
		long id = emp.getId();
	   if(id <= 0 ) {
			return new ResponseEntity<String>("Employee Details is not Inserted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Employee Details is  Inserted", HttpStatus.OK);
		
	}

    //Delete Employee Details By Id in Database
	@Override
	public ResponseEntity<String> removeEmployee(long empid) {
		
	 	emprepo.deleteById(empid);
		return new ResponseEntity<String>("Employee Detail Deleted By employee id", HttpStatus.OK);
	}


	//Get All Employee Details from Database
	@Override
	public List<Employee> getAllEmployeeDetails() {
		//String sql = "select * from employee emp inner join address addr on addr.employee_id = emp.id";
		//return entity.createNativeQuery(sql,Employee.class).getResultList();
		return emprepo.findAll();
	}

   //Get Employee Detail By Name
	@Override
	public List<Employee> getEmployeeByName(String firstname) {
		
		return emprepo.findByfirstname(firstname);
	}
}
