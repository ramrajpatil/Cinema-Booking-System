package com.cbs.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.pojos.Movie;
import com.cbs.pojos.Theater;
import com.cbs.services.ITheaterService;

@SpringBootTest
class TheaterServiceImplTest {

	@Autowired
	private ITheaterService thService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFetchAllTheaters() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTheaterById() {
		fail("Not yet implemented");
	}

	@Test
	void testAddNewTheater() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTheaterById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateTheaterDetails() {
		fail("Not yet implemented");
	}

	@Test
	void testFetchTheatersByCityPincode() {
		List<Theater> list = thService.fetchTheatersByCityPincode(411001);
		
		list.forEach(t -> System.out.println(t));
	}
	
	@Test
	void testFetchMoviesByTheaterId() {
		List<Movie> mList = thService.fetchMoviesByTheaterId(5);
		
		mList.forEach(System.err::println);
	}
}
