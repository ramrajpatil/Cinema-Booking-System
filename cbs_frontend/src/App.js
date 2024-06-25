import "./App.css";
import AddUserComponent from "./components/AddUserComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListUserComponent from "./components/ListUserComponent";
import HomePageComponent from "./components/HomePageComponent";
import ListMovieComponent from "./components/ListMovieComponent";
import TheaterMoviesComponent from "./components/TheaterMoviesComponent";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Register from "./pages/Register";

const USER_TYPES={
  PUBLIC: 'public',
  CUSTOMER:'CUSTOMER',
  ADMIN:'ADMIN'
}

const CURRENT_USER_TYPE=USER_TYPES.PUBLIC


function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>

            {/* // http://localhost:3000/ */}
            <Route path='/' element={<HomePageComponent/>}></Route>

            {/* // http://localhost:3000/movies */}
            <Route path='/movies' element={<ListMovieComponent/>}></Route>

            {/* // http://localhost:3000/users */}
            <Route path='/users' element={<ListUserComponent/>}></Route>

            {/* // http://localhost:3000/register */}
            <Route path='/add-user' element={<AddUserComponent/>}></Route>

            {/* // http://localhost:3000/update/:id */}
            <Route path='/update/:id' element={<AddUserComponent/>}></Route>
            
            {/* To list theaters and corresponding movies for a particular city. */}
            {/* // http://localhost:3000/city-th/:cityId */}
            <Route path='/city-th/:cityId' element={<TheaterMoviesComponent/>}></Route>



          </Routes>
        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
