package com.hufs.weather.service;

import com.hufs.weather.domain.Weather;
import com.hufs.weather.repository.WeatherRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    private static WeatherRepository weatherRepository;
    private static String apiKey = "1dcbe206437fd2070c9fca6ec759e2ef";
    private static String lat = "37.2342";
    private static String lon = "127.2064";

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> fetchWeatherFromAPI(int days) {
        String url = "https://api.openweathermap.org/data/2.5/forecast/daily?lat=" + lat +
                "&lon=" + lon +
                "&cnt=" + days +
                "&appid=" + apiKey +
                "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);
        JSONArray dailyList = json.getJSONArray("list");

        List<Weather> weatherList = new ArrayList<>();

        for (int i = 0; i < dailyList.length(); i++) {
            JSONObject day = dailyList.getJSONObject(i);

            long timestamp = day.getLong("dt");
            String date = Instant.ofEpochSecond(timestamp)
                    .atZone(ZoneId.of("Asia/Seoul"))
                    .toLocalDate()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            JSONObject temp = day.getJSONObject("temp");
            double maxTemp = temp.getDouble("max");
            double minTemp = temp.getDouble("min");

            String cond = day.getJSONArray("weather")
                    .getJSONObject(0)
                    .getString("main");

            Weather weather = new Weather(date, maxTemp, minTemp, cond);
            weatherRepository.save(weather);
            weatherList.add(weather);
        }

        return weatherList;
    }

    public List<Weather> thisWeekWeather() {
        return fetchWeatherFromAPI(7);
    }
}
