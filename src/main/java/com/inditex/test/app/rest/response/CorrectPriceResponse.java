package com.inditex.test.app.rest.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inditex.test.app.dto.PriceDto;

/**
 * Class that represents the JSON response of the REST API.
 */
public class CorrectPriceResponse implements Serializable {

	/**
	 * Serializable,
	 */
	private static final long serialVersionUID = 2354523250798727906L;
	
	private Long productId;
	private Long brandId;
	private Integer priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	
	public static CorrectPriceResponse fromDto(PriceDto dto) {
		CorrectPriceResponse res = new CorrectPriceResponse();
		
		res.setBrandId(dto.getBrandId());
		res.setProductId(dto.getProductId());
		res.setPriceList(dto.getPriceList());
		res.setStartDate(dto.getStartDate());
		res.setEndDate(dto.getEndDate());
		res.setPrice(dto.getPrice());
		
		return res;
	}
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Integer getPriceList() {
		return priceList;
	}
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	} 
}
