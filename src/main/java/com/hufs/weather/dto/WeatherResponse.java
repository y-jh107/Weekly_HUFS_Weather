package com.hufs.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResponse {
    private String date;
    private double maxTemp;
    private double minTemp;
    private String cond;
}
