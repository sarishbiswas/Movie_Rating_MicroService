package com.sarish.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sarish.moviecatalogservice.models.CatalogItem;
import com.sarish.moviecatalogservice.models.Movie;
import com.sarish.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		
		//Get all rated movie Id
		List<Rating> ratings = Arrays.asList(
				new Rating("1",4),new Rating("2",5)
			);
		//for each movie id call  movie-info-service and get details
		return ratings.stream().map(rating->{
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);

			return new CatalogItem(movie.getName(),"M Girl",rating.getRating());
			}).collect(Collectors.toList());
	}
}
