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
@Table(name = "Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	
//	@Column(unique = true)
//	@NotBlank(message = "username must be required")
//	@Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!")
//	private String username;
	
	@NotBlank(message = "Firstname must be required")
	@Column(name = "first_Name")
	private String firstName;
	
	@NotBlank(message = "Lastname must be required")
	@Column(name = "last_Name")
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
//	@Size(min = 4, max = 10, message = "Password length must be 4 to 10.")
//	private String password;
	
	private String departmentName;
	
	@JsonIgnore
	@ManyToOne
	private Department department;
		
		public Student() {
			super();
		}
		
		public Student(Long id,
				@NotBlank(message = "Firstname must be required") String firstName,
				@NotBlank(message = "Lastname must be required") String lastName,
				@NotBlank @Email String email, String departmentName,
				Department department) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
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
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", departmentName="
					+ departmentName + ", department=" + department + "]";
		}
		
			
	/*
 	 {
        "id": 1,
        "firstName": "Manish",
        "lastName": "Joshi",
        "email": "manish@gmail.com",
        "departmentName": "Computer Science",
        "department": {
            "id": 1001,
            "deptName": "Computer Science"
        }
    }
	*/
	
//	project introduction, advantages, technology used in project, screenshot of project and conclusion

}
