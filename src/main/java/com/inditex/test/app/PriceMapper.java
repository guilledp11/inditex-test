package com.inditex.test.app;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.test.app.dto.PriceDto;
import com.inditex.test.app.dto.PriceDto.PriceDtoBuilder;
import com.inditex.test.app.model.Price;
import com.inditex.test.app.model.Price.PriceBuilder;

/**
 * Componente que mapea la clase Price, con dependencias y que representa mayor
 * nivel de acoplamiento a una tecnología, a un DTO que es un simple POJO.
 */
@Component
public class PriceMapper {

	public Optional<PriceDto> entityToDto(Optional<Price> entityOptional) {
		if (entityOptional.isEmpty()) {
			return Optional.empty();
		}

		Price entity = entityOptional.get();
		PriceDto dto = new PriceDtoBuilder().setId(entity.getId()).setBrandId(entity.getBrandId())
				.setProductId(entity.getProductId()).setStartDate(entity.getStartDate()).setEndDate(entity.getEndDate())
				.setPriceList(entity.getPriceList()).setPriority(entity.getPriority()).setPrice(entity.getPrice())
				.setCurr(entity.getCurr()).build();

		return Optional.of(dto);
	}

	public Optional<Price> dtoToEntity(Optional<PriceDto> dtoOptional) {
		if (dtoOptional.isEmpty()) {
			return Optional.empty();
		}

		PriceDto dto = dtoOptional.get();
		Price entity = new PriceBuilder().setId(dto.getId()).setBrandId(dto.getBrandId())
				.setProductId(dto.getProductId()).setStartDate(dto.getStartDate()).setEndDate(dto.getEndDate())
				.setPriceList(dto.getPriceList()).setPriority(dto.getPriority()).setPrice(dto.getPrice())
				.setCurr(dto.getCurr()).build();

		return Optional.of(entity);
	}
}
