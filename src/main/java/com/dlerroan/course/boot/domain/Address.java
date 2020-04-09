package com.dlerroan.course.boot.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Address extends AbstractEntity<Long> {
	
	@NotBlank
	@Column(nullable = false)
	private String streetName;
	
	@NotBlank
	@Column(nullable = false)
	private String district;
	
	@NotBlank
	@Column(nullable = false)
	private String city;
	
	@NotNull(message = "{NotNull.address.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.address.zipCode}")
	@Column(nullable = false, length = 9)
	private String zipCode;
	
	@NotNull(message = "{NotNull.address.number}")
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = false, length = 5)
	private Integer number;
	
	@Size(max = 255)
	private String complement;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
