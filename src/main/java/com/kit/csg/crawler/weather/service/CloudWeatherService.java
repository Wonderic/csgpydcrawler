package com.kit.csg.crawler.weather.service;

import com.kit.csg.crawler.weather.repository.CloudWeatherRepository;
import com.kit.csg.crawler.weather.entity.CLOUD_WEATHER_TABLE;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("cloudWeatherService")
@Transactional
public class CloudWeatherService {
    @Resource(name = "cloudWeatherRepository")
    CloudWeatherRepository cloudWeatherRepository;

    public List<CLOUD_WEATHER_TABLE> findAll(){
      return  cloudWeatherRepository.findAll();
    }

    public void save(CLOUD_WEATHER_TABLE cloud_weather_table){
        cloudWeatherRepository.save(cloud_weather_table);
    }

    public void save(List<CLOUD_WEATHER_TABLE> list){
        cloudWeatherRepository.save(list);
    }

}