package io.movieservice.ratingsdataservice.models;

public class Rating {
    private String movieId;
    private int rating;

    public Rating() {
    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" +
            " movieId='" + getMovieId() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

}
