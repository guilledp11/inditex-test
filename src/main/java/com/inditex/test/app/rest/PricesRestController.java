package com.inditex.test.app.rest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.test.app.dto.PriceDto;
import com.inditex.test.app.rest.response.CorrectPriceResponse;
import com.inditex.test.app.service.PriceService;

/**
 * Controlador del endpoint para nuestra REST API.
 */
@RestController
@RequestMapping("/api/prices")
public class PricesRestController {
	
	@Autowired
	private PriceService service;

	@GetMapping("/correct-price")
	@ResponseBody
	public ResponseEntity<CorrectPriceResponse> findCorrectPrice(@RequestParam("date") LocalDateTime applicationDate, @RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {
		if(anyNull(applicationDate, productId, brandId)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		Optional<PriceDto> dtoRes = service.findActualPriceByDateAndProductIdAndBrandId(applicationDate, productId, brandId);
		
		if(dtoRes.isPresent()) {
			return ResponseEntity.ok(CorrectPriceResponse.fromDto(dtoRes.get()));
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	private boolean anyNull(Object... params) {
		return Arrays.asList(params).stream().anyMatch(obj -> obj == null);
	}
	
}
