## Enlaces de interes BBDD
* [.sql Script](https://drive.google.com/file/d/1FpEuSih1obeGnr7ipwpe44a6U-YKbaDs/view?usp=sharing)
* [.png Diagrama Entidad Relacion](bbdd/DER-bbdd.png)

## Proyecto Integrador Argentina Programa (Backend)
Esta es la seccion "back-end" del proyecto integrador que he creado utilizando el framework Spring Boot. Se trata de un portfolio personal que presenta mi trabajo, educacion, experiencia y habilidades en el campo de la programación

Nuestra aplicación de SpringBoot es un backend que ofrece una API RESTful para la gestión de perfiles. La aplicación utiliza Spring Web y Spring Data JPA para la implementación de los endpoints y la persistencia de datos en una base de datos MySQL.

Los usuarios pueden realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los ejemplos, utilizando los endpoints definidos en la API RESTful. Cada ejemplo tiene un identificador único, un título y una descripción.

# Requisitos previos
Java 11
Maven

## Configuración
Clona el repositorio.
Ejecuta mvn clean install en la raíz del proyecto.
Ejecuta mvn spring-boot:run para iniciar la aplicación.

## Endpoints

| Metodo HTTP | Ruta | Descripción |
| -------- | ----------------- | ---------- |
| GET | /backendap/{entidad}/lista       | Retorna la lista de entidades |
| GET | /backendap/{entidad}/detail/{id}       | Retorna la entidad especifica |
| POST | /backendap/{entidad}/create     | Crea una nueva entidad  |
| PUT | /backendap/{entidad}/update/{id}   | Actualiza una entidad existente|
| DELETE | /backendap/{entidad}/delete/{id}   | Elimina una entidad existente |

los endpoints delete y create excluyen a la entidad Persona.

## Configuración de la base de datos
La aplicación utiliza una base de datos MySQL. Puedes cambiar la configuración de la base de datos en el archivo application.properties.

## Dependencias utilizadas (mas importantes)
Spring Web
Spring Data JPA
MySQL Driver

## Contribución
Si deseas contribuir a la aplicación, por favor sigue los siguientes pasos:

* Crea un fork del repositorio.
* Crea una rama para tu nueva función o mejora.
* Envía un Pull Request.

## Licencia
Esta aplicación está bajo la Licencia MIT. Consulta el archivo LICENSE para más información.

## Contacto
Si tienes preguntas o comentarios sobre la aplicación, por favor contáctame a través de mi correo electrónico: nicolaskoch777@gmail.com
