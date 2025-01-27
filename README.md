# TodoService - Spring Boot Application

Este proyecto es una aplicación Spring Boot que proporciona un servicio de gestión de tareas (TODO). Incluye funcionalidades como autenticación OAuth2, validación de datos, documentación de API con OpenAPI, y persistencia de datos utilizando JPA y MySQL.

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

- **Spring Boot Starter Data JPA**: Para la persistencia de datos utilizando JPA.
- **Spring Boot Starter Web**: Para construir una aplicación web con Spring MVC.
- **Spring Boot DevTools**: Para facilitar el desarrollo con recarga automática y otras herramientas.
- **MySQL Connector/J**: Para la conexión con la base de datos MySQL.
- **Lombok**: Para reducir el código boilerplate con anotaciones como `@Data`, `@Getter`, `@Setter`, etc.
- **MapStruct**: Para mapeo de objetos de manera eficiente.
- **Springdoc OpenAPI**: Para la documentación de la API utilizando OpenAPI 3.
- **Spring Boot Starter OAuth2 Client**: Para la integración con OAuth2.
- **Spring Boot Starter Security**: Para la seguridad de la aplicación.
- **Hibernate Validator**: Para la validación de datos.
- **Spring Dotenv**: Para la gestión de variables de entorno desde un archivo `.env`.

## Configuración

### Configuración de la Base de Datos

El proyecto está configurado para conectarse a una base de datos MySQL. Asegúrate de tener un servidor MySQL en funcionamiento y configura las credenciales en el archivo `application.properties` o mediante variables de entorno.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### Configuración de OAuth2
La aplicación está configurada para utilizar OAuth2 para la autenticación. Asegúrate de configurar las credenciales de tu proveedor OAuth2 en el archivo application.properties o mediante variables de entorno.

```properties
spring.security.oauth2.client.registration.my-client.client-id=your-client-id
spring.security.oauth2.client.registration.my-client.client-secret=your-client-secret
spring.security.oauth2.client.registration.my-client.scope=read,write
spring.security.oauth2.client.registration.my-client.authorization-grant-type=authorization_code
spring.security.oauth2.client.registration.my-client.redirect-uri=http://localhost:8080/login/oauth2/code/my-client
```

### Configuración de Variables de Entorno (.env)

El proyecto utiliza un archivo `.env` para gestionar las variables de entorno. Asegúrate de crear un archivo `.env` en la raíz del proyecto con el siguiente contenido:

```env
DATABASE_URL=jdbc:mysql://localhost:3306/todo?createDatabaseIfNotExist=false&userSSL=false&serverTimezone=UTC
DATABASE_USERNAME=usuario-base-datos
DATABASE_PASSWORD=contraseña-base-datos
GOOGLE_CLIENT_ID=tu-google-client-id
GOOGLE_CLIENT_SECRET=tu-google-client-secret
```

### Configuración de OpenAPI
La documentación de la API está disponible en /v3/api-docs y la interfaz de usuario de Swagger en /swagger-ui.html.
- /todo/api/swagger-ui/index.html

### Compilación y Ejecución
Requisitos Previos
- Java 21
- Maven 3.x
- MySQL

### Compilación
Para compilar el proyecto, ejecuta el siguiente comando en la raíz del proyecto:

```cmd
mvn clean install
```
### Ejecución
Para ejecutar la aplicación, utiliza el siguiente comando:

```cmd
mvn spring-boot:run
```
La aplicación estará disponible en http://localhost:8082.


### Notas:
1. Asegúrate de que el archivo `.env` esté en la raíz del proyecto y que no se incluya en el control de versiones (por ejemplo, añádelo a `.gitignore`).
2. Las variables `GOOGLE_CLIENT_ID` y `GOOGLE_CLIENT_SECRET` deben ser configuradas con los valores proporcionados por Google al registrar tu aplicación en su consola de desarrolladores.

¡Espero que esto sea útil! Si necesitas más ajustes, no dudes en pedírmelo. 😊