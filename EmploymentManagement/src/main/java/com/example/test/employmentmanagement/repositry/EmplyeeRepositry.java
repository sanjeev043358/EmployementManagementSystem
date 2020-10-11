package com.example.test.employmentmanagement.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.employmentmanagement.models.Employee;

@Repository
public interface EmplyeeRepositry extends JpaRepository<Employee, Long>{

	List<Employee> findByfirstname(String firstname);

}
