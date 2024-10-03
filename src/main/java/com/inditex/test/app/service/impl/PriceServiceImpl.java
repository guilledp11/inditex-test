package com.inditex.test.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.test.app.PriceMapper;
import com.inditex.test.app.dto.PriceDto;
import com.inditex.test.app.model.Price;
import com.inditex.test.app.repository.PriceRepository;
import com.inditex.test.app.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	private PriceRepository repository;
	
	@Autowired
	private PriceMapper mapper;

	@Override
	public Optional<PriceDto> findActualPriceByDateAndProductIdAndBrandId(LocalDateTime date, Long productId, Long brandId) {
		List<Price> prices = this.repository.findByDateBetweenAndProductIdAndBrandId(date, productId, brandId);
		Optional<Price> result = prices.stream().reduce((p, acc) -> (acc.getPriority() < p.getPriority()) ? p : acc);
//		Alternativa: 
//		Optional<Price> result = prices.stream().max((p1, p2) -> p1.getPriority().compareTo(p2.getPriority()));
		
		return this.mapper.entityToDto(result);
	}

}
