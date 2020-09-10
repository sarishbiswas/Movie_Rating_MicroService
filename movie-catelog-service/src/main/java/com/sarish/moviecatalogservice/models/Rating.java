package com.sarish.moviecatalogservice.models;

public class Rating {
	private String movieId;
	private int Rating;
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public Rating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		Rating = rating;
	}
	public Rating() {
		super();
	}
	@Override
	public String toString() {
		return "Rating [movieId=" + movieId + ", Rating=" + Rating + "]";
	}
	
	
}
