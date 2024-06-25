import React from "react";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listAllMovies, getMovieDetails } from "../services/MovieService";


const AddMovieComponent = () => {
  const [movies, setMovies] = useState([]);

  const navigator = useNavigate();
  useEffect(() => {
    getAllMovies();
  }, []);

  function getAllMovies() {
    listAllMovies()
      .then((response) => {
        console.log(response.data);
        setMovies(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function addNewMovie() {
    navigator("/add-movie");
  }

  function updateMovie(id) {
    navigator(`/update-movie/${id}`);
  }

  function removeMovie(id) {
    console.log(id);
    getMovieDetails(id)
      .then((response) => {
        getAllMovies();
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Movies</h2>
      <button
        type="button"
        className="btn btn-success mb-2"
        onClick={addNewMovie}
      >
        Add Movie
      </button>
      <table className="table table-success table-striped table-bordered">
        <thead>
          <tr>
            <th>Movie Id</th>
            <th>Title</th>
            <th>Duration</th>
            <th>Language</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Viewing Experience</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {movies.map((movie) => (
            <tr key={movie.id}>
              <td>{movie.id}</td>
              <td>{movie.title}</td>
              <td>{movie.duration}</td>
              <td>{movie.language}</td>
              <td>{movie.category}</td>
              <td>{movie.releaseDate}</td>
              <td>{movie.viewingExp}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateMovie(movie.id)}
                >
                  Update
                </button>

                <button
                  className="btn btn-danger"
                  style={{ marginLeft: "10px" }}
                  onClick={() => removeMovie(movie.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AddMovieComponent;
