package com.kit.csg.crawler.typhoon.repositories;

import com.kit.csg.crawler.typhoon.entity.TyphoonRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("typhoonRouteRepository")
public interface TyphoonRouteRepository extends JpaRepository<TyphoonRoute, Integer> {
}