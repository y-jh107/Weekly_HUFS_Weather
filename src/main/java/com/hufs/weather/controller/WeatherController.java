package com.hufs.weather.controller;

import com.hufs.weather.domain.Weather;
import com.hufs.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/this-week")
    @ResponseBody
    public List<Weather> getWeeklyWeather() {
        return weatherService.thisWeekWeather();
    }

//    @GetMapping("/weather/last-week")
//    public List<WeatherResponse> getLastWeekWeather(WeatherService weatherService) {
//    }
}
