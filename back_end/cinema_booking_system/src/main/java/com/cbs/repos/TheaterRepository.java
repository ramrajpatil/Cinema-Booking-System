package com.cbs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cbs.pojos.Movie;
import com.cbs.pojos.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    List<Theater> findAllTheatersByCityPincode(int pincode);
    
//    @Query(value = "SELECT m.* FROM movies m INNER JOIN theaters_movies tm ON m.id = tm.movie_id WHERE tm.theater_id = ?1", nativeQuery = true)
    
//    @Query("SELECT m FROM Movie m JOIN m.theaters tm WHERE tm.id = ?1")
//    List<Movie> findAllMoviesByTheaterId(int theaterId);
    
    @Query("select t.movies from Theater t where t.id=:theaterId")
    List<Movie> findAllMoviesByTheaterId(int theaterId);

}
