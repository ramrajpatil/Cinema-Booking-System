import React from "react";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listAllMovies } from "../services/MovieService";

const HomePageComponent = () => {
  const [movies, setMovies] = useState([]);

  

  const navigator = useNavigate();
  useEffect(() => {
    getAllMovies();
  }, []);

  function getAllMovies() {
    listAllMovies()
      .then((response) => {
        console.log(response.data)
        setMovies(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <>


      
      <div className="homepage-outside-container">
        {movies.map((movie) => (
          <div className="homepage-movies-container" >
            
            <button className="homepage-movies-container-btn" key={movie.id} ><img src={movie.imageLink} alt="movie_img" /></button>
            <h4>{movie.title}</h4>
            <h5>Directory: {movie.director}</h5>
            <h5>Duration: {movie.duration} mins</h5>
            <h5>Language: {movie.language}</h5>
            <h5>Genre: {movie.category}</h5>
            <h5>Release Date: {movie.releaseDate}</h5>
            <h5>Experience it in: {movie.viewingExp}</h5>
          </div>
        ))}
      </div>
    </>
  );
};

export default HomePageComponent;
