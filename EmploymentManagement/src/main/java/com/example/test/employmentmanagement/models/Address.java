package com.example.test.employmentmanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressid;
	
	@NotNull
	@NotBlank(message = "please provide employee housenumber")
	@Column(name="housenumber")
	private String housenumber;
	
	@NotNull
	@NotBlank(message = "please provide employee city")
	@Column(name="city")
	private String city;
	
	@NotNull
	@NotBlank(message = "please provide emplyee phone number")
	@Pattern(regexp = "\\d{10}",message="phone number must be ten digits")
	@Column(name="phone")
	private String phone;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "employee_id",referencedColumnName = "id")
	private Employee employee;

	public long getAddressid() {
		return addressid;
	}

	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	public Address() {
		
	}

	public Address(String housenumber, String city, String phone, Employee employee) {
		super();
		this.housenumber = housenumber;
		this.city = city;
		this.phone = phone;
		this.employee = employee;
	}
	
}
