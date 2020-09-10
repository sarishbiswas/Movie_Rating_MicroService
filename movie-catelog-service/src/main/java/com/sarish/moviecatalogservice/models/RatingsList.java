package com.sarish.moviecatalogservice.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsList {
	private List<Rating> ratings;
}
