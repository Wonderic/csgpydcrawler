package com.kit.csg.crawler.index.repository;

import com.kit.csg.crawler.index.entity.DimIntype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("dimIntypeRepository")
public interface DimIntypeRepository extends JpaRepository<DimIntype, Integer> {
}