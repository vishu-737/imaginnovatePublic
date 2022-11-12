package com.springboot.imaginnoavte.spring.employeeDTO;

public class EmployeeDTO {

	private String employeeID;
	private String firstName;
	private String lastName;
	private int yearlySalary;
	private int taxAmount;
	private int cessAmount;

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

	public int getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public int getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(int taxAmount) {
		this.taxAmount = taxAmount;
	}

	public int getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(int cessAmount) {
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", yearlySalary=" + yearlySalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cessAmount;
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + taxAmount;
		result = prime * result + yearlySalary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		if (cessAmount != other.cessAmount)
			return false;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (taxAmount != other.taxAmount)
			return false;
		if (yearlySalary != other.yearlySalary)
			return false;
		return true;
	}

}
