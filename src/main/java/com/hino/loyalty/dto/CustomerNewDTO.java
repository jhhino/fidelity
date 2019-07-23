package com.hino.loyalty.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hino.loyalty.service.validation.CustomerInsert;

@CustomerInsert
public class CustomerNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Name is required.")
	@Length(min = 5, max=60, message = "Name must have at least 5 characters.")
	private String name;
	
	@NotEmpty(message = "Email account is required.")
	@Email
	private String email;
	
	private Integer tier;
	
	private String addressName;
	private String street;
	private String complement;
	private String neighbor;
	
	@NotEmpty(message = "Postal Code is required.")
	private String postalCode;
	
	private String mainPhone;
	private String secPhone;
	
	private Integer cityId;
	
	public CustomerNewDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(String neighbor) {
		this.neighbor = neighbor;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	public String getSecPhone() {
		return secPhone;
	}

	public void setSecPhone(String secPhone) {
		this.secPhone = secPhone;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
}
