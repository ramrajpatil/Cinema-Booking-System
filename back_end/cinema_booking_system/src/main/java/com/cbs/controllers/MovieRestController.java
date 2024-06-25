package com.cbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.dto.ErrorResponse;
import com.cbs.dto.ResponseDTO;
import com.cbs.pojos.Movie;
import com.cbs.services.IMovieService;

@RestController
@CrossOrigin("*")
@RequestMapping("/movies")
public class MovieRestController {

	@Autowired
	private IMovieService movieService;

	public MovieRestController() {
		System.out.println("In movie rest controller.");
	}

	// Adding REST API end point: for getting all theaters.
	@GetMapping
	public List<Movie> getAllMovies() {
		System.out.println("In getAllMovies() " + getClass().getName());
		return movieService.fetchAllMovies();
	}

	// Adding REST API end point: to add new movie details.
	@PostMapping("/{thId}")
	public ResponseEntity<?> addNewMovieDetails(@RequestBody Movie transientMovie, @PathVariable int thId) {
		System.out.println("In addNewMovieDetails() " + getClass().getName() + " thId=  " + thId);
		try {
			return ResponseEntity.ok(movieService.addNewMovie(transientMovie, thId));
		} catch (RuntimeException e) {
			System.out.println("Error in " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Adding new movie details failed!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Adding REST API end point: for getting all theaters.
	@DeleteMapping("/{movieId}")
	public ResponseEntity<?> deleteMovieDetails(@PathVariable int movieId) {
		System.out.println("In deleteMovieDetails() " + getClass().getName() + " movieId=  " + movieId);
		return ResponseEntity.ok(new ResponseDTO(movieService.deleteMovieById(movieId)));
	}

	// Adding REST API to get existing movie details by id
	@GetMapping("/{movieId}")
	public ResponseEntity<?> getMovieDetails(@PathVariable int movieId) {
		System.out.println("In getMovieDetails() " + getClass().getName());
		try {
			return ResponseEntity.ok(movieService.getMovieById(movieId));
		} catch (RuntimeException e) {
			System.out.println("Error in " + getClass().getName() + " movieId=  " + movieId);
			return new ResponseEntity<>(new ErrorResponse("Fetching movie details failed!!!", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}

	// Adding REST API end point to update existing movie details
	@PutMapping("/{MovieId}")
	public ResponseEntity<?> updateMovieDetailes(@RequestBody Movie detachedMovie, @PathVariable int movieId) {
		System.out.println("In updateMovieDetailes " + getClass().getName() + "  " + detachedMovie + " movieId= " + movieId);
		try {
			return ResponseEntity.ok(movieService.updateMovie(detachedMovie, movieService.getMovieById(movieId)));
		} catch (RuntimeException e) {
			System.out.println("Error in updateUserDetails() of " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Updating movie details failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	
	

}
