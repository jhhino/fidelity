package com.hino.loyalty.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.hino.loyalty.domain.Product;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String skuNumber;
	private String skuName;
	private String brandName;
	private BigDecimal price;
	
	public ProductDTO() {}
	
	public ProductDTO(Product p) {
		this.id = p.getId();
		this.skuNumber = p.getSkuNumber();
		this.skuName = p.getSkuName();
		this.brandName = p.getBrandName();
		this.price = p.getPrice();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSkuNumber() {
		return skuNumber;
	}
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
