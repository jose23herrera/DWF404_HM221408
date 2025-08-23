# Spring Database Hibernate (Guía 5 DWF)

Proyecto completo basado en la guía con:
- Spring Boot 3.3.8, Java 17
- Hibernate + SessionFactory
- H2 como base en memoria (por defecto)
- Entidades: `Post`, `PostComment`
- Repositorios: `PostRepository`, `PostCommentRepository`
- Métodos con **JPA Criteria API**
- Tests de repositorios

## Cómo ejecutar
```bash
./mvnw spring-boot:run
# o
mvn clean package
java -jar target/spring-database-hibernate-0.0.1-SNAPSHOT.jar
```

## Cambiar de H2 a MySQL
1. Agregar en `pom.xml` (si usas MySQL):
   ```xml
   <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-j</artifactId>
     <scope>runtime</scope>
   </dependency>
   ```
2. Cambiar `src/main/resources/application.properties`:
   ```properties
   db.driver=com.mysql.cj.jdbc.Driver
   db.url=jdbc:mysql://localhost:3306/springdb?useSSL=false&serverTimezone=UTC
   db.username=root
   db.password=tu_password
   config.hibernate.hbm2ddl.auto=update
   config.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

> Nota: El proyecto usa **Criteria API moderna** (JPA) compatible con Hibernate 6.

## Pruebas
Ejecuta:
```bash
mvn -q -Dtest=*RepositoryTest test
```
