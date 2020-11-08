package com.jpmc.stockmarket.service;


import java.math.BigDecimal;

import com.jpmc.stockmarket.entity.StockEntity;

public interface StockService{

	BigDecimal retriveDividendYield(String stockSymbol, Integer stockPrice);
	
	StockEntity findStock(String stockSymbol);

	BigDecimal getPERatio(String symbol, Integer stockPrice);
	
	Double volumeWeightedStrockPrice(String symbol);


}
