# Cinema Booking System

## Overview
A robust cinema booking system from conceptualization to deployment, focusing on scalability and functionality. The system allows users to seamlessly reserve movie tickets and select seats.

## Features
- **User-Friendly Interface**: Designed with React for easy movie ticket reservations and seat selection.
- **Secure Backend**: Efficient server-side APIs using Spring Boot for secure operations.
- **Database Management**: Complex SQL queries to manage movie, theater, and booking information in a MySQL database.
- **Integration**: Seamless integration between frontend and backend components.
- **Testing and Debugging**: Conducted thorough testing and debugging to ensure application reliability and stability.
- **Security**: JWT Authentication and Spring Security to enhance the security of user data and transactions.

## Technologies Used
- **Frontend**: React
- **Backend**: Spring Boot
- **Database**: MySQL
- **Authentication**: JWT (JSON Web Tokens), Spring Security

## Getting Started

### Prerequisites
- Node.js
- Java JDK
- Spring Boot
- MySQL

### Installation

#### Frontend
1. Navigate to the `frontend` directory.
2. Install dependencies:
```bash
npm install
```   
3. Start the development server:
```bash
npm start
```

#### Backend
1. Navigate to the `backend` directory.
2. Configure the database settings in application.properties.
3. Build the project:
```bash
mvn clean install
```
4. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

## API Endpoints

### Authentication
- `POST /api/auth/register`: Register a new user.
- `POST /api/auth/login`: Login and retrieve a JWT token.

### Movies
- `GET /api/movies`: Retrieve all movies.
- `GET /api/movies/{MovieId}`: Retrieve a single movie by ID.
- `POST /api/movies`: Add a new movie.
- `PUT /api/movies/{MovieId}`: Update an existing movie.
- `DELETE /api/movies/{MovieId}`: Delete a movie.

### Theaters
- `GET /api/theaters`: Retrieve all theaters.
- `GET /api/theaters/{theatreId}`: Retrieve a single theater by ID.
- `POST /api/theaters`: Add a new theater.
- `PUT /api/theaters/{theatreId}`: Update an existing theater.
- `DELETE /api/theaters/{theatreId}`: Delete a theater.

### Bookings
- `GET /api/bookings`: Retrieve all bookings.
- `GET /api/bookings/{ticketId}`: Retrieve a single booking by ID.
- `POST /api/bookings`: Create a new booking.
- `PUT /api/bookings/{ticketId}`: Update an existing booking.
- `DELETE /api/bookings/{ticketId}`: Delete a booking.

## Contributing
- **Contributions** are welcome! Please fork the repository and create a pull request with your changes.

## E-R Diagram
https://github.com/ramrajpatil/Cinema-Booking-System/blob/main/db_resources/e_r_diagram.png
