package io.movieservice.moviecatalogservice.models;

public class Movie {
   private String movieId; 
   private String name;
   private String desc;

    public Movie() {
    }

    public Movie(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getMovieId() {
        return this.movieId;

    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " movieId='" + getMovieId() + "'" +
            ", name='" + getName() + "'" +
            ", desc='" + getDesc() + "'" +
            "}";
    }
    

}
