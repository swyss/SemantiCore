# SemantiCore

SemantiCore is an internal process optimization platform that leverages semantic technologies and Industry 4.0 ontologies to integrate data across production, logistics, and management systems. It provides advanced analytics capabilities, such as OEE (Overall Equipment Effectiveness) calculations, to enhance operational efficiency and decision-making.

## Features

- **Data Integration:**
  - Connects various data sources within the organization.
  - Utilizes Industry 4.0 ontologies and semantic technologies for flexible data models.

- **Advanced Analytics:**
  - Real-time OEE calculations.
  - Customizable KPIs and dashboards.

- **User Interface:**
  - Built with Vue.js and Vuetify for a responsive design.
  - Drag-and-drop functionality using Vue Draggable for intuitive user experience.

- **API Support:**
  - Supports OPC UA for industrial communication.
  - Provides GraphQL and RESTful APIs for data access and manipulation.

- **Security:**
  - Implements robust authentication and authorization with Spring Security.
  - Supports OAuth2 and JWT.

## Technology Stack

- **Frontend:**
  - Vue.js
  - Vuetify (Material Design Component Framework)
  - Vue Draggable (Drag-and-Drop library)
  - Axios (HTTP client)

- **Backend:**
  - Java
  - Spring Boot
  - Spring Data JPA
  - Spring Security
  - Apache Jena (Semantic Web Framework)

- **Data Integration:**
  - RDF, OWL, SPARQL (Semantic Web Technologies)
  - Industry 4.0 Ontologies
  - OPC UA (via Eclipse Milo)

- **Databases:**
  - PostgreSQL (Relational Database)
  - Neo4j (Graph Database)
  - Apache Jena Fuseki (Triple Store for RDF data)

- **APIs and Protocols:**
  - RESTful APIs
  - GraphQL
  - OPC UA

## Installation

### Prerequisites

- **Java Development Kit (JDK) 11** or higher
- **Node.js** and **npm**
- **Git**
- **IntelliJ IDEA** (Recommended IDE)

### Backend Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/semanticore.git
