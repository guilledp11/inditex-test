package com.inditex.test.app.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceDto {

    private Long id;
    private Long brandId;
    private Long productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer priority;
    private BigDecimal price;
    private String curr;

    private PriceDto(PriceDtoBuilder builder) {
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

    public static class PriceDtoBuilder {
        private Long id;
        private Long brandId;
        private Long productId;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer priceList;
        private Integer priority;
        private BigDecimal price;
        private String curr;
        
        public PriceDto build() {
            return new PriceDto(this);
        }

        public PriceDtoBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PriceDtoBuilder setBrandId(Long brandId) {
            this.brandId = brandId;
            return this;
        }

        public PriceDtoBuilder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public PriceDtoBuilder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public PriceDtoBuilder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public PriceDtoBuilder setPriceList(Integer priceList) {
            this.priceList = priceList;
            return this;
        }

        public PriceDtoBuilder setPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public PriceDtoBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public PriceDtoBuilder setCurr(String curr) {
            this.curr = curr;
            return this;
        }
    }
}
