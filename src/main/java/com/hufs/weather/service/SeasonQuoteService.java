package com.hufs.weather.service;

import com.hufs.weather.domain.Quote;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SeasonQuoteService {

    private final Quote quote = new Quote();

    public String getQuoteByDate(LocalDate date) {
        String season = getSeason(date);
        List<String> seasonQuotes = quote.getQuotes().getOrDefault(season, List.of("No quote available."));
        int idx = new Random().nextInt(0, seasonQuotes.size());
        return seasonQuotes.get(idx);
    }

    private String getSeason(LocalDate date) {
        int month = date.getMonthValue();
        if (month >= 3 && month <= 5) return "Spring";
        else if (month >= 6 && month <= 8) return "Summer";
        else if (month >= 9 && month <= 11) return "Fall";
        else return "Winter";
    }
}
