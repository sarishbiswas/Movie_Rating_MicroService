package com.sarish.movieinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarish.movieinfoservice.models.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
