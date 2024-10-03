package com.inditex.test.app.rest.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Class that represents the JSON response of the REST API.
 */
public class TestResponse implements Serializable {

	/**
	 * Serializable,
	 */
	private static final long serialVersionUID = 2354523250798727906L;
	
	private Long productId;
	private Long brandId;
	private Integer priceList;
	private Date startDate;
	private Date endDate;
	private BigDecimal price;
	
	
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	} 
}
