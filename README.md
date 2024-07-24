# Interfaz Gestopago BBVA-ALTAN Integration

## Prerequisites

- Docker
- Maven (optional if you have Docker)
- Java: 17.0.2 (optional if you have Docker)

## Run Project in production mode


#### Using docker compose

```
docker-compose up --build -d
```

#### Using only Dockerfile

```
docker build -t gestopago/interfaz-gestopago .
docker run -p 8080:8080 -t gestopago/interfaz-gestopago
```

#### Using Maven

```
mvn clean install
java -jar target/interfaz-gestopago-1.jar
```

