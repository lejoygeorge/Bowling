# Bowling Scoring API

A Spring Boot REST API for calculating American Ten-Pin Bowling scores.

## 🛠️ Tech Stack

This project is built using modern Java and Spring Ecosystem tools:

* **Java Version:** 21
* **Framework:** Spring Boot 3.5.15
* **Build Tool:** Maven
* **Boilerplate Reduction:** Lombok
* **Encoding:** UTF-8

---

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed on your local machine:
* [Java Development Kit (JDK) 21](https://adoptium.net/)
* [Apache Maven](https://maven.apache.org/download.cgi) (or use the provided Maven wrapper if included in your repo)

### 📝 Development Guidelines & Encoding

To prevent cross-platform character issues, this project strictly uses **UTF-8** encoding.
If you are contributing to this project, please ensure your IDE (IntelliJ, Eclipse, VS Code) is configured to:
* Use `UTF-8` for all Global, Project, and Default encoding settings.
* Use `UTF-8` for the JVM standard output/error (e.g., `-Dfile.encoding=UTF-8`).
* Use `LF` (Line Feed) for line separators.


### Building the Project

To compile the code, process Lombok annotations, and build the runnable JAR:

```bash
mvn clean install

```

### Running the Application

You can start the Spring Boot server using the Spring Boot Maven plugin:

```bash
mvn spring-boot:run

```

By default, the application will start on `http://localhost:8080`.

---

## 🚦 Running Tests

### Standard Unit Tests

To execute the JUnit 5 test suite:

```bash
mvn clean test

```
---
