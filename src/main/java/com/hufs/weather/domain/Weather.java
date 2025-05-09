package com.hufs.weather.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Weather {
    private String date;
    private double maxTemp;
    private double minTemp;
    private String cond;
}
