package com.college.service;

import java.util.List;
import com.college.entity.Student;

public interface StudentService {
	
	public Student save(Student theStudent);
	public List<Student> findAllStudent();
	public Student updateStudentById(Long theId,Student student);
	public void deleteStudentById(Long theId);
	public Student findStudentByFirstName(String firstName);
//	public Student findStudentByUsernameAndPassword(String username, String password);
	public List<Student> findAllStudentByIdInDesc();
	public Student findStudentById(Long id);

}
