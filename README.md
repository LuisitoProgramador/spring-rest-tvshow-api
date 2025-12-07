# spring-rest-tvshows-api
Este proyecto es una API RESTful para la gestión de datos de una base de datos de actores, programas de televisión (shows), agencias y biografías. Está construido con Spring Boot y sigue una arquitectura de capas clara (Controller, Service, Repository) para asegurar la escalabilidad y el mantenimiento.

Tecnologías Clave:

Spring Boot 3.x: Framework principal para la creación de la aplicación.

Spring Data JPA / Hibernate: Para la persistencia y mapeo objeto-relacional (ORM).

MySQL: Base de datos relacional utilizada (configuración en application.properties).

Lombok: Reducción de código boilerplate en modelos de datos.

Validación (Jakarta Validation): Implementación de reglas de validación de datos en las entidades.

Características Implementadas (CRUD para Actor):

Endpoints RESTful (GET, POST, PUT, PATCH, DELETE) para la entidad Actor.

Manejo de relaciones One-to-One, One-to-Many y Many-to-Many (Biography, Agency, Shows).

Uso avanzado del verbo PATCH para actualizaciones parciales de campos (ej. actualizar solo el nombre del actor).
