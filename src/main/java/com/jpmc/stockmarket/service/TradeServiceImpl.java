package com.jpmc.stockmarket.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.stockmarket.entity.TradeEntity;
import com.jpmc.stockmarket.model.StockTradeRequest;
import com.jpmc.stockmarket.repository.TradeRepository;


@Service
public class TradeServiceImpl implements TradeService {
	private static final Logger log = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired(required = true)
	 private TradeRepository tradeRepository;
	
	@Autowired
	private StockService stockService;

	@Override
	public void addTrade(StockTradeRequest tradeRequest) {
		log.debug("Adding trade {} ", tradeRequest);
		stockService.findStock(tradeRequest.getSymbol());
		
		TradeEntity trade = new TradeEntity.Builder().symbol(tradeRequest.getSymbol()).type(tradeRequest.getType())
				.tradedPrice(tradeRequest.getTradePrice()).sharesQuantity(tradeRequest.getSharesQuantity()).timestamp(new Date()).build();
		
		tradeRepository.save(trade);
		log.debug("Adding trade Success");
		
	}

	@Override
	public List<TradeEntity> getLatestTrades(String symbol, int minutes) {
		log.debug("Geting Last Trades for symbol {} in last minutes {} ", symbol, minutes);
		List<TradeEntity> trades = tradeRepository.findAll();
		
		log.debug("Geting Last Trades [{}] for symbol {} in last minutes {} ", trades, symbol, minutes);
		return trades;
	}

	@Override
	public List<TradeEntity> getAllTrades() {
		log.debug("Geting All trades");
		List<TradeEntity> trades = tradeRepository.findAll();
		
		log.debug("Geting All Trades [{}]", trades);
		return trades;
	}
	
	public Double getGBCE() {
		log.debug("Getting GBCE");
		List<TradeEntity> trades = tradeRepository.findAll();
		Double gbce = 0d;
		
		if(trades != null && trades.size() != 0){
			Double priceProduct = 1d;
			for(TradeEntity trade : trades){
				priceProduct*=trade.getTradedPrice();
			}
			Double n = (double)trades.size();
			
			gbce = Math.pow(priceProduct, 1d/n);
		}
		
		log.debug("Got GBCE [{}]", gbce);
		
		return gbce;
	}

	
	
	


	
}
