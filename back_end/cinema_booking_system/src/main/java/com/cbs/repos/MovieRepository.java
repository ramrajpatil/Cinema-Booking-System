package com.cbs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cbs.pojos.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
//	@Query("SELECT m FROM Movie m JOIN m.theaters t WHERE t.id = :theaterId")
//	List<Movie> findMoviesByTheatersId(int theaterId);
	
	
	
}
