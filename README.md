# ReadersNotes
## Application description
This is a basic notes app with JWT and Swagger for the book lover.

## Dependencies
The application uses:

    1) Spring Boot;

    2) Spring Security;

    3) Spring Data JPA;

    4) Spring MVC;

    5) Spring Validation;

    6) Project Lambok;

    7) Swagger
    
    8) Postgresql;
    
    9) JWT stack 

## How to test this application
To run this application you need to be running Docker. 

`docker compose up`

You can use Swagger to test this application. Baseurl - `http://localhost:8080/swagger-ui/index.html`

To run the application, use the Spring Boot Maven plugin:

`mvn Spring-boot:run`