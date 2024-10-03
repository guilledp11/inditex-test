package com.inditex.test.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.test.app.model.Price;

public interface PriceRepository {

	@Query(nativeQuery = true, value = "SELECT * FROM PRICE p WHERE p.START_DATE <= :date AND p.END_DATE >= :date AND p.PRODUCT_ID = :productId AND p.BRAND_ID = :brandId")
	List<Price> findByDateBetweenAndProductIdAndBrandId(@Param("date") Date date, @Param("productId") Long productId, @Param("brandId") Long brandId);
}
