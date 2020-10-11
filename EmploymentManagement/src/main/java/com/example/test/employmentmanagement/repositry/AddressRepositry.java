package com.example.test.employmentmanagement.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.employmentmanagement.models.Address;

@Repository
public interface AddressRepositry extends JpaRepository<Address, Long>{

}
