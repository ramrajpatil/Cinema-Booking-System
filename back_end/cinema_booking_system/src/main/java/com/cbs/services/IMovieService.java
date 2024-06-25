package com.cbs.services;

import java.util.List;

import com.cbs.pojos.Movie;

public interface IMovieService {

	List<Movie> fetchAllMovies();
	
	Movie addNewMovie(Movie transientMovie, int theatreId);
	
	String deleteMovieById(int movieId);
	
	Movie getMovieById(int movieId);
	
	Movie updateMovie(Movie detachedMovie, Movie existingMovie);
	
//	List<Movie> fetchMoviesByTheaterId(int thId);
}
