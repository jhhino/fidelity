package com.hino.loyalty.domain.enums;

public enum Tier {
	REGULAR(1,"Regular customer"),
	SPECIAL(2,"Special customer"),
	VIP(3,"VIP customer");
	
	private int id;
	private String description;
	
	private Tier(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static Tier toEnum(Integer id) {

		if (id == null) {
			return null;
		}
		
		for (Tier x : Tier.values()) {
			if (id.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: " + id);
	}
	
}
