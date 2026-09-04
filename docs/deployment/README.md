# Deployment de la solución

Este documento describe de forma general la arquitectura de despliegue propuesta para la academia de idiomas.

## Componentes principales

La solución contempla los siguientes componentes:

- Aplicación backend desarrollada con Spring Boot.
- Servicio REST para la creación de alumnos.
- Servicio GraphQL para la consulta de alumnos mediante diferentes filtros.
- Base de datos PostgreSQL compartida por REST y GraphQL.
- Despliegue público de la aplicación y la base de datos mediante Railway.

## Comunicación entre componentes

El servicio REST permite registrar nuevos alumnos mediante:

POST /api/v1/alumnos

GraphQL permite consultar la información de los alumnos mediante:

/graphql

También se encuentra disponible la interfaz GraphiQL para realizar consultas:

/graphiql

Ambos servicios utilizan la misma base de datos PostgreSQL.

## Infraestructura

La aplicación Spring Boot y PostgreSQL se encuentran desplegados en Railway.

El backend se encuentra expuesto mediante HTTPS y se comunica con PostgreSQL utilizando variables de entorno para sus parámetros de conexión.

## Relación general

Cliente  
↓  
Spring Boot  
├── REST  
└── GraphQL  
↓  
PostgreSQL