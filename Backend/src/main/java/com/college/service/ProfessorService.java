package com.college.service;

import java.util.List;

import javax.validation.Valid;

import com.college.entity.Professor;
import com.college.entity.Student;

public interface ProfessorService {

	public Professor save(Professor professor);
	
	public Professor update(Professor professor);
	
	public List<Professor> findAllProfessors();
	
	public Professor findByProfessorName(String name);
	
	public Professor findProfessorById(Long id);
	
	public Professor deleteProfessorById(Long id);
		
	public List<Professor> findAllByOrderByProfessorNameDesc();
	
	public List<Professor> findAllProfessorByIdInDesc();

	public Professor updateProfessorById(Long id, Professor professor);
}
