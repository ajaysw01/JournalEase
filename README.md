# JournalEAse

A backend journal application built using **Spring Boot**, **JWT**, **Spring Security**, **MongoDB Atlas**, and **Redis**. This app allows users to securely create, read, update, and delete journal entries, manage their profiles, view current weather conditions, and includes admin functionality for managing users and cache.

## Features

### User Features
- **Journal Entries**: Create, update, delete, and view personal journal entries.
- **Authentication**: Secure authentication using JWT and Spring Security.
- **Weather Information**: Get greeted with current weather conditions.
- **Profile Management**: Update user profiles.
  
### Admin Features
- **User Management**: View all registered users and create new admin accounts.
- **Cache Management**: Clear application cache using Redis for improved performance.

## API Endpoints

### Public Endpoints
- `POST /public/create-user`: Create a new user.
- `GET /public/health`: Check application health.

### User Endpoints
- `POST /journal`: Create a new journal entry.
- `GET /journal`: Get all journal entries for the authenticated user.
- `GET /journal/id/{myId}`: Get a specific journal entry by ID.
- `PUT /journal/id/{myId}`: Update a journal entry by ID.
- `DELETE /journal/id/{myId}`: Delete a journal entry by ID.
- `PUT /user`: Update user profile.
- `DELETE /user`: Delete the authenticated user account.
- `GET /user/greetings`: Get a personalized greeting with current weather info.

### Admin Endpoints
- `GET /admin/all-users`: Retrieve all users.
- `POST /admin/create-admin`: Create a new admin user.
- `GET /admin/clear-cache`: Clear the application cache.

## Technologies Used
- **Spring Boot**: Backend framework to build RESTful APIs.
- **JWT (JSON Web Tokens)**: Used for stateless user authentication.
- **Spring Security**: Security framework for authentication and authorization.
- **MongoDB Atlas**: Cloud-hosted NoSQL database for storing user and journal data.
- **Redis**: Caching service for faster access to frequently requested data.
- **Weather API**: External API integration to provide real-time weather data.

## Getting Started

### Prerequisites
- Java 8+
- MongoDB Atlas account
- Redis installed or using a Redis cloud service
- Maven for building the project


### Postman Testing
You can use Postman to test the API by creating requests for each endpoint mentioned in the **API Endpoints** section.

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

Happy journaling!
