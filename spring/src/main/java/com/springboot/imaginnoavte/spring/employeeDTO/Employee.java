package com.springboot.imaginnoavte.spring.employeeDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Employee {

	@NotNull(message = "Employee Id should not be null.")
	private String employeeID;
	@NotNull(message = "First Name should not be null.")
	private String firstName;
	@NotNull(message = "Last Name should not be null.")
	private String lastName;

	

	@NotNull(message = "Email ID should not be null.")
	@Email
	private String emailId;
	@NotNull(message = "Phone No should not be null.")
	private String phoneNo;
	@NotNull(message = "Date should not be null.")
	private String dateOfJoining;
	@NotNull(message = "Salary should not be null")
	@Min(value = 0, message = "Salary should be more than 0")
	private float salary;
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

	
	
	
	
}
