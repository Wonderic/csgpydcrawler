package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.vo.StockMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockMarketRepository")
public interface StockMarketRepository extends JpaRepository<StockMarket, Integer> {
}