# DSVendas

## About

DSVendas is a sales dashboard. It was made in Semana Spring React powered by Devsuperior

## Deploy
You can check the deploy on:
  * [Frontend](https://dsvendas-t-guerrero.netlify.app/)
  * [Backend](https://dsvendas-t-guerrero.herokuapp.com/)

## Technologies
It was used:
  * React.js
  * Spring Boot
  * H2 database 
  * PostgreSQL
  * Docker
  * Heroku
  * Netlify

## Running
To build and up the postgreSQL container on `:3333` and Spring Boot container on `localhost:8080`:
```bash
# Root directory
$> docker-compose up --build
```
To run the frontend project on `localhost:3000`:
```bash
# /frontend/
$> yarn install
$> yarn start
```

## Backend Structure

### Conceptual Model

![uml_image](https://github.com/T-Guerrero/dsvendas/blob/main/docs/uml.png?raw=true)

### Backend Architecture

![architecture_image](https://github.com/T-Guerrero/dsvendas/blob/main/docs/architecture.png?raw=true)
