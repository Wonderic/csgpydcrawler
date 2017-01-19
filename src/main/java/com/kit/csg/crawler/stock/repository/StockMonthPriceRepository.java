package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.entity.POWERECON_STOCKMONTHPRICE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockMonthPriceRepository")
public interface StockMonthPriceRepository extends JpaRepository<POWERECON_STOCKMONTHPRICE, Integer> {
}