import React from "react";
import { useParams } from "react-router-dom";

const TheaterMoviesComponent = () => {
    
  const { cityId } = useParams(); // destructuring
 
 
  return (
    <>
      <div>Inside City-Theaters Component</div>
      <h1>{cityId}</h1>
    </>
  );
};

export default TheaterMoviesComponent;
