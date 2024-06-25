package com.cbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbs.custom.exception.MovieHandlingException;
import com.cbs.pojos.Movie;
import com.cbs.repos.MovieRepository;


@Service
@Transactional
public class MovieServiceImpl implements IMovieService {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ITheaterService thService;

	@Override
	public List<Movie> fetchAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Movie addNewMovie(Movie transientMovie, int theatreId) {
		// first adding the theater to the transient object of movie.
		transientMovie.getTheaters().
					add(thService.getTheaterById(theatreId));

		return movieRepo.save(transientMovie);
	}

	@Override
	public String deleteMovieById(int movieId) {
		// If cascade doesn't work, first delete the theaters then movie.
		movieRepo.deleteById(movieId);
		return "Movie details deleted Successfully for movieId= " + movieId;
	}

	@Override
	public Movie getMovieById(int movieId) {
		return movieRepo.findById(movieId).orElseThrow(() -> 
					new MovieHandlingException("Invalid movie id, movie doesn't exist by this id= "+movieId));
	}

	@Override
	public Movie updateMovie(Movie detachedMovie, Movie existingMovie) {
		if(movieRepo.existsById(existingMovie.getId())) {
			existingMovie.setTitle(detachedMovie.getTitle());
			existingMovie.setDirector(detachedMovie.getDirector());
			existingMovie.setCategory(detachedMovie.getCategory());
			existingMovie.setDuration(detachedMovie.getDuration());
			existingMovie.setImageLink(detachedMovie.getImageLink());
			existingMovie.setLanguage(detachedMovie.getLanguage());
			existingMovie.setViewingExp(detachedMovie.getViewingExp());			
			
			return movieRepo.save(existingMovie);
		}
		throw new MovieHandlingException("Invalid movie ID : Updation Failed !!!!!!!!! "+ detachedMovie.getId());
	}

//	@Override
//	public List<Movie> fetchMoviesByTheaterId(int thId) {
//		System.out.println("in fetchMoviesByTheaterId of "+getClass().getName()+"   thId= "+thId);
//		return movieRepo.findMoviesByTheatersId(thId);
//	}
	
	

}