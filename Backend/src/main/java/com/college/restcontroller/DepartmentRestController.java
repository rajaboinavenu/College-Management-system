package com.college.restcontroller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.service.DepartmentService;
import com.college.entity.Department;
import com.college.entity.Student;


@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/college")
public class DepartmentRestController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartments(@Valid @RequestBody Department dept) {
		Department theDepartment = departmentService.save(dept);
		
		return theDepartment;
	}
	
	@GetMapping("/departments")  // Ok
	public List<Department> getAllDepartments() {
		List<Department> allDepartments = departmentService.findAllDepartments();
		return allDepartments ;
	}
	

	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		Department dept = departmentService.findDepartmentById(id);
		return dept;
	}
	
	@GetMapping("/departments/byDesc") // Ok
	private List<Department> findAllByOrderByIdDesc() {
		List<Department> sortedByDescDepartment = departmentService.findAllDepartmentByIdInDesc();
		return sortedByDescDepartment;
	}
	
	@PutMapping("/departments")
	public Department upadteDepartment(@RequestBody Department dept) {
		
		Department result = departmentService.save(dept);
		
		System.err.println("Updated");
		return result;
	}
	
//	@PutMapping("/departmets/{id}")   // Ok
//	private Department updateDepartmet(@Valid @RequestBody Department department) {
//
//		Department department1 = departmentService.findDepartmentById(department.getId());
//
//		System.out.println("OK");
//		Department result = departmentService.updateDepartmentById(department1.getId(), department);
//		return result;
//	}
	

//	@DeleteMapping("/departments/{id}")
//	public String deleteDepartment(@PathVariable Long id) {
//		Department result = departmentService.findDepartmentById(id);
//		String msg=null;
//		if(result.getId() == id) 
//			 msg = departmentService.deleteDepartment(id);
//			
//			return msg;	
//	}
	
	@DeleteMapping("/departments/{id}") // Ok
	private String deleteStudent(@PathVariable Long id) {
		Department department = departmentService.findDepartmentById(id);
		departmentService.deleteDepartmentById(id);
//		return new ResponseEntity<Student>(student,HttpStatus.OK)+"\nDeleted student record";
		return "deleted Student record"; 
	}
}
