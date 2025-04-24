# Prueba Técnica INDITEX - Plataforma de Precios

Este proyecto es una API REST desarrollada en Java con Spring Boot, cuyo objetivo es proporcionar el precio aplicable de un producto de una marca en una fecha determinada.

---

## ARQUITECTURA

Este proyecto sigue una **arquitectura hexagonal (Ports & Adapters)** con enfoque **DDD (Domain-Driven Design)**.

### Capas principales:
- **Domain**: Entidades, lógica de negocio, modelos.
- **Application / Service**: Reglas de negocio y coordinación.
- **Infrastructure**: Persistencia JPA, configuración, controladores.
- **API**: Exposición del endpoint REST.

---

## TECNOLOGIAS UTILIZADAS

- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- H2 In-Memory Database
- JUnit 5 + Mockito
- MockMvc (`@SpringBootTest`)
- JaCoCo (cobertura de código)
- Maven
- GitHub Actions (CI/CD)

---

## COMO EJECUTAR EL PROYECTO

### Clonar el repositorio
git clone https://github.com/danielrodrizlopez/inditex-prices.git
cd inditex-prices

### Ejecutar la aplicación
mvn spring-boot:run

La API quedará disponible en:
http://localhost:8080/prices

---

## COMO PROBAR
Puedes usar herramientas como Postman.

Endpoint:
GET /prices?productId=35455&brandId=1&date=2020-06-14T10:00:00

---

## TESTS INCLUIDOS

- 5 pruebas de integración basadas en los casos solicitados
- Tests unitarios del servicio
- Prueba de integración PriceControllerIT.java
- Cobertura con JaCoCo

Para ejecutar tests y cobertura JaCoCo:
mvn clean verify

Cobertura accesible en:
target/site/jacoco/index.html


---



Desarrollado por Daniel Rodriguez como parte del proceso de selección para INDITEX - BCNC Group.
