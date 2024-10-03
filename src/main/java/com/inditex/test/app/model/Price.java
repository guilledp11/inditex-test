package com.inditex.test.app.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "PRICES")
public class Price {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "BRAND_ID", nullable = false)
	private Long brandId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID", insertable = false, updatable = false)
	private Brand brand;
	
	// No se aun si sera necesaria crear entidad
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false)
	private LocalDateTime startDate;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", nullable = false)
	private LocalDateTime endDate;
	
	@Column(name = "PRICE_LIST", nullable = false)
	private Integer priceList;
	
	@Column(name = "PRIORITY", nullable = false)
	private Integer priority;
	
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;
	
	@Column(name = "CURR", nullable = false)
	private String curr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
}
