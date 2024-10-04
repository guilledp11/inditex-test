package com.inditex.test.app.intergation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CorrectPriceEndpointIntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
	}
	
	// Creamos los tests de integración establecidos en el enunciado.

	@Test
	public void TI1_PredefinedTest1() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-14T10:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	public void TI2_PredefinedTest2() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-14T16:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(2))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
				.andExpect(jsonPath("$.price").value(25.45));
	}

	@Test
	public void TI3_PredefinedTest3() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-14T21:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(35.50));
	}

	@Test
	public void TI4_PredefinedTest4() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-15T10:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(3))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
				.andExpect(jsonPath("$.price").value(30.50));
	}

	@Test
	public void TI5_PredefinedTest5() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(38.95));
	}
	
	// Propios con otras casuísticas
	
	@Test
	public void TI6_InDateLowerLimitExact() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-14T00:00:00")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(35.50));
	}
	
	@Test
	public void TI7_InDateLowerLimitOneUp() throws Exception {
		this.mockMvc
		.perform(get("/api/prices/correct-price").param("date", "2020-06-14T00:00:01")
				.param("productId", "35455").param("brandId", "1"))
		.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
		.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(1))
		.andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$.price").value(35.50));
	}
	
	@Test
	public void TI8_InDateLowerLimitOneDown() throws Exception {
		this.mockMvc
		.perform(get("/api/prices/correct-price").param("date", "2020-06-13T23:59:59")
				.param("productId", "35455").param("brandId", "1"))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void TI9_InDateUpperLimitExact() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-12-31T23:59:59")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
				.andExpect(jsonPath("$.price").value(38.95));
	}
	
	@Test
	public void TI10_InDateUpperLimitOneUp() throws Exception {
		this.mockMvc
		.perform(get("/api/prices/correct-price").param("date", "2021-01-01T00:00:00")
				.param("productId", "35455").param("brandId", "1"))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void TI11_InDateUpperLimitOneDown() throws Exception {
		this.mockMvc
		.perform(get("/api/prices/correct-price").param("date", "2020-12-31T23:59:58")
				.param("productId", "35455").param("brandId", "1"))
		.andExpect(status().isOk()).andExpect(jsonPath("$.productId").value(35455))
		.andExpect(jsonPath("$.brandId").value(1)).andExpect(jsonPath("$.priceList").value(4))
		.andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
		.andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$.price").value(38.95));
	}
	
	
	@Test
	public void TI12_WrondBrandId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "35455").param("brandId", "2"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void TI13_WrondProductId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "35456").param("brandId", "1"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void TI14_MissingParamBrandId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "35455"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void TI15_MissingParamProductId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("brandId", "1"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void TI16_MissingParamDate() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void TI17_BadFormatParamDate() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "text")
						.param("productId", "35455").param("brandId", "1"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void TI18_BadFormatParamProductId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "text").param("brandId", "1"))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void TI19_BadFormatParamBrandId() throws Exception {
		this.mockMvc
				.perform(get("/api/prices/correct-price").param("date", "2020-06-16T21:00:00")
						.param("productId", "35455").param("brandId", "text"))
				.andExpect(status().isBadRequest());
	}
	

}
