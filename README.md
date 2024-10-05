# SemantiCore

**SemantiCore** is an internal process optimization platform designed to integrate data across production, logistics, and management systems using semantic technologies and Industry 4.0 ontologies. It provides advanced analytics capabilities, including OEE (Overall Equipment Effectiveness) calculations, to enhance operational efficiency and decision-making. The platform leverages modern microservices architecture and event-driven messaging to provide a scalable, real-time system.

## Features

- **Data Integration**:
  - Connects various data sources within the organization using **Industry 4.0** ontologies and **semantic technologies** for flexible data models.
  - Supports **OPC UA** for industrial device communication.
  - Integrates with **IoT** and **SCADA** systems.
  
- **Event-Driven Architecture**:
  - Utilizes **Apache Pulsar** for real-time messaging and event streaming between microservices.
  - Supports **Publish/Subscribe** and **Queue-based messaging** for scalable and reliable communication.

- **Advanced Analytics**:
  - Real-time **OEE** (Overall Equipment Effectiveness) calculations for production optimization.
  - Customizable **KPIs** and **dashboards** for operational insights.

- **User Interface**:
  - Built with **Vue.js** and **Vuetify** for a responsive design and modern user experience.
  - **Drag-and-drop** functionality using **Vue Draggable** for intuitive interaction and configuration.

- **API Support**:
  - Provides **RESTful APIs** and **GraphQL** for data access and manipulation.
  - Industrial communication via **OPC UA** and other common protocols (e.g., MQTT).

- **Security**:
  - Implements robust authentication and authorization with **Spring Security**.
  - Supports **OAuth2** and **JWT** (JSON Web Tokens) for secure API access.

## Architecture Overview

SemantiCore is built using a **microservices architecture** that relies on **Apache Pulsar** for real-time messaging and event streaming. The system integrates data from multiple sources, including IoT devices, SCADA systems, and management systems, to provide a unified view for decision-making and analytics.

### High-Level Architecture

```plaintext
+------------------+           +------------------+           +------------------+
|                  |           |                  |           |                  |
|   Vue.js         |   Pulsar   |   Spring Boot    |   Pulsar   |   PostgreSQL     |
|   Frontend       +<---------->+   Backend        +<---------->+   Database       |
|   (Vuetify)      |   Broker   |   Microservices  |           |                  |
|                  |           |                  |           |                  |
+------------------+           +------------------+           +------------------+
                     ^                ^                ^
                     |                |                |
               +----------------+  +-------------+  +-----------------+
               |  Data Sources   |  |  SCADA/IoT  |  | External APIs   |
               | (Sensors, PLCs) |  | (OPC UA)    |  | (Third-Party)   |
               +----------------+  +-------------+  +-----------------+
```

### Components

- **Apache Pulsar**: Event-driven messaging system that supports real-time data streaming and decouples communication between microservices.
- **Spring Boot Backend**: Handles business logic, data processing, and integrations with databases and external systems.
- **Vue.js Frontend**: Provides a modern, responsive user interface with real-time data visualization.
- **Databases**: Stores both relational (PostgreSQL) and graph data (Neo4j), and supports semantic RDF data (Apache Jena Fuseki).

## Technology Stack

### Frontend

- **Vue.js**: JavaScript framework for building user interfaces.
- **Vuetify**: Material Design component framework for Vue.js.
- **Vue Draggable**: Drag-and-drop library for customizable UI interactions.
- **Axios**: HTTP client for API requests.

### Backend

- **Java 21**: Primary backend programming language.
- **Spring Boot**: Framework for building microservices, with support for REST APIs and data integration.
- **Spring Data JPA**: Abstraction layer for database access.
- **Spring Security**: Provides authentication and authorization mechanisms, including OAuth2 and JWT.

### Messaging & Streaming

- **Apache Pulsar**:
  - Real-time event streaming.
  - Supports both **publish/subscribe** and **message queuing**.
  - **Pulsar Functions** for lightweight data processing within the broker.
  
### Data Integration

- **Semantic Technologies**:
  - **RDF**, **OWL**, **SPARQL** for semantic data modeling.
  - **Industry 4.0 Ontologies** (e.g., RAMI4.0) for standard data models.
  - **Apache Jena**: Framework for semantic data storage and querying.
  - **OPC UA**: Industrial protocol via **Eclipse Milo** for machine-to-machine communication.

### Databases

- **PostgreSQL**: Relational database for core business and operational data.
- **Neo4j**: Graph database for managing relationships and graph-like data.
- **Apache Jena Fuseki**: Triple store for storing and querying RDF data.

### APIs and Protocols

- **RESTful APIs**: For easy data access and integration with external systems.
- **GraphQL**: Flexible query language for exposing backend data.
- **OPC UA**: For communication with industrial devices (e.g., PLCs, SCADA).
- **MQTT**: Lightweight messaging protocol for IoT devices.

## Architecture

### Services and Modules

#### Frontend (Vue.js + Vuetify)
- Purpose:
  - User interface for interacting with the systems.
- Responsibilities:
  - Real-time visualization of production data, OEE, and KPIs.
  - Management of SCADA/IoT devices via the UI.
  - Dashboard with drag-and-drop components for dynamic configuration.
  - Interfaces for user management and authentication.
- Technologies:
  - Vue.js, Vuetify, Vue Draggable, Axios.
#### Backend (Spring Boot)
- Purpose:
  - Central business logic and data processing.
- Responsibilities:
  - Management of API endpoints (REST and GraphQL) for the frontend.
  - Processing and analysis of production and machine data (e.g., OEE calculations).
  - Connection to external systems via OPC UA, MQTT, etc.
  - Management of user roles and security mechanisms (Spring Security, OAuth2, JWT).
- Technologies:
  - Spring Boot, Spring Data JPA, Spring Security.
#### Apache Pulsar (Messaging Broker)
- Purpose:
  - Event-driven communication and message streaming between microservices.
- Responsibilities:
  - Real-time messaging between services (Pub/Sub, queue-based messaging).
  - Management of event streams for data-driven analysis and automation.
  - Integration of Pulsar Functions for lightweight data processing within the broker.
- Technologies:
  - Apache Pulsar.
#### Data Integration Services
- Purpose:
  - Integration and management of data from various sources (OPC UA, IoT, SCADA, etc.).
- Responsibilities:
  - Collect and process data from machines (e.g., OPC UA, MQTT).
  - Provide APIs for querying real-time data.
  - Manage production processes through Industry 4.0 ontologies and semantic technologies.
- Technologies:
  - OPC UA (Eclipse Milo), MQTT, Spring Boot.
#### OEE Calculation Service
- Purpose:
  - Calculate OEE values for production optimization.
- Responsibilities:
  - Calculate machine availability, performance, and quality based on incoming data.
  - Real-time OEE analysis and storage of results in the database.
- Technologies:
  - Spring Boot, PostgreSQL, InfluxDB (for time-series data).
#### Semantic Data Service
- Purpose:
  - Manage and analyze semantic data.
- Responsibilities:
  - Store and query RDF data (triples) in a semantic database.
  - Use SPARQL for querying and analyzing the data.
  - Utilize Industry 4.0 ontologies like RAMI4.0 for standardization.
- Technologies:
  - Apache Jena Fuseki, RDF, OWL, SPARQL.
#### Database Services
- Purpose:
  - Manage relational and graph-based data.
- Responsibilities:
  - Store business data (PostgreSQL) and semantic data (Apache Jena Fuseki).
  - Manage production data, user information, and machine configurations.
- Technologies:
  - PostgreSQL, Neo4j (graph database), Apache Jena Fuseki (RDF triple store).
#### Security Service
- Purpose:
  - Provide authentication and authorization mechanisms.
- Responsibilities:
  - Manage user roles, permissions, and access control (Spring Security).
  - Integrate OAuth2 and JWT for secure API usage.
  - Encrypt sensitive data and protect APIs from unauthorized access.
- Technologies:
  - Spring Security, OAuth2, JWT.
#### Monitoring Service
- Purpose:
  - Monitor system states and services.
- Responsibilities:
  - Real-time monitoring of system components and production processes.
  - Provide alerts and notifications in case of system failures.
  - Store log and monitoring data in an InfluxDB.
- Technologies:
  - InfluxDB, Grafana (optional visualization).


## Installation

### Prerequisites

Ensure the following tools are installed on your machine:

- **Docker** and **Docker Compose**
- **Java Development Kit (JDK) 21** or higher
- **Node.js** and **npm**
- **Git**
- **IntelliJ IDEA** or **VSCode** (Recommended IDEs)

### Backend Setup

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/semanticore.git
   ```

2. **Navigate to the backend directory**:

   ```bash
   cd semanticore/backend/SemantiCoreBackend
   ```

3. **Build the backend Docker image**:

   ```bash
   docker-compose up --build
   ```

### Frontend Setup

1. **Navigate to the frontend directory**:

   ```bash
   cd semanticore/frontend
   ```

2. **Install dependencies**:

   ```bash
   npm install
   ```

3. **Run the frontend in development mode**:

   ```bash
   npm run serve
   ```

### Running the Full System

1. Ensure **Docker** is running on your machine.
2. From the root directory of the project, run the following command:

   ```bash
   docker-compose up --build
   ```

3. The following services will be started:
   - **Apache Pulsar**: Running on `localhost:6650`.
   - **Backend** (Spring Boot): Accessible at `localhost:8080`.
   - **Frontend** (Vue.js): Accessible at `localhost`.

### Stopping the System

To stop all running services, run the following command:

```bash
docker-compose down
```

## How it Works

- **Apache Pulsar** acts as the messaging backbone, decoupling communication between services, ensuring scalability, and enabling real-time data streaming.
- **Spring Boot** handles backend logic and manages business processes such as OEE calculations and data transformations.
- **Vue.js** provides an intuitive interface, allowing users to visualize and interact with real-time data.

## Future Enhancements

- **Real-time Anomaly Detection**: Integrating machine learning models to identify issues in real-time.
- **Data Pipeline Optimization**: Advanced data processing pipelines with Apache Pulsar Functions.
- **Expanded Industrial Protocol Support**: Support for additional industrial protocols such as **Modbus**, **BACnet**, and **PROFINET**.

## Contributing

Contributions to **SemantiCore** are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature.
3. Make your changes.
4. Open a pull request with a clear description of your work.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---