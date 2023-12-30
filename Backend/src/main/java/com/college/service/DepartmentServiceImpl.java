package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.Department;
import com.college.entity.Student;
import com.college.repository.DepartmentRepository;
import com.college.exceptions.DataNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department save(Department departments) {
		Department department = departmentRepository.save(departments);
		if (department == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return department;
	}

	@Override
	public List<Department> findAllDepartments() {
		List<Department> deptList = departmentRepository.findAll();
		if (deptList.size() == 0)
			throw new DataNotFoundException("Currently list is empty !");
		return deptList;
	}

	@Override
	public Department findDepartmentById(Long id) {
		Optional<Department> result = departmentRepository.findById(id);

		Department theDept = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" Department not found !!!, whose id is  " + id);

		} else {
			theDept = result.get();
			return theDept;
		}
	}

	@Override
	public String deleteDepartmentById(Long id) {
		Department theDept = findDepartmentById(id);

		if (theDept != null)
			departmentRepository.delete(theDept);
		else
			throw new DataNotFoundException("Department not found!!!");
		return "Department with "+id+"is deleted.";
	}	
	
	@Override
	public List<Department> findAllDepartmentByIdInDesc() {
		List<Department> sortedByDescDepartment = departmentRepository.findAllByOrderByIdDesc();

		if (sortedByDescDepartment.size() == 0) {
			throw new DataNotFoundException("Student list is empty !!!");
		}
		return sortedByDescDepartment;
	}
	

}
