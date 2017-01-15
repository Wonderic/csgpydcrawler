package com.kit.csg.crawler.stock.repository;

import com.kit.csg.crawler.stock.vo.DIM_STOCKCOMPANYINFORMATION;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("stockCompanyInformationRepository")
public interface StockCompanyInformationRepository extends JpaRepository<DIM_STOCKCOMPANYINFORMATION, Integer> {
}