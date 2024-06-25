package com.cbs.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cbs.pojos.Movie;
import com.cbs.services.IMovieService;


@SpringBootTest
class MoviesServiceImplTest {
	
	@Autowired
	private IMovieService movieService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFetchAllMovies() {
		List<Movie> movies = movieService.fetchAllMovies();
		movies.forEach(System.out::println);
	}

	@Test
	void testAddNewMovie() {
//		title, duration,  director, String category, releaseDate, viewingExp, language, imageLink || theaterId
		movieService.addNewMovie(new Movie("Me Before You",
				122, "romance/drama", "2D",
				LocalDate.parse("2012-04-25"), "2D",
				"english", "efbejhf"), 2);
	}

	@Test
	void testDeleteMovieById() {
		System.out.println(movieService.deleteMovieById(25));
	}

	@Test
	void testGetMovieById() {
		System.out.println(movieService.getMovieById(1));
	}

	@Test
	void testUpdateMovie() {
		System.out.println(movieService.updateMovie(new Movie("Me Before You 2007",
				122, "wefh efae cufe", "romance/drama",
				LocalDate.parse("2007-04-24"), "2D",
				"english", "ef98y43nqc3rynryc8nbejhf"), movieService.getMovieById(12)));
	}


}
