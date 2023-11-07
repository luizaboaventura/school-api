package com.example.apirest.teacher;

import com.example.apirest.address.RegistrationDataAddress;
import com.example.apirest.models.Teacher;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record TeacherRegistrationData(
		
		@NotBlank
		String name, 
		
		@NotBlank
		@Pattern(regexp="\\d{6}")
		String registration, 
		
		@NotNull
		Subject subject,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		String phone,
		
		Boolean active,
		
		@NotNull
		@Valid
		RegistrationDataAddress address) {
	
    public TeacherRegistrationData(Teacher teacher) {
        this(teacher.getName(), teacher.getRegistration(), teacher.getSubject(), teacher.getEmail(), teacher.getPhone(), teacher.getActive(), new RegistrationDataAddress(teacher.getAddress()));
    }
	

}
