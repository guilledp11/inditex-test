package com.inditex.test.app;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.inditex.test.app.dto.PriceDto;
import com.inditex.test.app.model.Price;

/**
 * Componente que mapea la clase Price, con dependencias y que representa mayor nivel de acoplamiento a una tecnología, a un DTO que es un simple POJO.
 */
@Component
public class PriceMapper {

	public Optional<PriceDto> entityToDto(Optional<Price> entityOptional) {
		if(entityOptional.isEmpty()) {
			return Optional.empty();
		}
		
		Price entity = entityOptional.get();
		PriceDto dto = new PriceDto();
		
		dto.setId(entity.getId());
        dto.setBrandId(entity.getBrandId());
        dto.setProductId(entity.getProductId());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setPriceList(entity.getPriceList());
        dto.setPriority(entity.getPriority());
        dto.setPrice(entity.getPrice());
        dto.setCurr(entity.getCurr());
        
		return Optional.of(dto);
	}
	
	public Optional<Price> dtoToEntity(Optional<PriceDto> dtoOptional) {
		if(dtoOptional.isEmpty()) {
			return Optional.empty();
		}
		
		PriceDto dto = dtoOptional.get();
		Price entity = new Price();
		
		entity.setId(dto.getId());
		entity.setBrandId(dto.getBrandId());
		entity.setProductId(dto.getProductId());
		entity.setStartDate(dto.getStartDate());
		entity.setEndDate(dto.getEndDate());
		entity.setPriceList(dto.getPriceList());
		entity.setPriority(dto.getPriority());
		entity.setPrice(dto.getPrice());
		entity.setCurr(dto.getCurr());
		
		return Optional.of(entity);
	}
}
