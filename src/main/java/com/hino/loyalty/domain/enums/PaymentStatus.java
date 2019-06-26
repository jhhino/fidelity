package com.hino.loyalty.domain.enums;

public enum PaymentStatus {
	PENDING(1,"Payment pending for approval."),
	PAID(2,"Payment approved."),
	CANCELLED(3,"Payment denied.");
	
	private int id;
	private String description;
	
	private PaymentStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static PaymentStatus toEnum(Integer id) {

		if (id == null) {
			return null;
		}
		
		for (PaymentStatus x : PaymentStatus.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: " + id);
	}
	
}
