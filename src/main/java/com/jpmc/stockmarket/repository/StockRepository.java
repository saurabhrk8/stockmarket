package com.jpmc.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpmc.stockmarket.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, String> {

	
}
