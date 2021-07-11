package io.movieservice.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.movieservice.moviecatalogservice.models.CatalogItem;
import io.movieservice.moviecatalogservice.models.Movie;
import io.movieservice.moviecatalogservice.models.Rating;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getfallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        // for each movieId call movieinfo service and get details
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        // put them all together
        return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
    }

    public CatalogItem getfallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found !","No Description Avialable",rating.getRating());
    }
}
