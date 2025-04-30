package com.hufs.weather.controller;

import com.hufs.weather.dto.WeatherResponse;
import com.hufs.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping("/weather/this-week")
//    public List<WeatherResponse> getWeeklyWeather(WeatherService weatherService) {
//    }

//    @GetMapping("/weather/last-week")
//    public List<WeatherResponse> getLastWeekWeather(WeatherService weatherService) {
//    }
}
