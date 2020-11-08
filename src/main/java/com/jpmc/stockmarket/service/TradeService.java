package com.jpmc.stockmarket.service;

import java.util.List;

import com.jpmc.stockmarket.entity.TradeEntity;
import com.jpmc.stockmarket.model.StockTradeRequest;

public interface TradeService{

	void addTrade(StockTradeRequest tradeRequest);
	
	List<TradeEntity> getLatestTrades(String symbol, int minutes);

	List<TradeEntity> getAllTrades();
	
	 Double getGBCE();
	
	

}
