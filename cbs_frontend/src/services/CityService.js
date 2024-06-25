import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080";

export const listAllCities = () => {
  return axios.get(REST_API_BASE_URL + "/cities");
};

export const addNewCity = (city) => {
  return axios.post(REST_API_BASE_URL + "/cities", city);
};
export const getCityDetails = (cityId) => {
  return axios.get(REST_API_BASE_URL + "/movies/" + cityId);
};

// No update operation for city.

export const deleteCity = (cityId) => {
  return axios.delete(REST_API_BASE_URL + "/movies/" + cityId);
};