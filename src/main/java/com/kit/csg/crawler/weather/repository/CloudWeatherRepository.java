package com.kit.csg.crawler.weather.repository;

import com.kit.csg.crawler.weather.entity.CLOUD_WEATHER_TABLE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cloudWeatherRepository")
public interface CloudWeatherRepository extends JpaRepository<CLOUD_WEATHER_TABLE, Integer> {
}