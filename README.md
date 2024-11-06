# Spaceships API

## Descripción

Spaceships API es una aplicación RESTful desarrollada con Spring Boot que proporciona servicios relacionados con naves
espaciales. La aplicación incluye autenticación básica y está configurada para ejecutarse en un contenedor Docker.

## Prerrequisitos

Asegúrate de tener instaladas las siguientes herramientas:

- [Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://docs.docker.com/get-docker/)

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

3. Generar los contenedores para Kafka y Zookeeper:
    ```sh
    docker-compose -f docker-compose.yml up -d
    ```
   Esto lo que hará es levantar un contenedor con Kafka y otro con Zookeeper, de forma que la aplicación pueda
   conectarse a ellos y enviar mensajes a un tópico de Kafka.

## Ejecución

### Con Docker

1. Construye la imagen Docker:
    ```sh
    docker build -t spaceships-api boot/
    ```

2. Ejecuta el contenedor:
    ```sh
    docker run -p 8080:8080 spaceships-api
    ```

3. La aplicación estará disponible en `http://localhost:8080`.

3. La UI de Swagger estará disponible en `http://localhost:8080/swagger-ui/index.html`.

## Seguridad

La aplicación utiliza Spring Security para la autenticación básica. Las credenciales por defecto son:

- Usuario: `user`
- Contraseña: `password`

## Endpoints

### Naves Espaciales

- **POST /spaceship**: Crea una nueva nave espacial.
- **PUT /spaceship/{id}**: Actualiza los detalles de una nave espacial específica por ID.
- **GET /spaceship/{id}**: Obtiene los detalles de una nave espacial específica por ID.
- **DELETE /spaceship/{id}**: Elimina una nave espacial específica por ID.
- **GET /spaceship**: Obtiene una lista de todas las naves espaciales.
- **GET /spaceship/search**: Busca naves espaciales por nombre.