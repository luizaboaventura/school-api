package com.example.apirest.models;

import java.io.Serializable;

import com.example.apirest.teacher.Subject;
import com.example.apirest.teacher.TeacherRegistrationData;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "teacher")
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String registration;
	
	@Enumerated(EnumType.STRING)
	private Subject subject; 
	
	private String email;
	
	private String phone;
	
	@Embedded
    private Address address;
	
	private Boolean active;
	
	public Teacher (TeacherRegistrationData data) {
		this.active = true;
		this.name = data.name();
		this.registration = data.registration();
		this.subject = data.subject();
		this.email = data.email();
		this.phone = data.phone();
		this.address = new Address(data.address());
	}
	
	public void updateTeacher(TeacherRegistrationData data) {
		this.name = data.name();
		this.registration = data.registration();
		this.subject = data.subject();
		this.email = data.email();
		this.phone = data.phone();
		this.active = data.active();
		this.address.updatedAddress(data.address());
	}
	
	public void inactiveTeacher() {
		this.active = false;
	}
	
}
