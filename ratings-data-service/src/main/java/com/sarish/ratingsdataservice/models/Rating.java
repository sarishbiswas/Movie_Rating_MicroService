package com.sarish.ratingsdataservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rating {
	public Rating(int movieId, int rating) {
		// TODO Auto-generated constructor stub
		this.movieId = movieId;
		this.Rating = rating;
	}
	private int movieId;
	private int Rating;
	
}
