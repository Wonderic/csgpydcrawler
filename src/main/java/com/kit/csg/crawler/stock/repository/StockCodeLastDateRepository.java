package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.entity.StockCodeLastDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockCodeLastDateRepository")
public interface StockCodeLastDateRepository extends JpaRepository<StockCodeLastDate, Integer> {
}