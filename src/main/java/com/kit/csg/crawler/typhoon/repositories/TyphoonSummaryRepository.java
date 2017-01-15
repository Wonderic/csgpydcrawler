package com.kit.csg.crawler.typhoon.repositories;

import com.kit.csg.crawler.typhoon.entity.TyphoonSummary;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("typhoonSummaryRepository")
@Transactional
public interface TyphoonSummaryRepository extends JpaRepository<TyphoonSummary, Integer> {
    @Transactional
    TyphoonSummary save(TyphoonSummary typhoonSummary);

    TyphoonSummary findOne(Example example);
}