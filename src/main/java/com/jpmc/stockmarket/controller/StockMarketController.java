package com.jpmc.stockmarket.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.stockmarket.entity.StockEntity;
import com.jpmc.stockmarket.model.DividendYieldResponse;
import com.jpmc.stockmarket.model.GBCESharesResponse;
import com.jpmc.stockmarket.model.StockResponse;
import com.jpmc.stockmarket.repository.StockRepository;
import com.jpmc.stockmarket.request.PERatioRequest;
import com.jpmc.stockmarket.request.RetriveDividendYieldRequest;
import com.jpmc.stockmarket.service.StockService;
import com.jpmc.stockmarket.service.TradeService;

@RestController
@RequestMapping("/stock")
public class StockMarketController {


	@Autowired
	private StockService stockService;

	@Autowired
	private TradeService tradeService;

	@PostMapping("/retriveDividendYield")
	public DividendYieldResponse retriveDividendYield(@RequestBody RetriveDividendYieldRequest request) {

		BigDecimal dividendYield = stockService.retriveDividendYield(request.getStockSymbol(), request.getStockPrice());

		DividendYieldResponse response = new DividendYieldResponse.Builder().dividendYield(dividendYield).build();
		return response;
	}

	@GetMapping("/findStock")
	public StockResponse findStock(@RequestParam("stockSymbol") String stockSymbol) {
		
		StockEntity entity = stockService.findStock(stockSymbol);
		
		StockResponse response = new StockResponse.Builder().type(entity.getType()).fixedDivident(entity.getFixedDivident()).parValue(entity.getParValue()).lastDivident(entity.getLastDivident()).build();

		return response;
	}

	@PostMapping("/getPERatio")
	public ResponseEntity<BigDecimal> getPERatio(@RequestBody PERatioRequest request) {
		return new ResponseEntity<>(stockService.getPERatio(request.getSymbol(), request.getStockPrice()),
				HttpStatus.OK);

	}

	@GetMapping("/volumeWeightedStrockPrice")
	public ResponseEntity<Double> volumeWeightedStrockPrice(@RequestParam("symbol") String symbol) {

		return new ResponseEntity<>(stockService.volumeWeightedStrockPrice(symbol), HttpStatus.OK);
	}

	@GetMapping("/gbce/index")
	public GBCESharesResponse getGBCEIndex() {

		Double gbce = tradeService.getGBCE();
		GBCESharesResponse response = new GBCESharesResponse.Builder().gbce(gbce).build();
		return response;
	}

}
