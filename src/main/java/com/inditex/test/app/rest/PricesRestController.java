package com.inditex.test.app.rest;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.test.app.rest.response.TestResponse;

@RestController
@RequestMapping("/api/prices")
public class PricesRestController {

	// Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
	@GetMapping("/correct-price")
	public ResponseEntity<TestResponse> findCorrectPrice(@RequestParam("date") Date applicationDate, @RequestParam("productId") Long productId, @RequestParam("brandId") Long brandId) {
		
		
		return ResponseEntity.ok().build();
	}
}
