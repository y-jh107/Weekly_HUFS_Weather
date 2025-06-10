package com.hufs.weather.controller;

import com.hufs.weather.domain.Weather;
import com.hufs.weather.service.SeasonQuoteService;
import com.hufs.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final SeasonQuoteService seasonQuoteService;

    public WeatherController(WeatherService weatherService, SeasonQuoteService seasonQuoteService) {
        this.weatherService = weatherService;
        this.seasonQuoteService = seasonQuoteService;
    }

    @GetMapping("/this-week")
    @ResponseBody
    public List<Weather> getWeeklyWeather() {
        return weatherService.thisWeekWeather();
    }

    @GetMapping("/next-week")
    @ResponseBody
    public List<Weather> getLastWeekWeather(){
        return weatherService.nextWeekWeather();
    }

    @GetMapping("")
    @ResponseBody
    public String getSeasonQuote() {
        LocalDate today = LocalDate.now();
        return seasonQuoteService.getQuoteByDate(today);
    }

}



