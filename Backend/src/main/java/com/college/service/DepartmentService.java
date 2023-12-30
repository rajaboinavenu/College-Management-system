package com.college.service;

import java.util.List;
import com.college.entity.Department;
import com.college.entity.Student;

public interface DepartmentService {
	
	public Department save(Department departments);
	
	public List<Department> findAllDepartments();	
	
	public Department findDepartmentById(Long id);
	
	public String deleteDepartmentById(Long id);
	
	public List<Department> findAllDepartmentByIdInDesc();

	

//	public Department updateDepartmentById(Long id, Department department);
	


}
