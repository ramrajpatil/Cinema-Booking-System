package com.cbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cbs.custom.exception.CityHandlingException;
import com.cbs.pojos.City;
import com.cbs.pojos.Theater;
import com.cbs.repos.CityRepository;


@Service
@Transactional
public class CityServiceImpl implements ICityService {

	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<City> fetchAllCities() {
		return cityRepo.findAll();
	}

	@Override
	public City getCityById(int pincode) {
		return cityRepo.findById(pincode).orElseThrow(() -> 
							new CityHandlingException("Invalid city Id, no city exists by this id= "+pincode));
	}

	@Override
	public City addNewCity(City transientCity) {
		return cityRepo.save(transientCity);
	}

	@Override
	public String deleteCityById(int pincode) {
//		List<Theater> theaterList = thRepo.getTheatersByCityId(cityId);
//		theaterList.forEach(th -> theaterList.remove(th));
		
		cityRepo.deleteById(pincode);
		return "City details deleted Successfully for cityId= " + pincode;
	}

	@Override
	public List<Theater> getAllTheatersByCityPincode(int pincode) {
		return cityRepo.getTheatersByPincode(pincode);
	}

}