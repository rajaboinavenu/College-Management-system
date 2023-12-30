package com.college.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.entity.Student;
import com.college.exceptions.DataNotFoundException;
import com.college.repository.StudentRepository;
import com.college.service.StudentService;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/college")
public class StudentRestController {
	
	@Autowired
	StudentService studentService;
	
	StudentRepository studentRepository; 

	@PostMapping("/students") // Ok
	private Student saveStudent(@Valid @RequestBody Student theStudent) {

		Student student = studentService.save(theStudent);		
		return student;
	}

	@GetMapping("/students")  //Ok
	private List<Student> getAllStudent() {
		List<Student> studentList = studentService.findAllStudent();
		return studentList;
	}

	@GetMapping("/students/{id}") // Ok
	private Student getStudentById(@PathVariable Long id) {
		Student student = studentService.findStudentById(id);
		return student;
	}


	@GetMapping("/students/byDesc") // Ok
	private List<Student> findAllByOrderByIdDesc() {
		List<Student> sortedByDescStudent = studentService.findAllStudentByIdInDesc();
		return sortedByDescStudent;
	}
//
//	@GetMapping("/login/{username}/{password}") // Ok
//	private Student loginStudent(@PathVariable String username, @PathVariable String password) {
//
//		Student getValidStudent = studentService.findStudentByUsernameAndPassword(username, password);
//
//		System.out.println(getValidStudent.getUsername());
//		return getValidStudent;
//	}
//	
//	@GetMapping("/students/{fisrtName}") // Ok
//	private Student loginStudent(@PathVariable String firstName) {
//
//		Student getValidStudent = studentService.findStudentByFirstName(firstName);
//
//		System.out.println(getValidStudent.getFirstName());
//		return getValidStudent;
//	}

//	@PutMapping("/students/{id}")   // Ok
//	private ResponseEntity<Student> updateStudent(  @RequestBody Student student,@PathVariable long id) {
//
//		Student student1 = studentRepository.findById(id)
//				.orElseThrow(() -> new DataNotFoundException("Student does not exist with id : "+id) );
//		
//		student1.setFirstName(student.getFirstName());
//		student1.setLastName(student.getLastName());
//		student1.setEmail(student.getEmail());
//		student1.setDepartmentName(student.getDepartmentName());	
//		
//		Student updatedStudent = studentRepository.save(student1);
//		
//		System.out.println("OK");
//		return ResponseEntity.ok(updatedStudent);
//
//	}
	

	@PutMapping("/students/{id}")   // Ok
	private Student updateStudent(@Valid @RequestBody Student student) {

		Student student1 = studentService.findStudentById(student.getId());

		System.out.println("OK");
		Student result = studentService.updateStudentById(student1.getId(), student);
		return result;
	}
	
	@DeleteMapping("/students/{id}") // Ok
	private String deleteStudent(@PathVariable Long id) {

		Student student = studentService.findStudentById(id);
		
		studentService.deleteStudentById(id);
//		return new ResponseEntity<Student>(student,HttpStatus.OK)+"\nDeleted student record";
		return "deleted Student record"; 
	}
	
	@GetMapping("/students/byMail/{email}") // Ok
	private Student getStudentByEmail(@PathVariable String email) {
		Student student= studentRepository.findByEmail(email);
		return student;
	}

}
