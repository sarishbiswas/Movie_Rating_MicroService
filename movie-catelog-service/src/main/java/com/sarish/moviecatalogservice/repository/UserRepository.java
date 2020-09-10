package com.sarish.moviecatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sarish.moviecatalogservice.models.UserDetails;
@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
