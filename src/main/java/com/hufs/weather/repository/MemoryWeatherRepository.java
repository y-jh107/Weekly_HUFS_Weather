package com.hufs.weather.repository;

import com.hufs.weather.domain.Weather;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryWeatherRepository implements  WeatherRepository {

    private static Map<String, Weather> store = new HashMap<>();

    @Override
    public Weather save(Weather weather) {
        store.put(weather.getDate(), weather);
        return weather;
    }

    @Override
    public Optional<Weather> findByDate(String date) {
        return Optional.ofNullable(store.get(date));
    }

    @Override
    public List<Weather> findAll() {
        return new ArrayList<>(store.values());
    }
}