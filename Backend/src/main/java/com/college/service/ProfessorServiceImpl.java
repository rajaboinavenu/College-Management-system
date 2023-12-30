package com.college.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.entity.Professor;
import com.college.entity.Student;
import com.college.repository.ProfessorRepository;
import com.college.exceptions.DataNotFoundException;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	ProfessorRepository professorRepository;

	@Autowired
	public ProfessorServiceImpl(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@Override
	public Professor save(Professor professor) {
		Professor result = professorRepository.findByProfessorName(professor.getProfessorName());
		if (result != null) {
			throw new DataNotFoundException("Professor-name is already registerd, Try with different name ?");
		} else {
			Professor  professors= professorRepository.save(professor);
			return professors;
		}
	}

	@Override
	public Professor update(Professor professor) {
		Professor professors = professorRepository.save(professor);
		return professors;
	}

	@Override
	public List<Professor> findAllProfessors() {
		List<Professor> professors = professorRepository.findAll();
		if (professors.size() == 0) {
			throw new DataNotFoundException("List is empty !!");
		}
		return professors;
	}

	@Override
	public Professor findByProfessorName(String name) {
		Professor professor = professorRepository.findByProfessorName(name);
		if (professor == null) {
			throw new DataNotFoundException("Professor not found !!!");
		}
		return professor;
	}

	@Override
	public Professor findProfessorById(Long id) {
		Optional<Professor> result = professorRepository.findById(id);

		Professor theProfessor = null;
		if (result != null) {
				theProfessor= result.get();
			return theProfessor;
		} else
			throw new DataNotFoundException("Professor is not available whose id is " + id);
	}

	@Override
	public Professor deleteProfessorById(Long id) {
		Professor theProfessor = findProfessorById(id);

		if( theProfessor != null) {
			professorRepository.delete(theProfessor);
			return theProfessor;
		} else
			throw new DataNotFoundException("Professor is not available whose id is " + id);
	}



	@Override
	public List<Professor> findAllByOrderByProfessorNameDesc() {
		List<Professor> professors = professorRepository.findAllByOrderByProfessorNameDesc();

		if (professors.size() == 0) {
			throw new DataNotFoundException("List is empty !!");
		}
		return professors;
	}


	@Override
	public Professor updateProfessorById(Long id, Professor professor) {
		Professor result = findProfessorById(id);
		if (result != null) {
			professorRepository.save(professor);
			return professor;
		} else
			throw new DataNotFoundException("Professor  is not available !!!");
	}

	@Override
	public List<Professor> findAllProfessorByIdInDesc() {
		List<Professor> sortedByDescProfessor = professorRepository.findAllByOrderByIdDesc();

		if (sortedByDescProfessor.size() == 0) {
			throw new DataNotFoundException("Professor list is empty !!!");
		}
		return sortedByDescProfessor;
	}

}
