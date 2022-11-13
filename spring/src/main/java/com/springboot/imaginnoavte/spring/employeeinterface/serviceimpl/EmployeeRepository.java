package com.springboot.imaginnoavte.spring.employeeinterface.serviceimpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;
import java.lang.String;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Integer> {


   EmployeeTable findByEmployeeID(String employeeid);
	
}
