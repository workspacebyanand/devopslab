package com.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmgmt.model.Employee;

//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
