package com.college.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@GeneratedValue(generator = "deptid", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "deptid", initialValue = 1001)
	@Column(name = "dept_id")
	private Long id;
	
	@Column(name = "dept_Name")
	private String deptName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department")
	List<Professor> professorList = new ArrayList<Professor>();

	public Department() {
		super();
	}

	public Department(Long id, String deptName, List<Professor> professorList) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.professorList = professorList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Professor> getProfessorList() {
		return professorList;
	}

	public void setProfessorList(List<Professor> professorList) {
		this.professorList = professorList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName
				+ ", professorList=" + professorList + "]";
	}
	
	/*
	{
    "id": 1004,
    "deptName": "Electrical"
	}

	 */
	    
}
