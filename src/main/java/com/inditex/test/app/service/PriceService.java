package com.inditex.test.app.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.test.app.dto.PriceDto;

public interface PriceService {

	/**
	 * Returns the Price object that should be elected, applying a priority and
	 * selection algorithm, given some imput parameters. Selects those for which the
	 * given date is between its beginning and ending dates, and those with the
	 * greatest priority.
	 * 
	 * @param date      the date for which we want to get the correct price.
	 * @param productId the product for which we want to get the correct price.
	 * @param brandId   the brand of the product and pice.
	 * @return the the Price object that should be elected.
	 */
	Optional<PriceDto> findActualPriceByDateAndProductIdAndBrandId(LocalDateTime date, Long productId, Long brandId);
}
