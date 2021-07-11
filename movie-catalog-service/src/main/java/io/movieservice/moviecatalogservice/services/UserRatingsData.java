package io.movieservice.moviecatalogservice.services;

import java.util.Arrays;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import io.movieservice.moviecatalogservice.models.Rating;
import io.movieservice.moviecatalogservice.models.UserRating;

public class UserRatingsData {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getfallbackUserRating")
    public UserRating getUserRating(String userId) {
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
                UserRating.class);
        return ratings;
    }

    public UserRating getfallbackUserRating(String userId) {
        UserRating userRating = new UserRating(userId, Arrays.asList(
            new Rating("1234",2)
        ));
        return userRating;
    }
}
