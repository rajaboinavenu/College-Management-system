package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.Professor;
import com.college.entity.Student;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	public Professor findByProfessorName(String name);
	
	public List<Professor> findAllByOrderByProfessorNameDesc();

	public List<Professor> findByDesignation(String designation);
	
	public List<Professor> findAllByOrderByIdDesc();

}
