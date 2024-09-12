package com.ajaysw.service;
import com.ajaysw.api.response.WeatherResponse;
import com.ajaysw.cache.AppCache;
import com.ajaysw.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    @Value("${weather_api_key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;


    public WeatherResponse getWeather(String city) {
        // Build the final URL dynamically using UriComponentsBuilder
//        String finalApi = UriComponentsBuilder.fromHttpUrl(API_BASE)
//                .queryParam("access_key", appCache.appCache.get(AppCache.keys.WEATHER_API))
//                .queryParam("query", city)
//                .toUriString();

        String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.API_KEY,apiKey).replace(Placeholders.CITY,city);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            WeatherResponse body = response.getBody();
            if (body != null) {
                return body;
            } else {
                System.out.println("WeatherResponse body is null");
            }
        } else {
            System.out.println("Failed to fetch weather data, HTTP Status: " + response.getStatusCode());
        }
        return null;
    }

}
