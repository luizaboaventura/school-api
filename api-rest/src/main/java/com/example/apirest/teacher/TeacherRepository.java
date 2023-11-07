package com.example.apirest.teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	Page<Teacher> findAllByActiveTrue(Pageable paginacao);

}
