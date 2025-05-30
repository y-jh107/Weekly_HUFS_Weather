package com.hufs.weather.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SeasonQuoteService {

    private final Map<String, List<String>> quotes = new HashMap<>();

    public SeasonQuoteService() {
        quotes.put("Spring", Arrays.asList(
                "No matter how long the winter, spring is sure to follow.",
                "Spring is nature’s way of saying, ‘Let’s party!’",
                "The beautiful spring came; and the human soul is apt to revive also.",
                "In the spring, I have counted 136 different kinds of weather."
        ));
        quotes.put("Summer", Arrays.asList(
                "Make hay while the sun shines.",
                "In summer, the song sings itself.",
                "One must maintain a little bit of summer, even in the middle of winter.",
                "Deep summer is when laziness finds respectability."
                "The summer night is like a perfection of thought."
                "Summer afternoon - Summer afternoon... the two most beautiful words in the English language."
        ));
        quotes.put("Fall", Arrays.asList(
                "Autumn shows us how beautiful it is to let things go.",
                "Life starts all over again when it gets crisp in the fall.",
                "Everyone must take time to sit and watch the leaves turn.",
                "Autumn carries more gold in its pocket than all the other seasons."
                "Autumn is a second spring when every leaf is a flower."
        ));
        quotes.put("Winter", Arrays.asList(
                "If we had no winter, the spring would not be so pleasant.",
                "To appreciate the beauty of a snowflake, it is necessary to stand out in the cold.",
                "Winter is not a season, it’s a celebration.",
                "Kindness is like snow – it beautifies everything it covers."
                "If winter comes, can spring be far behind?"
                "If we had no winter, the spring would not be so pleasant: if we did not taste of adversity, prosperity would not be so welcome."
        ));
    }

    public String getQuoteByDate(LocalDate date) {
        String season = getSeason(date);
        List<String> seasonQuotes = quotes.getOrDefault(season, List.of("No quote available."));
        return seasonQuotes.get(new Random().nextInt(seasonQuotes.getvalue().size()));
    }

    private String getSeason(LocalDate date) {
        int month = date.getMonthValue();
        if (month >= 3 && month <= 5) return "Spring";
        else if (month >= 6 && month <= 8) return "Summer";
        else if (month >= 9 && month <= 11) return "Fall";
        else return "Winter";
    }
}
