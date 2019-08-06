package com.hino.loyalty.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.hino.loyalty.domain.enums.PaymentStatus;

@Entity
@JsonTypeName("creditCard")
public class CreditCardPayment extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	Integer installmentNumber;
	
	public CreditCardPayment() {
		
	}

	public CreditCardPayment(Integer id, PaymentStatus status, PurchaseOrder order, Integer installmentNumber) {
		super(id, status, order);
		this.installmentNumber = installmentNumber;
		// TODO Auto-generated constructor stub
	}

	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}
	
	
	
}
