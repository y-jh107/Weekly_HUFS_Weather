package com.hufs.weather.dto;

import lombok.Getter;

public class WeatherResponse {
    private String date;
    private double maxTemp;
    private double minTemp;
    private double rain;

    public WeatherResponse(String date, double maxTemp, double rain, double minTemp) {
        this.date = date;
        this.maxTemp = maxTemp;
        this.rain = rain;
        this.minTemp = minTemp;
    }
}
