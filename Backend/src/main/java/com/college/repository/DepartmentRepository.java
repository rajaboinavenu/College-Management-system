package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.Department;
import com.college.entity.Student;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public List<Department> findByDeptName(String deptName);
	
	public List<Department> findAllByOrderByIdDesc();

}
