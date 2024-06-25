package com.cbs.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.pojos.City;
import com.cbs.pojos.Theater;
import com.cbs.services.ICityService;
import com.cbs.services.ITheaterService;

@SpringBootTest
class CityServiceImplTest {

	@Autowired
	private ICityService cityService;
	
	@Autowired
	private ITheaterService thService;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFetchAllCities() {
		cityService.fetchAllCities().forEach(c -> System.out.println(c));
	}

	@Test
	void testGetCityById() {
		System.out.println(cityService.getCityById(416504));
	}

	@Test
	void testAddNewCity() {
		System.out.println(cityService.addNewCity(new City(416502, "Nesari")));
	}

	@Test
	void testDeleteCityById() {
		System.out.println(cityService.deleteCityById(416504));
	}
	
	@Test
	void testGetAllTheatersByCityPincode() {
		List<Theater> thList = cityService.getAllTheatersByCityPincode(411001);
		
		thList.forEach(t -> System.out.println(t));
	}
	

}