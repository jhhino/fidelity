package com.hino.loyalty.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cityName;
	private String ibgeCode;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	public City() {};
	
	public City(Integer id, String cityName, String ibgeCode, State state) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.ibgeCode = ibgeCode;
		this.state = state;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getIbgeCode() {
		return ibgeCode;
	}
	public void setIbgeCode(String ibgeCode) {
		this.ibgeCode = ibgeCode;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
