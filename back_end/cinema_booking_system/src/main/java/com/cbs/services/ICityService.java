package com.cbs.services;

import java.util.List;

import com.cbs.pojos.City;
import com.cbs.pojos.Theater;

public interface ICityService {

	List<City> fetchAllCities();
	
	City getCityById(int cityId);
	
	City addNewCity(City transientCity);
	
	String deleteCityById(int cityId);
	
	// No method for city updation.
	
	List<Theater> getAllTheatersByCityPincode(int pincode);
}
