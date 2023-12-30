package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.college.entity.Student;
import com.college.exceptions.DataNotFoundException;
import com.college.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	StudentRepository studentRepo;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student save(Student theStudent) {

		Student result = studentRepo.findByFirstName(theStudent.getFirstName());
		if (result != null) {
			throw new DataNotFoundException("Already registerd, Try with different name ?");
		} else {
			Student student = studentRepo.save(theStudent);
			return student;
		}
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		if (allStudent.size() == 0) {
			throw new DataNotFoundException("Student list is empty !!!");
		}

		return allStudent;
	}

	@Override
	public Student updateStudentById(Long theId, Student student) {
		Student result = findStudentById(theId);
		if (result != null) {
			studentRepo.save(student);
			return student;
		} else
			throw new DataNotFoundException("Student  is not available !!!");

	}

	@Override
	public void deleteStudentById(Long theId) {
		Optional<Student> result = studentRepo.findById(theId);

//		Student student = new Student();
		if (result != null)
			studentRepo.deleteById(theId);

		else
			throw new DataNotFoundException("Student is not available !!!");
	}

//	@Override
//	public Student findStudentByUsernameAndPassword(String username, String password) {
//
//		Student student = studentRepo.findByUsernameAndPassword(username, password);
//
//		if (student == null)
//			throw new DataNotFoundException("Invalid Credential !!!");
//		return student;
//	}

	@Override
	public Student findStudentById(Long id) {
		Optional<Student> result = studentRepo.findById(id);

		Student student = null;
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new DataNotFoundException("Student not found !!, whose ID is " + id);
		}
		return student;
	}

	@Override
	public List<Student> findAllStudentByIdInDesc() {
		List<Student> sortedByDescStudent = studentRepo.findAllByOrderByIdDesc();

		if (sortedByDescStudent.size() == 0) {
			throw new DataNotFoundException("Student list is empty !!!");
		}
		return sortedByDescStudent;
	}
	
	@Override
	public Student findStudentByFirstName(String firstName) {
		Student student = studentRepo.findByFirstName(firstName);
		
				if (student == null)
					throw new DataNotFoundException("Invalid Credential !!!");
				return student;
	}
	

}

