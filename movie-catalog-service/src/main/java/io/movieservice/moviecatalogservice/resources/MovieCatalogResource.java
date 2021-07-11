package io.movieservice.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.movieservice.moviecatalogservice.models.CatalogItem;
import io.movieservice.moviecatalogservice.models.Movie;
import io.movieservice.moviecatalogservice.models.Rating;
import io.movieservice.moviecatalogservice.models.UserRating;
import io.movieservice.moviecatalogservice.services.MovieInfo;
import io.movieservice.moviecatalogservice.services.UserRatingsData;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // @Autowired
    // MovieInfo movieInfo;

    // @Autowired
    // UserRatingsData userRatingsData;

    // @Autowiewd
    // WebClient.Builder wenClientbuilder;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
                UserRating.class);

        return userRating.getURatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
                    Movie.class);
            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

    }

}
