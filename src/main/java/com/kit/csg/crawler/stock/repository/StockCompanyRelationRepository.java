package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.vo.POWERECON_STOCKCOMPANYRELATION;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockCompanyRelationRepository")
public interface StockCompanyRelationRepository extends JpaRepository<POWERECON_STOCKCOMPANYRELATION, Integer> {
}