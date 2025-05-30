package com.hufs.weather.controller;

import com.hufs.weather.domain.Weather;
import com.hufs.weather.service.WeatherService;
import com.hufs.weather.service.SeasonQuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.time.LocalDate;





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

    @GetMapping("/next-week")
    @ResponseBody
    public List<Weather> getLastWeekWeather(){
        return weatherService.nextWeekWeather();
    }

    private final SeasonQuoteService seasonQuoteService;

    public WeatherController(WeatherService weatherService, SeasonQuoteService seasonQuoteService) {
        this.weatherService = weatherService;
        this.seasonQuoteService = seasonQuoteService;
    }

    @GetMapping("/quote")
    @ResponseBody
    public String getSeasonQuote(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return seasonQuoteService.getQuoteByDate(date);
    }

}



