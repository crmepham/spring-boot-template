# spring-boot-template
A template repository consisting of a fully-functioning Spring Boot 2 application using Java 12. Use this repository as a template to skip past initial Spring Boot setup.

## What setup has been done?

### Initial user
A user with the username `admin` and password `admin` has been created. This user has the role `ROLE_ADMIN` which itself has the privileges `PRIVILEGE_WRITE` and `PRIVELEGE_READ`. Use this user to initially login to the application.

### Database setup and migration
Database configuration is defined in the `application.yml` file in the `backend` application. It initially expects the database `template`, user `template` and password `template` to have been created. Database migration is performed using `Flyway`. The migration scripts must be created in the backend application `resources/db/migration` directory.

### SASS Maven plugin
Create your `.scss` files under directory `resources/sass`. When you next package the project the SASS files will be converted to `CSS` and placed in the `resources/static/sass` directory. The Resource Bundler maven plugin will then take care of minifying and bundling these converted CSS files. You can configure the source and target directories by changing the relevant configuration property values in the frontend `pom.xml`.

### Resource Bundler Maven plugin
This plugin automatically minifies and bundles any `Javascript` and `CSS` files it finds under the `resources/static` directory. Learn more about it here: https://github.com/crmepham/resource-bundler-maven-plugin.

## Technologies
1. Spring Boot 2.1.8.RELEASE
2. Java 12
3. Flyway
4. MySQL
5. Lombok
6. SASS
7. Freemarker
8. Checkstyle
9. Spotbugs
10. PMD

## Getting started
1. Create the database `template`.
2. Create the database user `template` with password `template`.
3. Run up the backend service.
4. Run up the frontend service.
5. Navigate to `http://localhost:3333`.
6. Login with username `admin` and password `admin`.
