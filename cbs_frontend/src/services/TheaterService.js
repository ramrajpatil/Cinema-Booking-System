import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080";

export const listAllTheater = () => {
  return axios.get(REST_API_BASE_URL + "/theaters");
};

export const addNewTheater = (theater, cityId) => {
  return axios.post(REST_API_BASE_URL + "/theaters/" + cityId, theater);
};
export const getTheaterDetails = (thId) => {
  return axios.get(REST_API_BASE_URL + "/theaters/" + thId);
};
export const updateTheater = (thId, theater) => {
  return axios.put(REST_API_BASE_URL + "/theaters/" + thId, theater);
};
export const deleteTheater = (thId) => {
  return axios.delete(REST_API_BASE_URL + "/theaters/" + thId);
};
