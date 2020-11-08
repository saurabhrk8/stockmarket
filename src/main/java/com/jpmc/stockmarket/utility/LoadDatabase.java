package com.jpmc.stockmarket.utility;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jpmc.stockmarket.entity.StockEntity;
import com.jpmc.stockmarket.entity.TradeEntity;
import com.jpmc.stockmarket.model.TradeType;
import com.jpmc.stockmarket.repository.StockRepository;
import com.jpmc.stockmarket.repository.TradeRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(StockRepository repository,TradeRepository tradeRepository) {

    return args -> {
      log.info("Preloading " + repository.save(new StockEntity("TEA", "Common", new BigDecimal(0), "",100 )));
      log.info("Preloading " + repository.save(new StockEntity("POP", "Common", new BigDecimal(8), "",100 )));
      log.info("Preloading " + repository.save(new StockEntity("ALE", "Common", new BigDecimal(0), "",100 )));
      log.info("Preloading " + repository.save(new StockEntity("GIN", "Preferred",new BigDecimal(8), "",100 )));
      log.info("Preloading " + repository.save(new StockEntity("JOE", "Common", new BigDecimal(13), "",250 )));
      
      log.info("Preloading " + tradeRepository.save(new TradeEntity("POP", TradeType.Buy,10.0,100l,new Timestamp(System.currentTimeMillis()))));
    };
  }

  
}