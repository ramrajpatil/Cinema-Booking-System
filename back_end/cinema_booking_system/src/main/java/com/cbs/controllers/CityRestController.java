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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.dto.ErrorResponse;
import com.cbs.dto.ResponseDTO;
import com.cbs.pojos.City;
import com.cbs.pojos.Theater;
import com.cbs.services.ICityService;
import com.cbs.services.ITheaterService;

@RestController
@CrossOrigin
@RequestMapping("/cities")
public class CityRestController {

	@Autowired
	private ICityService cityService;
	
	@Autowired
	private ITheaterService thService;

	public CityRestController() {
		System.out.println("In city rest controller.");
	}

	// Adding REST API end point: for getting all cities.
	@GetMapping
	public List<City> getAllCities() {
		System.out.println("In getAllCities() " + getClass().getName());
		return cityService.fetchAllCities();
	}

	// Adding REST API to create new city details.
	@PostMapping
	public ResponseEntity<?> addNewCityDetails(@RequestBody City transientCity) {
		System.out.println("In addNewCityDetails() " + getClass().getName());
		try {
			return new ResponseEntity<>(cityService.addNewCity(transientCity), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			System.out.println("Error in " + getClass().getName() + e);
			return new ResponseEntity<>(new ErrorResponse("Adding city details failed!!!", e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Adding REST API to delete city details by Id
	@DeleteMapping("/{pincode}")
	public ResponseEntity<?> deleteCityDetails(@PathVariable int pincode) {
		System.out.println("In deleteCityDetails() of " + getClass().getName() + "  " + pincode);
		return ResponseEntity.ok(new ResponseDTO(cityService.deleteCityById(pincode)));
	}

	// Adding REST API to get existing city details by id
	@GetMapping("/{pincode}")
	public ResponseEntity<?> getCityDetails(@PathVariable int pincode) {
		System.out.println("In getCityDetails() " + getClass().getName() + "   " + pincode);
		try {
			return ResponseEntity.ok(cityService.getCityById(pincode));
		} catch (RuntimeException e) {
			System.out.println("Error in " + getClass().getName());
			return new ResponseEntity<>(new ErrorResponse("Fetching city details failed!!!", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
	}
	
//	@GetMapping("/theaters/{pincode}")
//	public List<Theater> fetchTheaterByCityPincode(@PathVariable int pincode){
//		System.out.println("In fetchTheaterByCityPincode() "+getClass().getName()+"  pincode= "+pincode);
//		return thService.getTheaterByCityPincode(pincode);
//	}

	// No operation added to update the city in service layer.
//	@PutMapping("/{pincode}")
//	public ResponseEntity<?> updateCityDetails(@RequestBody City detachedCity, @PathVariable int pincode){
//		System.out.println("In updateCityDetails() "+getClass().getPackageName()+"  "+detachedCity+"  "+pincode);
//		
//		try {
//			return ResponseEntity.ok(cityService.updateCityDetails(detachedCity));
//		} catch (RuntimeException e) {
//			System.out.println("Error in "+getClass().getName());
//			return new ResponseEntity<>(new ErrorResponse("Updating city details failed!!!", e.getMessage()), HttpStatus.BAD_REQUEST);
//		
//		}
//		
//	}

}
