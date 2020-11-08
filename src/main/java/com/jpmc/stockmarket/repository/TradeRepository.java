package com.jpmc.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpmc.stockmarket.entity.TradeEntity;

public interface TradeRepository extends JpaRepository<TradeEntity,String> {

	
}
