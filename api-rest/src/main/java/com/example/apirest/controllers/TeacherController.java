package com.example.apirest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.models.Teacher;
import com.example.apirest.teacher.TeacherRegistrationData;
import com.example.apirest.teacher.TeacherRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Teacher> saveTeacher(@RequestBody @Valid TeacherRegistrationData data) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(new Teacher(data)));
	}

	@GetMapping
	public Page<Teacher> getAllTeachers(Pageable paginacao) {
		return repository.findAllByActiveTrue(paginacao);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getTeacherById(@PathVariable(value="id") Long id) {
	    Optional<Teacher> teacherO = repository.findById(id);
	    if(teacherO.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found.");
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(teacherO.get());
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> updateTeacher(@PathVariable(value = "id") Long id, @RequestBody @Valid TeacherRegistrationData data) {
	    Optional<Teacher> teacherO = repository.findById(id);
	    if (teacherO.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found.");
	    }
	    Teacher teacher = teacherO.get();
	    teacher.updateTeacher(data);
	    return ResponseEntity.status(HttpStatus.OK).body(repository.save(teacher));
	}
	/*
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> deleteTeacher(@PathVariable(value = "id") Long id) {
		Optional<Teacher> teacherO = repository.findById(id);
		if (teacherO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found.");
		}
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully.");
	}
	*/
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Object> disableTeacher(@PathVariable(value = "id") Long id) {
		Optional<Teacher> teacherO = repository.findById(id);
		if (teacherO.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found.");
		}
		Teacher teacher = teacherO.get();
		teacher.inactiveTeacher();
		return ResponseEntity.status(HttpStatus.OK).body("Teacher disabled successfully.");
	}

}
