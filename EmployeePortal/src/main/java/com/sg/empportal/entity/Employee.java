package com.sg.empportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee")
public class Employee {

	@JsonProperty("EmployeeId")
	@Id
	@Column
	private String emp_id;
	
	@JsonProperty("FirstName")
	@Column
	private String firstname;
	
	@JsonProperty("LastName")
	@Column
	private String lastname;
	
	@JsonProperty("Gender")
	@Column
	private String gender;
	
	@JsonProperty("DateOfBirth")
	@Column
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@JsonProperty("Department")
	@Column
	private String department;

	@JsonProperty("EmployeeId")
	public String getEmp_id() {
		return emp_id;
	}

	@JsonProperty("EmployeeId")
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	@JsonProperty("FirstName")
	public String getFirstname() {
		return firstname;
	}

	@JsonProperty("FirstName")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@JsonProperty("LastName")
	public String getLastname() {
		return lastname;
	}

	@JsonProperty("LastName")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@JsonProperty("Gender")
	public String getGender() {
		return gender;
	}

	@JsonProperty("Gender")
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty("DateOfBirth")
	public Date getDob() {
		return dob;
	}

	@JsonProperty("DateOfBirth")
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@JsonProperty("Department")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("Department")
	public void setDepartment(String department) {
		this.department = department;
	}
}
