package com.springboot.imaginnoavte.spring.employeeinterface.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Integer> {


   EmployeeTable findByEmployeeID(String employeeid);

	
}
