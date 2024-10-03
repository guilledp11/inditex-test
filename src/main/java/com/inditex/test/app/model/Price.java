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
	
	// No era estrictamente necesario crear la entidad Brand, pero la he creado.
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
	
	public Price() {}
	
    private Price(PriceBuilder builder) {
        this.id = builder.id;
        this.brandId = builder.brandId;
        this.productId = builder.productId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.priceList = builder.priceList;
        this.priority = builder.priority;
        this.price = builder.price;
        this.curr = builder.curr;
    }

    public Long getId() {
        return id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Brand getBrand() {
        return brand;
    }

    public Long getProductId() {
        return productId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurr() {
        return curr;
    }
    
    /**
     * Clase interna para hacer de Builder.
     */
    public static class PriceBuilder {
    	
        private Long id;
        private Long brandId;
        private Long productId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer priceList;
        private Integer priority;
        private BigDecimal price;
        private String curr;
        
        /**
         * Llama al constructor privado de la clase padre para crear la instancia.
         * @return la instancia creada.
         */
        public Price build() {
            return new Price(this);
        }

        public PriceBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PriceBuilder setBrandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public PriceBuilder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public PriceBuilder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public PriceBuilder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public PriceBuilder setPriceList(Integer priceList) {
            this.priceList = priceList;
            return this;
        }

        public PriceBuilder setPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public PriceBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PriceBuilder setCurr(String curr) {
            this.curr = curr;
            return this;
        }
    }
}
