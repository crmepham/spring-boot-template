# spring-boot-template
A template repository consisting of a fully-functioning Spring Boot 2 application using Java 12. Use this repository as a template to skip past initial Spring Boot setup.

## What setup has been done?

### Initial user
A user with the username `admin` and password `admin` has been created. This user has the role `ROLE_ADMIN` which itself has the privileges `PRIVILEGE_WRITE` and `PRIVELEGE_READ`. Use this user to initially login to the application.

### Database setup and migration
Database configuration is defined in the `application.yml` file in the `backend` application. It initially expects the database `template`, user `template` and password `template` to have been created. Database migration is performed using `Flyway`. The migration scripts must be created in the backend application `resources/db/migration` directory.

## Technologies
1. Spring Boot 2.1.8.RELEASE
2. Java 12
3. Flyway
4. MySQL
5. Lombok 
