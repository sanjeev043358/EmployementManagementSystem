package com.example.test.employmentmanagement.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@NotNull
	@NotBlank(message = "please provide employee firstname")
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull
	@NotBlank(message = "please provide employee lastname")
	@Column(name = "lastname")
	private String lastname;
	
	@NotNull
	@javax.validation.constraints.Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Min(18)
	@Column(name = "age")
	private int age;
	
	@NotNull
	@NotBlank(message = "please provide employee gender")
	@Column(name = "gender")
	private String gender;
	
	
	 @Valid
	 @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee",cascade = CascadeType.ALL) 
	 private Address address;
	 
   
	public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}


 public Address getAddress() { return address; }
  
  public void setAddress(Address address) { this.address = address; }
 

	public Employee() {
		
	}

	public Employee(@NotBlank(message = "please provide employee") String firstname, String lastname, String email,
			int age, String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	
	
}
