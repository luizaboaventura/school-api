package com.example.apirest.models;

import com.example.apirest.address.RegistrationDataAddress;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String street;
	private String neighborhood;
	private String zipcode;
	private String number;
    private String complement;
    private String city;
    private String state;
    
    public Address (RegistrationDataAddress data) {
    	this.street = data.street();
    	this.neighborhood = data.neighborhood();
    	this.zipcode = data.zipcode();
    	this.number = data.number();
    	this.complement = data.complement();
    	this.city = data.city();
    	this.state = data.state();
    }
    
    public void updatedAddress(RegistrationDataAddress data) {
    	this.street = data.street();
    	this.neighborhood = data.neighborhood();
    	this.zipcode = data.zipcode();
    	this.number = data.number();
    	this.complement = data.complement();
    	this.city = data.city();
    	this.state = data.state();
    }

}
