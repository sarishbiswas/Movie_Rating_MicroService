package com.sarish.moviecatalogservice.models;

import java.util.List;

public class UserRating {
	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public UserRating() {
		super();
	}

	public UserRating(List<Rating> ratings) {
		super();
		this.ratings = ratings;
	}
}
