# Beyond Footsteps — GraphQL API (Server)

<p align="center">
  <img src="beyondfootsteps_transparent_logo.svg" alt="Beyond Footsteps" width="220" />
</p>

<p align="center">
  <a href="https://github.com/ezepsosa/beyondfootsteps-client/blob/main/LICENSE">
    <img alt="License" src="https://img.shields.io/badge/license-MIT-blue.svg" />
  </a>
  <a href="https://www.oracle.com/java/">
    <img alt="Java" src="https://img.shields.io/badge/Java-17%2B-brightgreen?logo=java" />
  </a>
  <a href="https://spring.io/">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-2.7+-green" />
  </a>
  <a href="https://www.graphql-java.com/">
    <img alt="GraphQL" src="https://img.shields.io/badge/GraphQL-API-critical" />
  </a>
  <a href="https://www.docker.com/">
    <img alt="Docker" src="https://img.shields.io/badge/docker-ready-blue" />
  </a>
  <a href="https://www.postgresql.org/">
    <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-Database-blue" />
  </a>
</p>

This Spring Boot GraphQL API powers the Beyond Footsteps project by exposing migration and refugee indicators (derived from UNHCR data) via a strongly-typed schema. It is built using resolvers, services, repositories, DTOs, and mappers and is intended for educational and portfolio purposes only.  
**Note**: This project is not affiliated with UNHCR.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [GraphQL API](#graphql-api)
- [Configuration](#configuration)
- [Build & Run](#build--run)
- [Docker](#docker)
- [Testing](#testing)
- [CORS & Error Handling](#cors--error-handling)
- [Related Repositories](#related-repositories)
- [License](#license)

---

## Overview

- **Purpose:** Expose migration and refugee indicators through a GraphQL API.
- **Data Sources:** Uses UNHCR-derived data to power various indicators on asylum decisions, requests, resettlement summaries, IDP displacements, refugee returnees, and naturalizations.
- **Design:** The API uses a layered architecture that separates concerns among resolvers (GraphQL endpoints), services (business logic), repositories (data access), models (JPA entities), and mappers for DTO mapping.

---

## Tech Stack

- **Programming Language:** Java (version 17+)
- **Frameworks/Libraries:**  
  - Spring Boot  
  - Spring Data JPA  
  - Spring for GraphQL  
  - JUnit 5, Mockito  
- **Database:** PostgreSQL (production) with H2 for testing  
- **Build Tool:** Maven
- **Containerization:** Docker & Docker Compose

---

## Architecture

```mermaid
flowchart LR
    A[UNHCR Data Source] -->|ETL| B[(Database)]
    B --> C[GraphQL API<br/>(Resolvers, Services, Repositories)]
    C --> D[Frontend Client<br/>(React, Maps, Dashboards)]
```

*The API layer abstracts data retrieval and aggregation (e.g., grouping by country and year) to support the visualization of migration and refugee trends.*

---

## Project Structure

```
src/
├─ main/
│  ├─ java/com/beyondfootsteps/beyondfootsteps/
│  │  ├─ BeyondfootstepsApplication.java             # Application entry-point
│  │  ├─ configuration/
│  │  │  └─ CorsConfig.java                           # CORS configuration
│  │  ├─ dto/
│  │  │  ├─ internal/                                # Internal DTOs (e.g., for grouped responses)
│  │  │  └─ response/                                # API response DTOs
│  │  ├─ exceptions/
│  │  │  ├─ CustomExceptionHandler.java              # Global exception handler (@ControllerAdvice)
│  │  │  └─ InvalidParamException.java               # Custom exception for invalid parameters
│  │  ├─ mappers/
│  │  │  └─ ResettlementSummaryOriginGroupedMapper.java  # Mapper for entity-to-DTO conversion
│  │  ├─ models/                                     # JPA entity
│  │  │  ├─ AsylumDecision.java
│  │  │  ├─ AsylumRequest.java
│  │  │  ├─ DashboardSummary.java
│  │  │  ├─ IdpDisplacement.java
│  │  │  ├─ IdpReturnees.java
│  │  │  ├─ RefugeeNaturalization.java
│  │  │  └─ ResettlementSummary.java
│  │  ├─ repositories/                               # Spring Data JPA repositories
│  │  │  ├─ AsylumDecisionRepository.java
│  │  │  ├─ AsylumRequestRepository.java
│  │  │  ├─ DashboardSummaryRepository.java
│  │  │  ├─ IdpDisplacementRepository.java
│  │  │  ├─ IdpReturneesRepository.java
│  │  │  ├─ RefugeeNaturalizationRepository.java
│  │  │  └─ ResettlementSummaryRepository.java
│  │  ├─ resolvers/                                  # GraphQL resolvers
│  │  │  ├─ AsylumDecisionResolver.java
│  │  │  ├─ AsylumRequestResolver.java
│  │  │  ├─ DashboardSummaryResolver.java
│  │  │  ├─ IdpDisplacementResolver.java
│  │  │  ├─ IdpReturneesResolver.java
│  │  │  ├─ RefugeeNaturalizationResolver.java
│  │  │  └─ ResettlementSummaryResolver.java
│  │  └─ services/                                  # Business logic (Services)
│  │     ├─ AsylumDecisionService.java
│  │     ├─ AsylumRequestService.java
│  │     ├─ DashboardSummaryService.java
│  │     ├─ IdpDisplacementService.java
│  │     ├─ IdpReturneesService.java
│  │     ├─ RefugeeNaturalizationService.java
│  │     └─ ResettlementSummaryService.java
│  └─ resources/
│     ├─ application.properties                     # General application configuration
│     ├─ graphql/
│     │  └─ schema.graphqls                         # GraphQL schema definition
│     ├─ static/
│     └─ templates/
└─ test/
   ├─ java/com/beyondfootsteps/beyondfootsteps/
   │  ├─ BeyondfootstepsApplicationTests.java         # Spring Boot context test
   │  ├─ mapper/
   │  │  └─ ResettlementSummaryOriginGroupedMapperTest.java
   │  ├─ repository/                                  # Repository tests with H2
   │  │  ├─ AsylumDecisionRepositoryTest.java
   │  │  ├─ AsylumRequestRepositoryTest.java
   │  │  ├─ DashboardSummaryRepositoryTest.java
   │  │  ├─ RefugeeNaturalizationRepositoryTest.java
   │  │  └─ ResettlementSummaryRepositoryTest.java
   │  ├─ resolvers/                                   # GraphQL resolver tests
   │  │  ├─ AsylumDecisionResolverTest.java
   │  │  ├─ AsylumRequestResolverTest.java
   │  │  ├─ DashboardSummaryResolverTest.java
   │  │  ├─ IdpDisplacementResolverTest.java
   │  │  ├─ IdpReturneesResolverTest.java
   │  │  ├─ RefugeeNaturalizationResolverTest.java
   │  │  └─ ResettlementSummaryResolverTest.java
   │  └─ services/                                    # Service layer tests; business logic validation
   │     ├─ AsylumDecisionServiceTest.java
   │     ├─ AsylumRequestServiceTest.java
   │     ├─ DashboardSummaryServiceTest.java
   │     ├─ IdpDisplacementServiceTest.java
   │     ├─ IdpReturneesServiceTest.java
   │     ├─ RefugeeNaturalizationServiceTest.java
   │     └─ ResettlementSummaryServiceTest.java
```

---

## GraphQL API

- **Endpoint:** `/graphql` (HTTP POST)
- **Schema:** Located in `src/main/resources/graphql/schema.graphqls`
- **GraphiQL:** Optionally available if enabled (e.g., at `/graphiql`)

### Sample Query: Asylum Decisions by Year and Country

```graphql
query GetAsylumDecisionsByYearAndCountry(
  $year: Int!
  $countryOfOriginIso: String
  $countryOfAsylumIso: String
) {
  asylumDecisionsByYearAndCountry(
    year: $year
    countryOfOriginIso: $countryOfOriginIso
    countryOfAsylumIso: $countryOfAsylumIso
  ) {
    id
    year
    countryOfOrigin
    countryOfOriginIso
    countryOfAsylum
    countryOfAsylumIso
    decRecognized
    decOther
    decRejected
    decClosed
    decTotal
    acceptanceRate
    decPc
  }
}
```

### Sample Query: Resettlement Summaries Grouped by Origin

```graphql
query getResettlementSummariesByYearGroupedBy($year: Int!, $grouping: String!) {
  resettlementSummariesByYearGroupedBy(year: $year, grouping: $grouping) {
    countriesIso
    countriesNames
    totalCases
    totalDepartures
    totalPersons
    totalNeeds
    totalSubmissions
    coverageRate
    resettlementGap
    requestVsNeedsRatio
    submissionsEfficiency
    realizationRate
  }
}
```

---

## Configuration

### Application Properties

- **General Config:** Located in `src/main/resources/application.properties`
- **Test Config:** Use `src/test/resources/application-test.properties` (for example, set `spring.jpa.hibernate.ddl-auto=create` to auto-generate database schema in H2)

### Reserved Column Escaping

If a column name conflicts with reserved keywords (e.g., `year`), escape it in your entities:

```java
@Column(name = "\"year\"")
private Integer year;
```

This ensures compatibility with both H2 (for tests) and PostgreSQL.

---

## Build & Run

### Using Maven on Windows

- **Run in Development Mode:**

  ```bat
  .\mvnw.cmd spring-boot:run
  ```

- **Package the Application:**

  ```bat
  .\mvnw.cmd package
  java -jar target\beyondfootsteps-<version>.jar
  ```
---

## Docker

The project includes a Dockerfile to containerize the application.

### Dockerfile Key Points

- **Test Execution:**  
  It is recommended to remove the `-DskipTests` parameter so that tests run during the image build.
  
- **Building with Docker:**

  ```dockerfile
  RUN --mount=type=bind,source=pom.xml,target=pom.xml \
      --mount=type=cache,target=/root/.m2 \
      ./mvnw package && \
      mv target/$(./mvnw help:evaluate -Dexpression=project.artifactId -q -DforceStdout)-$(./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout).jar target/app.jar
  ```

### Running with Docker Compose

```bat
docker compose up --build
```

---

## Testing

The project includes a comprehensive suite of tests across different layers:

1. **Service Tests:** Validate business logic (e.g., `AsylumDecisionServiceTest.java`, `ResettlementSummaryServiceTest.java`).
2. **Resolver Tests:** Test GraphQL endpoint integration (e.g., `RefugeeNaturalizationResolverTest.java`, `ResettlementSummaryResolverTest.java`).
3. **Repository Tests:** Use H2 with `@DataJpaTest` to verify repository queries, including handling of null parameters.  
   Example: `AsylumDecisionRepositoryTest.java` ensures queries correctly return results when filter parameters are null.
4. **Mapper Tests:** Ensure entities are correctly mapped to response DTOs (e.g., `ResettlementSummaryOriginGroupedMapperTest.java`).
5. **Application Context Tests:** Check that the Spring Boot context loads without issues (e.g., `BeyondfootstepsApplicationTests.java`).

Run all tests with:

```bat
.\mvnw.cmd test
```

---

## CORS & Error Handling

- **CORS:** Configured via `configuration/CorsConfig.java`. Adjust allowed origins, methods, and headers as needed.
- **Global Error Handling:** Implemented in `exceptions/CustomExceptionHandler.java`, ensuring smooth error responses for GraphQL and REST endpoints.

---

## Related Repositories

- **Frontend Client:** [beyondfootsteps-client](https://github.com/ezepsosa/beyondfootsteps-client)
- **ETL Pipeline:** [beyondfootsteps-etl](https://github.com/ezepsosa/beyondfootsteps-etl)

---

## License

MIT License – see the [LICENSE](LICENSE) file for details.

---

This README covers the critical aspects of the project – from architecture and development configuration to testing and deployment using Docker. Enjoy exploring and extending the project!
