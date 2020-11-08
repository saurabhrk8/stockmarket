package com.jpmc.stockmarket.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.stockmarket.entity.StockEntity;
import com.jpmc.stockmarket.entity.TradeEntity;
import com.jpmc.stockmarket.model.ResultCode;
import com.jpmc.stockmarket.model.StockType;
import com.jpmc.stockmarket.repository.StockRepository;
import com.jpmc.stockmarket.utility.StockException;


@Service
public class StockServiceImpl implements StockService {
	
	private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class); 
 
	private Integer minutes=1;
	
	 @Autowired(required = true)
	 private StockRepository stockRepository;
	 
	
	 @Autowired
	 private TradeService tradeService;


	public BigDecimal retriveDividendYield(String stockSymbol, Integer stockPrice) {
		log.debug("Finding Div Yield with Symbol {}, stockPrice {} ", stockSymbol, stockPrice);
		StockEntity stock = findStock(stockSymbol);
		BigDecimal dividendYield = null;
		if(StockType.Common.toString() == stock.getType()){
			
			dividendYield = stock.getLastDivident().divide(new BigDecimal(stockPrice));
		} else{
			dividendYield = new BigDecimal((Integer.parseInt(stock.getFixedDivident()) * stock.getParValue())/stockPrice);
		}
		
		log.debug("Div Yield {} with Symbol {}, stockPrice {} ", dividendYield, stockSymbol, stockPrice);
		return dividendYield;
	}

	public StockEntity findStock(String stockSymbol) {
		log.debug("Finding stock with Symbol {} ", stockSymbol);
		StockEntity stock = stockRepository.getOne(stockSymbol);

		if(stock == null){
			log.error("Not able to find the Stock {} ", stockSymbol);
			throw new StockException(ResultCode.STOCK_NOT_FOUND, "Stock ["+stockSymbol+"] is invalid");
		}
		log.debug("Found Stock[{}] with Symbol {} ", stock, stockSymbol);
		return stock;
	}


	public BigDecimal getPERatio(String symbol, Integer stockPrice) {
		log.debug("Finding PE Ratio with Symbol {} and StockPrice {}", symbol, stockPrice);
		BigDecimal dividendYield = retriveDividendYield(symbol, stockPrice);
		BigDecimal peRatio = new BigDecimal(stockPrice).divide(dividendYield);
		log.debug("PE Ratio {} with Symbol {} and StockPrice {}", peRatio, symbol, stockPrice);
		return peRatio;
	}

	public Double volumeWeightedStrockPrice(String symbol) {
		log.debug("Finding Vol Weighted Price with Symbol {} ", symbol);
				findStock(symbol);

				List<TradeEntity> trades = tradeService.getLatestTrades(symbol, minutes);
				Double volWeightedPrice = 0d;
				Long quantity = 0l;
				if (trades != null) {
					for (TradeEntity trade : trades) {
						quantity += trade.getSharesQuantity();
						volWeightedPrice += trade.getSharesQuantity() * trade.getTradedPrice();
					}
					volWeightedPrice = quantity.doubleValue();
				}
				log.debug("Vol Weighted Price {} with Symbol {}", volWeightedPrice, symbol);
				return volWeightedPrice;
	}




	
	


	
}
