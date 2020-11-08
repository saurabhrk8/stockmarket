package com.jpmc.stockmarket;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.stockmarket.entity.StockEntity;
import com.jpmc.stockmarket.model.DividendYieldResponse;
import com.jpmc.stockmarket.model.StockResponse;
import com.jpmc.stockmarket.request.PERatioRequest;
import com.jpmc.stockmarket.request.RetriveDividendYieldRequest;
import com.jpmc.stockmarket.service.StockService;

@SpringBootTest
@AutoConfigureMockMvc
public class StockMarketControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private StockService stockService;

	@MockBean
	StockEntity stock;

	@Test
	public void retriveDividendYieldTest() throws Exception {

		given(this.stockService.retriveDividendYield("POP", 100)).willReturn(new BigDecimal("0.08"));

		RetriveDividendYieldRequest request = new RetriveDividendYieldRequest();
		request.setStockSymbol("POP");
		request.setStockPrice(100);
		String requestJason = objectMapper.writeValueAsString(request);

		DividendYieldResponse resposet = new DividendYieldResponse.Builder().dividendYield(new BigDecimal(0.08))
				.build();

		String resposetJason = objectMapper.writeValueAsString(resposet);

		this.mvc.perform(
				post("/stock/retriveDividendYield").contentType(MediaType.APPLICATION_JSON).content(requestJason))
				.andExpect(status().isOk()).andExpect(content().json(resposetJason));

	}

	@Test
	public void retriveDividendYieldNoFoundTest() throws Exception {

		given(this.stockService.retriveDividendYield("POP", 100)).willReturn(new BigDecimal(0.08));

		RetriveDividendYieldRequest request = new RetriveDividendYieldRequest();
		request.setStockSymbol("POP");
		request.setStockPrice(100);
		String json = objectMapper.writeValueAsString(request);

		this.mvc.perform(post("/stock1/retriveDividendYield").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isNotFound());

	}

	@Test
	public void findStockTest() throws Exception {
		
		StockEntity entity = new StockEntity();
		entity.setStockSymbol("TEA");
		entity.setType("Common");
		entity.setFixedDivident("");
		entity.setLastDivident(new BigDecimal(0.00));
		entity.setParValue(100);

		given(this.stockService.findStock("TEA")).willReturn(entity);

		StockResponse response = new StockResponse.Builder().type(entity.getType())
				.fixedDivident(entity.getFixedDivident()).parValue(entity.getParValue())
				.lastDivident(entity.getLastDivident()).build();

		String resposetJason = objectMapper.writeValueAsString(response);

		this.mvc.perform(get("/stock/findStock/?stockSymbol=TEA").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(resposetJason));
	}

	@Test
	public void findStockNotFoundTest() throws Exception {

		given(this.stockService.findStock("POP")).willReturn(stock);

		StockEntity respose = new StockEntity();
		respose.setStockSymbol("POP");

		this.mvc.perform(get("/stock1/findStock/?stockSymbol=TEA").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void findStockParameterMissingTest() throws Exception {

		given(this.stockService.findStock("POP")).willReturn(stock);

		StockEntity respose = new StockEntity();
		respose.setStockSymbol("POP");

		this.mvc.perform(get("/stock/findStock/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(400));
	}

	@Test
	public void getPERatioTest() throws Exception {

		given(this.stockService.getPERatio("POP", 100)).willReturn(new BigDecimal("1.25"));

		PERatioRequest request = new PERatioRequest();
		request.setStockPrice(100);
		request.setSymbol("POP");

		String json = objectMapper.writeValueAsString(request);

		this.mvc.perform(post("/stock/getPERatio").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andExpect(content().json("1.25"));
	}

	@Test
	public void getPERatioNotFoundTest() throws Exception {

		given(this.stockService.getPERatio("POP", 100)).willReturn(new BigDecimal("1.25"));

		PERatioRequest request = new PERatioRequest();
		request.setStockPrice(100);
		request.setSymbol("POP");

		String json = objectMapper.writeValueAsString(request);

		this.mvc.perform(post("/stock1/getPERatio").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isNotFound());
	}

	@Test
	public void getPERatioParameterMissingTest() throws Exception {

		given(this.stockService.getPERatio("POP", 100)).willReturn(new BigDecimal("1.25"));

		PERatioRequest request = new PERatioRequest();
		request.setStockPrice(100);
		// request.setSymbol("POP");

		String json = objectMapper.writeValueAsString(request);

		this.mvc.perform(post("/stock1/getPERatio").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().is(404));
	}

	@Test
	public void volumeWeightedStrockPriceTest() throws Exception {

		given(this.stockService.volumeWeightedStrockPrice("POP")).willReturn(2d);
		this.mvc.perform(get("/stock/volumeWeightedStrockPrice?symbol=POP").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void volumeWeightedStrockPriceNotFoundTest() throws Exception {

		given(this.stockService.volumeWeightedStrockPrice("POP")).willReturn(2d);
		this.mvc.perform(get("/stock1/volumeWeightedStrockPrice?symbol=POP").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}

	@Test
	public void volumeWeightedStrockPriceMissingParameterTest() throws Exception {

		given(this.stockService.volumeWeightedStrockPrice("POP")).willReturn(2d);

		this.mvc.perform(get("/stock/volumeWeightedStrockPrice").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is(400));

	}

}
