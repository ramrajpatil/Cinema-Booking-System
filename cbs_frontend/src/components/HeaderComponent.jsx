import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { listAllCities } from "../services/CityService";

const HeaderComponents = () => {
  const [cities, setCities] = useState([]);

  const [selectedCity, setSelectedCity] = useState();

  useEffect(() => {
    getAllCities(); // Function calling another function for code simplicity.
  }, []);

  function getAllCities() {
    listAllCities()
      .then((response) => {
        setCities(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  const handleCityChange = (event) => {
    const selectedCityId = event.target.value;
    
    console.log(event.target.value+" in handleCityChange HeaderComponent");
    
    setSelectedCity(selectedCityId);
  };

  return (
    <div className="header">
      <div className="logo_container">
        <Link to="/">
          <img
            className="myntra_home"
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRiWl7_BLMEz6TwzSy6UIE6vMN14uOvJWwUeA&s"
            alt="CBS home"
          />
        </Link>
      </div>
      <nav className="nav_bar">
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
        
        <form >
          <select value={selectedCity} onChange={handleCityChange}>
            <option value="">Select City</option>
            {cities.map((city) => (
              <option key={city.pincode} value={city.pincode}>
                {city.cityName}
              </option>
            ))}
          </select>
          {selectedCity && (
            <Link to={`/city-th/${selectedCity}`}>{selectedCity}</Link>
          )}
        </form>

        <Link to="/contact">ContactUs</Link>
        <Link to="/upcoming">Upcoming</Link>
      </nav>
      <div className="action_bar">
        <div className="action_container">
          <span className="material-symbols-outlined action_icon">person</span>
          <Link to="/profile">Profile</Link>
        </div>
        <div className="action_container">
          <span className="material-symbols-outlined">book_online</span>
          <Link to="/bookings">Bookings</Link>
        </div>
        <div className="action_container">
          <span className="material-symbols-outlined">logout</span>
          <Link to="/logout">Logout</Link>
        </div>
      </div>
    </div>
  );
};

export default HeaderComponents;
