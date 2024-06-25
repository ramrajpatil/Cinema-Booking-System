import React from "react";
// import { myAxios } from "./helper";

// export const signUp = (user) => {
//   return myAxios.post("/users/register", user).then((response) => response.data);
// };

import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080";

export const listAllUsers = () => {
  return axios.get(REST_API_BASE_URL + "/users");
};

export const addNewUser = (user) => {
  return axios.post(REST_API_BASE_URL + "/users/", user);
};
export const getUserDetails = (id) => {
  return axios.get(REST_API_BASE_URL + "/users/"+ id);
};
export const updateUser = (id, user) => {
  return axios.put(REST_API_BASE_URL + "/users/"+ id, user);
};
export const deleteUser = (id) => {
  return axios.delete(REST_API_BASE_URL + "/users/"+ id);
};
