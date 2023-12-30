package com.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professorid")
	private Long id;
	
	@NotBlank(message = "Name must be required")
	@Column(name = "name")
	private String professorName;
	
	@NotBlank
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "experience")
	private String experience;
	
	@NotBlank(message = "Phone number must be required. !!")
	@Size(min = 10, max = 10, message = "Invalid phone number!!")
	private String contactNumber;
	
	@NotBlank(message = "Email must be required !!")
	@Email
	private String email;
	
//	@Size(min = 4, max = 10, message = "Password length must be 4 to 10. !!")
//	private String password;
	
	private String departmentName;
	
	@JsonIgnore
	@ManyToOne
	private Department department;

	public Professor() {
		super();
	}

	public Professor(Long id,
			@NotBlank(message = "Name must be required") String professorName,
			@NotBlank String designation, String experience,
			@NotBlank(message = "Phone number must be required. !!") @Size(min = 10, max = 10, message = "Invalid phone number!!") String contactNumber,
			@NotBlank(message = "Email must be required !!") @Email String email,
			String departmentName, Department department) {
		super();
		this.id = id;
		this.professorName = professorName;
		this.designation = designation;
		this.experience = experience;
		this.contactNumber = contactNumber;
		this.email = email;
		this.departmentName = departmentName;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", professorName=" + professorName
				+ ", designation=" + designation + ", experience=" + experience
				+ ", contactNumber=" + contactNumber + ", email=" + email
				+ ", departmentName=" + departmentName + ", department="
				+ department + "]";
	}

	

	/*
	 {
        "id": 1,
        "professorName": "Rahul Shaha",
        "designation": "HOD",
        "experience": "15Yrs",
        "contactNumber": "8747986734",
        "email": "rahul123@gamil.com",
        "departmentName": "Computer Science",
        "department": {
            "id": 1001,
            "deptName": "Computer Science"
        }
    }
	 */
	
}
