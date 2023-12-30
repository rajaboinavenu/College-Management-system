package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	public Student findByUsernameAndPassword(String username,String password);
	
	public Student findByFirstName(String firstName);
	
	public Student findByEmail(String email);
	
	public List<Student> findAllByOrderByIdAsc();
	
	public List<Student> findAllByOrderByIdDesc();
	
//	public List<Student> findByDeptId(Long deptId);
	
}
