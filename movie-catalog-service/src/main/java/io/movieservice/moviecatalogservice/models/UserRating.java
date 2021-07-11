package io.movieservice.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    private String userId;
    
    private List<Rating>    uRatings;


    public UserRating() {
    }


    public UserRating(String userId, List<Rating> uRatings) {
        this.userId = userId;
        this.uRatings = uRatings;
    }
    

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public List<Rating> getURatings() {
        return this.uRatings;
    }

    public void setURatings(List<Rating> uRatings) {
        this.uRatings = uRatings;
    }


    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", uRatings='" + getURatings() + "'" +
            "}";
    }
    

}
