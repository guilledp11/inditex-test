package com.inditex.test.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.test.app.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM PRICES p WHERE p.START_DATE <= :date AND p.END_DATE >= :date AND p.PRODUCT_ID = :productId AND p.BRAND_ID = :brandId")
	List<Price> findByDateBetweenAndProductIdAndBrandId(@Param("date") LocalDateTime date, @Param("productId") Long productId, @Param("brandId") Long brandId);
}
