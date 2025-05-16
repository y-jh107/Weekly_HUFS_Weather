package com.hufs.weather.repository;

import com.hufs.weather.domain.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository {
    Weather save(Weather weather);
    Optional<Weather> findByDate(String date);
    List<Weather> findAll();

}