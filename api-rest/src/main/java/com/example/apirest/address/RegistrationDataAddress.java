package com.example.apirest.address;

import com.example.apirest.models.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegistrationDataAddress(
		
		@NotBlank
		String street,
		
		@NotBlank
		String neighborhood,
		
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String zipcode,
		
		@NotBlank
		String number,
		
		String complement,
		
		@NotBlank
		String city,
		
		@NotBlank
		String state) {

	public RegistrationDataAddress(Address address) {
		this(address.getStreet(), address.getNeighborhood(), address.getZipcode(), address.getNumber(), address.getComplement(), address.getCity(), address.getState());
	}
}
