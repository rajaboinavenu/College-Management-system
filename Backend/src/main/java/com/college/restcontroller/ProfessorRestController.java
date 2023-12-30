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

import com.college.service.ProfessorService;
import com.college.entity.Professor;
import com.college.entity.Student;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
@RequestMapping("/college")
public class ProfessorRestController {
	
	@Autowired
	ProfessorService professorService;
	
	@PostMapping("/professors")
	public Professor saveProfessor(@Valid @RequestBody Professor professor) {
		Professor theProfessor = professorService.save(professor);
		return theProfessor;
	}
	
	@GetMapping("/professors")
	public List<Professor> getAllProfessors() {
		List<Professor> professors = professorService.findAllProfessors();
		return professors;	
	}
	
	@GetMapping("/professors/{id}") // Ok
	private Professor getProfessorById(@PathVariable Long id) {
		 Professor professor = professorService.findProfessorById(id);
		return professor;
	}
	
	
//	@PutMapping("/professors/{id}")
//	public Professor updateProfessor( @Valid@RequestBody Professor professor) {
//		Professor result = professorService.update(professor);
//		
////		System.err.println("Updated");
//		return result;
//	}
	
	@PutMapping("/professors/{id}")   // Ok
	private Professor updateProfessor( @Valid@RequestBody Professor professor) {

		Professor professor1 = professorService.findProfessorById(professor.getId());

		System.out.println("OK");
		Professor result = professorService.updateProfessorById(professor1.getId(), professor);
		return result;
	}
	
//	@DeleteMapping("/professors/{id}")
//	public String deleteProfessor(@PathVariable Long id) {
////		Professor result = professorService.deleteProfessorById(id);
//		
//			professorService.deleteProfessorById(id);
//			return "Professor is deleted";
//	
//	}
	
	@DeleteMapping("/professors/{id}") // Ok
	private String deleteProfessor(@PathVariable Long id) {

		Professor professor = professorService.findProfessorById(id);
		
		professorService.deleteProfessorById(id);
//		return new ResponseEntity<Student>(student,HttpStatus.OK)+"\nDeleted student record";
		return "deleted professor record"; 
	}
	

	@GetMapping("/professors/byDesc") // Ok
	private List<Professor> findAllByOrderByIdDesc() {
		List<Professor> sortedByDescProfessor = professorService.findAllProfessorByIdInDesc();
		return sortedByDescProfessor;
	}

}
