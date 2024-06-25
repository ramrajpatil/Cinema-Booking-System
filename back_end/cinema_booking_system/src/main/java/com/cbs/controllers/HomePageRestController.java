package com.cbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.pojos.City;
import com.cbs.pojos.Movie;
import com.cbs.services.ICityService;
import com.cbs.services.IMovieService;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomePageRestController {

	@Autowired
	private IMovieService movieService;

	@Autowired
	private ICityService cityService;

	public HomePageRestController() {
		System.out.println("In home page controller.");
	}

	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		return movieService.fetchAllMovies();
	}

	@GetMapping("/cities")
	public List<City> getAllCities() {
		return cityService.fetchAllCities();
	}
	
}
