package io.movieservice.ratingsdataservice.models;

import java.util.Arrays;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating>    uRatings;


    public UserRating() {
    }


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserRating(String userId, List<Rating> uRatings) {
        this.userId = userId;
        this.uRatings = uRatings;
    }
    

    public List<Rating> getURatings() {
        return this.uRatings;
    }

    public void setURatings(List<Rating> uRatings) {
        this.uRatings = uRatings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        this.setURatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
    }


    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", uRatings='" + getURatings() + "'" +
            "}";
    }
    

}
