package com.kit.csg.crawler.typhoon.repositories;

import com.kit.csg.crawler.typhoon.entity.TyphoonSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typhoonSummaryRepository")
public interface TyphoonSummaryRepository extends JpaRepository<TyphoonSummary, Integer> {
}