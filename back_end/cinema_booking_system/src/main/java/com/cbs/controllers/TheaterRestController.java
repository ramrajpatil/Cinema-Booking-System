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
import com.cbs.pojos.Theater;
import com.cbs.services.IMovieService;
import com.cbs.services.ITheaterService;


@RestController
@CrossOrigin
@RequestMapping("/theaters")
public class TheaterRestController {

	@Autowired
	private ITheaterService thService;
	@Autowired
	private IMovieService movieService;
	
	
	
	public TheaterRestController() {
		System.out.println("In theater rest controller.");
	}
	// Adding REST API end point: for getting all theaters.
	@GetMapping
	public List<Theater> getAllTheaters() {
		System.out.println("In getAllTheaters() "+getClass().getName());
		return thService.fetchAllTheaters();
	}
	
	// Adding REST API to add new theater details.
	@PostMapping("/{cityId}")
	public ResponseEntity<?> addNewTheaterDetails(@RequestBody Theater transientTheater, @PathVariable int cityId){
		System.out.println("In addNewTheaterDetails() "+getClass().getName());
		try {
			return ResponseEntity.ok(thService.addNewTheater(transientTheater, cityId));
		} catch (RuntimeException e) {
			System.out.println("Error in "+getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Adding new theater details failed!!!!", e.getMessage()), 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Adding REST API to delete theater by id.
	@DeleteMapping("/{thId}")
	public ResponseEntity<?> deleteTheaterDetails(@PathVariable int thId){
		System.out.println("In deleteTheaterDetails() "+getClass().getName()+" thId "+thId);
		return ResponseEntity.ok(new ResponseDTO(thService.deleteTheaterById(thId)));
	}
	
	// Adding REST API to getting theater details by id.
	@GetMapping("/{thId}")
	public ResponseEntity<?> getTheaterDetails(@PathVariable int thId){
		System.out.println("In getTheaterDetails() "+getClass().getName()+" thId= "+thId);
		try {
			return ResponseEntity.ok(thService.getTheaterById(thId));
		} catch (RuntimeException e) {
			System.out.println("Error in "+getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Fetching theater detailes failed!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	// Adding REST API to getting theater details by id.
	@PutMapping("/{thId}")
	public ResponseEntity<?> updateTheaterDetails(@PathVariable int thId, @RequestBody Theater detachedTheater){
		System.out.println("In updateTheaterDetails() "+getClass().getName()+" thId= "+thId);
		try {
			return ResponseEntity.ok(thService.updateTheaterDetails(detachedTheater, thService.getTheaterById(thId)));
		} catch (RuntimeException e) {
			System.out.println("Error in "+getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Updating theater detailes failed!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	
	}
	
	
	
//	@GetMapping("/movies/{thId}")
//	List<Movie> getMoviesByTheaterId(@PathVariable int thId){
//		System.out.println("In getMoviesByTheaterId " + getClass().getName() + " thId=  " +thId);
//		
//		return movieService.fetchMoviesByTheaterId(thId);
//	}
	
}
