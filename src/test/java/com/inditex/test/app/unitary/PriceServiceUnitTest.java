package com.inditex.test.app.unitary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.inditex.test.app.PriceMapper;
import com.inditex.test.app.dto.PriceDto;
import com.inditex.test.app.dto.PriceDto.PriceDtoBuilder;
import com.inditex.test.app.model.Price;
import com.inditex.test.app.model.Price.PriceBuilder;
import com.inditex.test.app.repository.PriceRepository;
import com.inditex.test.app.service.impl.PriceServiceImpl;

@SpringBootTest
public class PriceServiceUnitTest {

	@Mock
	private PriceMapper mapper;

	@Mock
	private PriceRepository repository;

	@InjectMocks
	private PriceServiceImpl priceService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@BeforeEach
	public void setUpMocks() {
		/**
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * when(repository.findByDateBetweenAndProductIdAndBrandId(input2, 35455L,
		 * 1L)).thenReturn(Arrays.asList(price1, price2));
		 * when(repository.findByDateBetweenAndProductIdAndBrandId(input3, 35455L,
		 * 1L)).thenReturn(Arrays.asList(price1));
		 * when(repository.findByDateBetweenAndProductIdAndBrandId(input4, 35455L,
		 * 1L)).thenReturn(Arrays.asList(price1, price3));
		 * when(repository.findByDateBetweenAndProductIdAndBrandId(input5, 35455L,
		 * 1L)).thenReturn(Arrays.asList(price1, price4));
		 * 
		 * 
		 * when(mapper.entityToDto(Optional.of(price2))).thenReturn(Optional.of(new
		 * PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output2Start)
		 * .setEndDate(output2End).setPrice(BigDecimal.valueOf(25.45)).build()));
		 * when(mapper.entityToDto(Optional.of(price3))).thenReturn(Optional.of(new
		 * PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output3Start)
		 * .setEndDate(output3End).setPrice(BigDecimal.valueOf(30.50)).build()));
		 * when(mapper.entityToDto(Optional.of(price4))).thenReturn(Optional.of(new
		 * PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output4Start)
		 * .setEndDate(output4End).setPrice(BigDecimal.valueOf(38.95)).build()));
		 **/
	}

	@Test
	public void TU1_PredefinedTest1() {
		LocalDateTime input1 = LocalDateTime.of(2020, 06, 14, 10, 00, 00);

		LocalDateTime output1Start = LocalDateTime.of(2020, 06, 14, 00, 00, 00);
		LocalDateTime output1End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

		Price price1 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriceList(1)
				.setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build();

		when(repository.findByDateBetweenAndProductIdAndBrandId(input1, 35455L, 1L)).thenReturn(Arrays.asList(price1));

		when(mapper.entityToDto(Optional.of(price1))).thenReturn(
				Optional.of(new PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start)
						.setPriceList(1).setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build()));

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input1, 35455L, 1L);
		assertTrue(result.isPresent());
		assertEquals(result.get().getPriceList(), 1); // Forma de comprobar que el resultado es el que tiene ese ID a 1.
	}

	@Test
	public void TU2_PredefinedTest2() {
		LocalDateTime input2 = LocalDateTime.of(2020, 06, 16, 10, 00, 00);

		LocalDateTime output1Start = LocalDateTime.of(2020, 06, 14, 00, 00, 00);
		LocalDateTime output1End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		LocalDateTime output2Start = LocalDateTime.of(2020, 06, 14, 15, 00, 00);
		LocalDateTime output2End = LocalDateTime.of(2020, 06, 14, 18, 30, 00);

		Price price1 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriceList(1)
				.setPriority(0).setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build();
		Price price2 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output2Start).setPriceList(2)
				.setPriority(1).setEndDate(output2End).setPrice(BigDecimal.valueOf(25.45)).build();

		when(repository.findByDateBetweenAndProductIdAndBrandId(input2, 35455L, 1L))
				.thenReturn(Arrays.asList(price1, price2));

		when(mapper.entityToDto(Optional.of(price2))).thenReturn(Optional
				.of(new PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output2Start).setPriority(1)
						.setPriceList(2).setEndDate(output2End).setPrice(BigDecimal.valueOf(25.45)).build()));

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input2, 35455L, 1L);
		assertTrue(result.isPresent());
		assertEquals(result.get().getPriceList(), 2); // Forma de comprobar que el resultado es el que tiene ese ID a 2.
	}

	@Test
	public void TU3_PredefinedTest3() {
		LocalDateTime input3 = LocalDateTime.of(2020, 06, 21, 10, 00, 00);

		LocalDateTime output1Start = LocalDateTime.of(2020, 06, 14, 00, 00, 00);
		LocalDateTime output1End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

		Price price1 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriceList(1)
				.setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build();

		when(repository.findByDateBetweenAndProductIdAndBrandId(input3, 35455L, 1L)).thenReturn(Arrays.asList(price1));

		when(mapper.entityToDto(Optional.of(price1))).thenReturn(Optional
				.of(new PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriority(0)
						.setPriceList(1).setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build()));

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input3, 35455L, 1L);
		assertTrue(result.isPresent());
		assertEquals(result.get().getPriceList(), 1); // Forma de comprobar que el resultado es el que tiene ese ID a 1.
	}

	@Test
	public void TU4_PredefinedTest4() {
		LocalDateTime input4 = LocalDateTime.of(2020, 06, 15, 10, 00, 00);

		LocalDateTime output1Start = LocalDateTime.of(2020, 06, 14, 00, 00, 00);
		LocalDateTime output1End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		LocalDateTime output3Start = LocalDateTime.of(2020, 06, 15, 00, 00, 00);
		LocalDateTime output3End = LocalDateTime.of(2020, 06, 15, 11, 00, 00);

		Price price1 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriceList(1)
				.setPriority(0).setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build();
		Price price3 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output3Start).setPriceList(3)
				.setPriority(1).setEndDate(output3End).setPrice(BigDecimal.valueOf(30.50)).build();

		when(repository.findByDateBetweenAndProductIdAndBrandId(input4, 35455L, 1L))
				.thenReturn(Arrays.asList(price1, price3));

		when(mapper.entityToDto(Optional.of(price3))).thenReturn(Optional
				.of(new PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output3Start).setPriceList(3)
						.setPriority(1).setEndDate(output3End).setPrice(BigDecimal.valueOf(30.50)).build()));

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input4, 35455L, 1L);
		assertTrue(result.isPresent());
		assertEquals(result.get().getPriceList(), 3); // Forma de comprobar que el resultado es el que tiene ese ID a 3.
	}

	@Test
	public void TU5_PredefinedTest5() {
		LocalDateTime input5 = LocalDateTime.of(2020, 06, 16, 21, 00, 00);

		LocalDateTime output1Start = LocalDateTime.of(2020, 06, 14, 00, 00, 00);
		LocalDateTime output1End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
		LocalDateTime output4Start = LocalDateTime.of(2020, 06, 15, 16, 00, 00);
		LocalDateTime output4End = LocalDateTime.of(2020, 12, 31, 23, 59, 59);

		Price price1 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output1Start).setPriceList(1)
				.setPriority(0).setEndDate(output1End).setPrice(BigDecimal.valueOf(35.50)).build();
		Price price4 = new PriceBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output4Start).setPriority(1)
				.setPriceList(4).setEndDate(output4End).setPrice(BigDecimal.valueOf(38.95)).build();

		when(repository.findByDateBetweenAndProductIdAndBrandId(input5, 35455L, 1L))
				.thenReturn(Arrays.asList(price1, price4));

		when(mapper.entityToDto(Optional.of(price4))).thenReturn(Optional
				.of(new PriceDtoBuilder().setProductId(35455L).setBrandId(1L).setStartDate(output4Start).setPriority(1)
						.setPriceList(4).setEndDate(output4End).setPrice(BigDecimal.valueOf(38.95)).build()));

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input5, 35455L, 1L);
		assertTrue(result.isPresent());
		assertEquals(result.get().getPriceList(), 4); // Forma de comprobar que el resultado es el que tiene ese ID a 2.
	}
	
	@Test
	public void TU6_NoResult() {
		LocalDateTime input6 = LocalDateTime.of(2024, 06, 16, 21, 00, 00);

		when(repository.findByDateBetweenAndProductIdAndBrandId(input6, 35455L, 1L))
				.thenReturn(Arrays.asList());

		Optional<PriceDto> result = priceService.findActualPriceByDateAndProductIdAndBrandId(input6, 35455L, 1L);
		assertTrue(result.isEmpty());
	}
}
