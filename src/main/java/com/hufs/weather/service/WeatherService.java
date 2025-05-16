package com.hufs.weather.service;

import com.hufs.weather.domain.Weather;
import com.hufs.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private static WeatherRepository weatherRepository;
    private static String apiKey = "1dcbe206437fd2070c9fca6ec759e2ef";

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather saveWeather(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }
}
