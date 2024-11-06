# Spaceships API

## Descripción
Spaceships API es una aplicación RESTful desarrollada con Spring Boot que proporciona servicios relacionados con naves espaciales. La aplicación incluye autenticación básica y está configurada para ejecutarse en un contenedor Docker.

## Requisitos
- Java 21
- Maven
- Docker

## Instalación

1. Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    cd <NOMBRE_DEL_REPOSITORIO>
    ```

2. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Ejecución

### Localmente

1. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```

2. La aplicación estará disponible en `http://localhost:8080`.

### Con Docker

1. Construye la imagen Docker:
    ```sh
    docker build -t spaceships-api .
    ```

2. Ejecuta el contenedor:
    ```sh
    docker run -p 8080:8080 spaceships-api
    ```

3. La aplicación estará disponible en `http://localhost:8080`.

## Seguridad
La aplicación utiliza Spring Security para la autenticación básica. Las credenciales por defecto son:
- Usuario: `user`
- Contraseña: `password`

## Dependencias Principales
- Spring Boot Starter Web
- Spring Boot Starter Security
- Swagger Annotations
- Jakarta Validation API
- Lombok
- Mockito JUnit Jupiter
- MapStruct