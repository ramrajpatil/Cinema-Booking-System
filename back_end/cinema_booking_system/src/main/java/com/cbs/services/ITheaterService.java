package com.cbs.services;

import java.util.List;

import com.cbs.pojos.Movie;
import com.cbs.pojos.Theater;

public interface ITheaterService {

	List<Theater> fetchAllTheaters();
	
	Theater getTheaterById(int thId);
	
	Theater addNewTheater(Theater transientTheater, int cityId);
	
	String deleteTheaterById(int thId);
	
	Theater updateTheaterDetails(Theater detachedTheater, Theater existingTheater);
	
	
	List<Theater> fetchTheatersByCityPincode(int pincde);
	
	List<Movie> fetchMoviesByTheaterId(int thId);
}
