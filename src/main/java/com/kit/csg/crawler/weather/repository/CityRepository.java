package com.kit.csg.crawler.weather.repository;

import com.kit.csg.crawler.weather.entity.CITY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cityRepository")
public interface CityRepository extends JpaRepository<CITY, Integer> {
}