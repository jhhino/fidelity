package com.hino.loyalty.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hino.loyalty.domain.enums.Tier;

@Entity
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@Column(unique = true)
	private String email;
	private Integer tier;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Address> adressList = new ArrayList<Address>();
	
	@ElementCollection
	@CollectionTable(name = "phone")
	private Set<String> phones = new HashSet<String>();
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<PurchaseOrder> orderList = new ArrayList<PurchaseOrder>();
	
	public Customer() {
	}

	public Customer(Integer id, String name, String email, Tier tier) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.tier = (tier == null) ? null : tier.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	public Tier getTier() {
		return Tier.toEnum(tier);
	}

	public void setTier(Tier tier) {
		this.tier = tier.getId();
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public List<Address> getAdressList() {
		return adressList;
	}

	public void setAdressList(List<Address> adressList) {
		this.adressList = adressList;
	}

	public List<PurchaseOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<PurchaseOrder> orderList) {
		this.orderList = orderList;
	}
	
}
