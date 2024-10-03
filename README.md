# JournalEase

A backend journal application built using **Spring Boot**, **JWT**, **Spring Security**, **MongoDB Atlas**, **Redis**, and **Kafka**. This app allows users to securely create, read, update, and delete journal entries, manage their profiles, view current weather conditions, and includes admin functionality for managing users and cache. The app also integrates **Kafka** for message streaming and processing.

## Features

### User Features
- **Journal Entries**: Create, update, delete, and view personal journal entries.
- **Authentication**: Secure authentication using JWT and Spring Security.
- **Weather Information**: Get greeted with current weather conditions.
- **Profile Management**: Update user profiles.
  
### Admin Features
- **User Management**: View all registered users and create new admin accounts.
- **Cache Management**: Clear application cache using Redis for improved performance.
  
### Kafka Integration
- **Message Streaming**: Kafka is used to stream important user or journal events within the system for further processing or analytics.

## API Endpoints

### Public Endpoints
- `POST /public/signup`: Create a new user.
- `POST /public/login`: login a  user.
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
- **Kafka**: Message streaming platform used for processing system events.
- **Weather API**: External API integration to provide real-time weather data.

## Getting Started

### Prerequisites
- **Java 8+**
- **MongoDB Atlas** account
- **Redis** installed or using a Redis cloud service
- **Kafka** installed and running on your local environment or using a managed Kafka service
- **Maven** for building the project

### Installation and Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ajaysw01/JournalEase.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd JournalEase
   ```

3. **Configure MongoDB Atlas** in the `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<dbname>?retryWrites=true&w=majority
   ```

4. **Configure Redis** in the `application.properties`:
   ```properties
   spring.redis.host=localhost
   spring.redis.port=6379
   ```

5. **Configure Kafka** in the `application.properties`:
   ```properties
   spring.kafka.bootstrap-servers=localhost:9092
   ```

6. **Build the Project Using Maven**:
   ```bash
   mvn clean install
   ```

7. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

### Postman Testing
You can use **Postman** to test the API by creating requests for each endpoint mentioned in the **API Endpoints** section.

### Kafka Setup
Make sure Kafka is running locally or on a managed service, and configure the `bootstrap-servers` in your `application.properties`. You can download Kafka [here](https://kafka.apache.org/downloads).

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

Happy journaling
