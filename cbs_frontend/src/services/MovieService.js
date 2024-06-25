import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080";

export const listAllMovies = () => {
  return axios.get(REST_API_BASE_URL + "/movies");
};

export const addNewMovie = (movie) => {
  return axios.post(REST_API_BASE_URL + "/movies", movie);
};
export const getMovieDetails = (movieId) => {
  return axios.get(REST_API_BASE_URL + "/movies/" + movieId);
};
export const updateMovie = (movieId, movie) => {
  return axios.put(REST_API_BASE_URL + "/movies/" + movieId, movie);
};
export const deleteMovie = (movieId) => {
  return axios.delete(REST_API_BASE_URL + "/movies/" + movieId);
};
