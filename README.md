# SemantiCore

**SemantiCore** is an internal process optimization platform designed to integrate data across production, logistics, and management systems using semantic technologies and Industry 4.0 ontologies. It provides advanced analytics capabilities, including OEE (Overall Equipment Effectiveness) calculations, to enhance operational efficiency and decision-making. The platform leverages a modern microservices architecture and event-driven messaging to provide a scalable, real-time system.

---

## Table of Contents

1. [Features](#features)
2. [Architecture Overview](#architecture-overview)
   - [High-Level Architecture](#high-level-architecture)
3. [Technology Stack](#technology-stack)
4. [Services and Modules](#services-and-modules)
   - [Frontend (Vue.js + Vuetify)](#frontend-vuejs--vuetify)
   - [Backend (Spring Boot)](#backend-spring-boot)
   - [Apache Pulsar (Messaging Broker)](#apache-pulsar-messaging-broker)
   - [Data Integration Services](#data-integration-services)
   - [OEE Calculation Service](#oee-calculation-service)
   - [Semantic Data Service](#semantic-data-service)
   - [Database Services](#database-services)
   - [Security Service](#security-service)
   - [Monitoring Service](#monitoring-service)
5. [Data Flow](#data-flow)
6. [Extended OEE Logic](#extended-oee-logic)
7. [Monitoring Service Extensions](#monitoring-service-extensions)
8. [Additional Key Metrics Beyond OEE](#additional-key-metrics-beyond-oee)
9. [Installation](#installation)
   - [Prerequisites](#prerequisites)
   - [Backend Setup](#backend-setup)
   - [Frontend Setup](#frontend-setup)
   - [Running the Full System](#running-the-full-system)
   - [Stopping the System](#stopping-the-system)
10. [How it Works](#how-it-works)
11. [Future Enhancements](#future-enhancements)
12. [Contributing](#contributing)
13. [License](#license)

---

## Features

SemantiCore provides several key features designed to improve operational performance across various industrial domains:

- **Data Integration**:
  - **Industry 4.0 Ontologies and Semantic Technologies**: Supports flexible data models for seamless integration of diverse data sources across production, logistics, and management.
  - **OPC UA** for device communication, enabling standardized data access and industrial automation connectivity.
  - **IoT and SCADA** Integration: Collects and aggregates data from smart devices and SCADA systems, providing real-time insight into machine and process performance.

- **Event-Driven Architecture**:
  - **Apache Pulsar** as the messaging backbone, allowing real-time event streaming, decoupled communication, and scalable messaging between microservices.
  - Supports **Publish/Subscribe** and **Queue-based Messaging** for handling various workloads and scenarios.

- **Advanced Analytics**:
  - **OEE Calculations**: Provides real-time insights into machine availability, performance, and quality, aiding production optimization.
  - **Custom KPIs and Dashboards**: Users can define their own key performance indicators and view data through intuitive, interactive dashboards for real-time operational insights.

- **User Interface**:
  - Built using **Vue.js** and **Vuetify** for responsive and modern user experience.
  - **Drag-and-Drop** functionality for easy configuration and interaction using **Vue Draggable**.

- **API Support**:
  - Provides both **RESTful APIs** and **GraphQL** for flexible data access and manipulation.
  - Industrial communication supported via **OPC UA** and other protocols such as **MQTT** for IoT integration.

- **Security**:
  - Robust authentication and authorization mechanisms powered by **Spring Security**.
  - Supports industry-standard protocols such as **OAuth2** and **JWT** for secure API access and user management.

---

## Architecture Overview

SemantiCore is designed around a microservices architecture that utilizes **Apache Pulsar** for real-time messaging, event streaming, and decoupled communication between services. This architecture enables flexible scaling and enhances the overall reliability of the system.

The platform aggregates data from various sources, including **IoT devices**, **SCADA systems**, and **external APIs**, and uses this data for analysis, decision-making, and process optimization.

### High-Level Architecture

The following diagram provides a high-level overview of SemantiCore’s architecture:

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

- **Frontend**: The user interface is built with **Vue.js** and **Vuetify**, offering real-time data visualization and interaction.
- **Backend (Spring Boot)**: Handles business logic, data integration, and API management.
- **Apache Pulsar**: Event-driven messaging broker for scalable and reliable communication.
- **Databases**: **PostgreSQL** for relational data and **Neo4j** for graph data. **Apache Jena Fuseki** is used for semantic data management.

---

## Technology Stack

SemantiCore leverages modern technologies to ensure high performance, scalability, and security.

### Frontend

- **Vue.js**: Provides a dynamic and reactive user interface.
- **Vuetify**: Implements Material Design principles to ensure a modern and user-friendly design.
- **Vue Draggable**: Adds drag-and-drop functionality for custom UI interactions.
- **Axios**: Facilitates efficient communication between the frontend and backend via HTTP requests.

### Backend

- **Java 21**: Primary programming language for backend services.
- **Spring Boot**: Microservice framework for developing RESTful APIs, handling business logic, and managing data integration.
- **Spring Data JPA**: Facilitates interaction with relational databases.
- **Spring Security**: Provides robust security mechanisms, including OAuth2 and JWT-based authentication.

### Messaging & Streaming

- **Apache Pulsar**: High-performance, real-time messaging and event streaming platform that supports both **publish/subscribe** and **queue-based messaging**.
- **Pulsar Functions**: Lightweight, serverless computing framework for stream processing directly within the broker.

### Data Integration

- **Semantic Technologies**: 
  - **RDF**, **OWL**, **SPARQL**: Provide flexible and standard methods for representing, querying, and managing semantic data.
  - **Industry 4.0 Ontologies** (e.g., RAMI4.0) ensure interoperability and standardization across diverse industrial systems.
- **Apache Jena**: Framework for semantic data management and querying.
- **OPC UA**: Protocol for secure, machine-to-machine communication (via **Eclipse Milo**).

### Databases

- **PostgreSQL**: Primary relational database for structured data.
- **Neo4j**: Graph database for managing relationships and network structures in the data.
- **Apache Jena Fuseki**: Triple store for managing RDF (semantic) data and supporting SPARQL queries.
- **InfluxDB**:
---

## Services and Modules

### Frontend (Vue.js + Vuetify)

- **Purpose**: Provides an intuitive user interface for interacting with the system.
- **Responsibilities**: 
  - Real-time visualization of production data, KPIs, and OEE metrics.
  - Management of SCADA/IoT devices.
  - Configurable dashboards with drag-and-drop functionality.
  - User authentication and management.
- **Technologies**: Vue.js, Vuetify, Vue Draggable, Axios.

### Backend (Spring Boot)

- **Purpose**: Centralized business logic and data processing.
- **Responsibilities**: 
  - Manage API endpoints (REST and GraphQL).
  - Process and analyze production data (e.g., OEE calculations).
  - Provide data access and integration with external systems (e.g., OPC UA, MQTT).
  - Handle user roles and security through Spring Security.
- **Technologies**: Spring Boot, Spring Data JPA, Spring Security.

### Apache Pulsar (Messaging Broker)

- **Purpose**: Enable real-time event-driven communication between services.
- **Responsibilities**: 
  - Manage Pub/Sub messaging between microservices.
  - Ensure scalability and decoupling of services.
  - Process events through **Pulsar Functions** for lightweight, real-time stream processing.
- **Technologies**: Apache Pulsar.

### Data Integration Services

- **Purpose**: Integrate data from diverse sources such as **OPC UA**, **MQTT**, and other SCADA/IoT systems.
- **Responsibilities**: 
  - Collect and process machine data.
  - Provide real-time data access through APIs.
  - Standardize data using Industry 4.0 ontologies and semantic technologies

.
- **Technologies**: OPC UA (Eclipse Milo), MQTT, Spring Boot.

### OEE Calculation Service

- **Purpose**: Perform real-time calculations of OEE (Overall Equipment Effectiveness).
- **Responsibilities**: 
  - Calculate machine availability, performance, and quality based on production data.
  - Store OEE metrics in relational and time-series databases.
  - Provide real-time analysis and visualization.
- **Technologies**: Spring Boot, PostgreSQL, InfluxDB (for time-series data).

### Semantic Data Service

- **Purpose**: Manage and analyze semantic data for industrial processes.
- **Responsibilities**: 
  - Store and query RDF data using SPARQL.
  - Utilize ontologies like RAMI4.0 for standardization and data integration.
- **Technologies**: Apache Jena Fuseki, RDF, OWL, SPARQL.

### Database Services

- **Purpose**: Manage relational and graph-based data.
- **Responsibilities**: 
  - Store business, user, and production data.
  - Provide data for analytics, visualization, and decision-making.
  - Manage relationships and networks through **Neo4j**.
- **Technologies**: PostgreSQL, Neo4j, Apache Jena Fuseki.

### Security Service

- **Purpose**: Provide robust security mechanisms for system protection.
- **Responsibilities**: 
  - Manage user roles, permissions, and access controls.
  - Ensure secure API access with OAuth2 and JWT.
  - Encrypt sensitive data.
- **Technologies**: Spring Security, OAuth2, JWT.

### Monitoring Service

- **Purpose**: Provide real-time monitoring of system performance and states.
- **Responsibilities**: 
  - Monitor system health and production processes.
  - Provide real-time alerts and notifications in case of failures.
  - Store log data in **InfluxDB** for analysis.
- **Technologies**: InfluxDB, Grafana (for optional visualization).

---

## Data Flow

The data flow in SemantiCore is centered around **Apache Pulsar** as the message broker. This event-driven architecture ensures real-time data exchange between services while maintaining decoupling and scalability.

### Key Flow Components:
1. **Data Integration**:
   - Data from OPC UA, MQTT, and IoT devices is aggregated by the **Data Integration Service**.
   - This service sends processed data as events to **Apache Pulsar** for distribution to other services.

2. **Apache Pulsar**:
   - Publishes and distributes events to microservices subscribed to relevant data streams.
   - Ensures real-time event streaming and queuing for high-throughput processing.

3. **OEE Calculation Service**:
   - Receives real-time machine data through Pulsar and performs calculations on **availability**, **performance**, and **quality**.
   - The results are stored in **PostgreSQL** and visualized in the frontend.

4. **Frontend**:
   - Displays OEE values, KPIs, and machine statuses in real-time through the user interface.

---

## Extended OEE Logic

**OEE (Overall Equipment Effectiveness)** is a critical metric for evaluating manufacturing performance. SemantiCore calculates OEE using three key factors:

1. **Availability**: Measures the proportion of planned production time where machines are running without downtime.
2. **Performance**: Compares actual production speed to the ideal, indicating the efficiency of production processes.
3. **Quality**: Tracks defective products relative to total output, reflecting production quality.

### Extensions:
- **Time-Series Analysis**: OEE data is stored in **InfluxDB** for long-term trend analysis, enabling users to track performance over time.
- **AI Integration**: Future integration with AI for real-time anomaly detection and automated optimization suggestions.
- **Predictive Maintenance**: By analyzing OEE data, SemantiCore can integrate with maintenance systems to predict machine failures and schedule proactive maintenance.

---

## Monitoring Service Extensions

SemantiCore's monitoring system can be extended to provide deeper insights and real-time alerting for system and production process failures.

### Potential Extensions:

1. **Prometheus**: 
   - Integrated for collecting and monitoring system and application metrics.
   - Metrics visualized using **Grafana**, offering user-friendly real-time dashboards.

2. **ELK Stack**:
   - Log aggregation with **Elasticsearch**, **Logstash**, and **Kibana** for real-time log analysis.
   - Detects anomalies, analyzes logs, and provides comprehensive error reporting.

3. **Alerting**:
   - Integrates with **Prometheus Alertmanager** or similar tools for real-time notifications when thresholds (e.g., downtime, OEE deviations) are exceeded.

4. **Event-Stream Processing**:
   - Uses **Pulsar Functions** for lightweight event processing directly in the message broker, enabling quick responses to system-critical events.

---

## Additional Key Metrics Beyond OEE

While OEE is an important metric, other key performance indicators (KPIs) offer a broader view of overall production and operational efficiency:

1. **TCO (Total Cost of Ownership)**:
   - TCO evaluates the total cost of a system over its lifetime, factoring in acquisition, operating, and maintenance costs. This metric helps assess the financial feasibility of production systems.

2. **MTBF (Mean Time Between Failures)**:
   - MTBF measures the average operational time between system or machine failures, providing insights into reliability and the need for maintenance scheduling.

3. **MTTR (Mean Time to Repair)**:
   - MTTR reflects the average time required to repair a machine after a failure, highlighting the efficiency of maintenance processes and their impact on production downtime.

4. **Yield**:
   - Yield indicates the percentage of products that meet quality standards. A higher yield indicates efficient processes and fewer defects.

5. **Throughput**:
   - Throughput measures the quantity of products or materials processed within a specific timeframe. This metric reflects production efficiency and is used to evaluate process optimization.

6. **Cpk (Process Capability Index)**:
   - Cpk is a statistical measure of process capability, showing how well a process can produce items within specified limits. A higher Cpk value indicates more consistent quality.

7. **RTY (Rolled Throughput Yield)**:
   - RTY measures the likelihood that a product will pass through the entire production process without defects or rework, providing an aggregated view of process efficiency.

8. **Cycle Time**:
   - Cycle time measures the total time required to produce a unit from start to finish. Reducing cycle time increases throughput and operational efficiency.

9. **SCRAP (Ausschussquote)**:
   - SCRAP measures the percentage of defective products that must be discarded. A high SCRAP rate indicates inefficiencies in production and increased waste.

10. **Capacity Utilization**:
   - This metric reflects the percentage of available production capacity that is actually used. Low capacity utilization may indicate inefficiencies, while high utilization suggests optimized use of resources.

11. **Takt Time**:
   - Takt time is the maximum allowable time to meet production demand, aligning production pace with customer demand.

12. **Downtime**:
   - Downtime refers to periods where machines or systems are unavailable due to failure, maintenance, or other issues. Reducing downtime is essential for maximizing productivity.

13. **Energy Efficiency**:
   - Measures energy consumption relative to the number of units produced, helping companies reduce costs and improve sustainability.

14. **Lead Time**:
   - Lead time reflects the total time from receiving an order to delivering the finished product. Reducing lead time can improve customer satisfaction and competitive advantage.

---

## Installation

### Prerequisites

Before you begin, ensure the following tools are installed on your machine:

- **Docker** and **Docker Compose**
- **Java Development Kit (JDK) 21** or higher
- **Node.js** and **npm**
- **Git**
- **IntelliJ IDEA** or **VSCode**

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

1. Ensure **Docker** is running.
2. From the root directory, run the following command:

   ```bash
   docker-compose up --build
   ```

3. The following services will be started:
   - **Apache Pulsar** at `localhost:6650`.
   - **Backend (Spring Boot)** at `localhost:8080`.
   - **Frontend (Vue.js)** at `localhost`.

### Stopping the System

To stop all running services:

```bash
docker-compose down
```

---

## How it Works

SemantiCore’s architecture ensures flexibility, scalability, and real-time data exchange between services:

- **Apache Pulsar** acts as the messaging backbone, decoupling service communication and enabling scalable data processing.
- **Spring Boot** provides business logic and handles data integration and OEE calculations.
- **Vue.js** offers a modern user interface for visualizing real-time production data and interacting with the system.

---

## Future Enhancements

- **Real-time Anomaly Detection**: Integration of machine learning models for identifying operational anomalies in real time.
- **Data Pipeline Optimization**: Implementing advanced data pipelines using **Pulsar Functions

** to streamline event processing.
- **Expanded Protocol Support**: Adding support for additional industrial protocols like **Modbus**, **BACnet**, and **PROFINET** to enhance system interoperability.

---

## Contributing

Contributions to **SemantiCore** are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature.
3. Make the necessary changes.
4. Submit a pull request with a detailed description of your changes.

---

## License