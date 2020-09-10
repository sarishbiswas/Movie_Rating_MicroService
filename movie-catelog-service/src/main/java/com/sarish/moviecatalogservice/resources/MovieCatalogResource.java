package com.sarish.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sarish.moviecatalogservice.models.CatalogItem;
import com.sarish.moviecatalogservice.models.Movie;
import com.sarish.moviecatalogservice.models.Rating;
import com.sarish.moviecatalogservice.models.RatingsList;
import com.sarish.moviecatalogservice.models.UserDetails;
import com.sarish.moviecatalogservice.repository.UserRepository;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	UserRepository repository;
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") int userId){
		UserDetails ud = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Not Found"));
//		System.out.println(ud);
		RatingsList ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, RatingsList.class);
//		System.out.println(ratings);
		List<CatalogItem> ci = new ArrayList<>();
		for(Rating r:ratings.getRatings()) {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+r.getMovieId(), Movie.class);
			ci.add(new CatalogItem(ud.getUserName(),movie.getMovieName(),r.getRating()));
		}
		return ci;
	}
}
