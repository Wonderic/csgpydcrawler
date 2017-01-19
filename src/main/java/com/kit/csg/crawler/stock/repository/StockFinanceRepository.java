package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.entity.POWERECON_STOCKFINANCE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockFinanceRepository")
public interface StockFinanceRepository extends JpaRepository<POWERECON_STOCKFINANCE, Integer> {
}