# 🚀 Proyecto API CRUD Gestion de tareas Java+SQl server+ Spring



## 📌 Descripción 

Este proyecto es una aplicación desarrollada en **Java / Spring Boot** que implementa un API Rest para la gestion de tareas.  
El objetivo es demostrar buenas prácticas de desarrollo, arquitectura sencilla y escalable, y uso de herramientas modernas de programación.
## Caracteristicas
- Integracion con base de datos para persistencia de datos
- Capacidad de gestionar tareas mediante operaciones CRUD
- Arquitectura basada en capas
## 🛠️ Tecnologías utilizadas

- **Java 17+**
- **Spring Boot**
- **Maven / Gradle**
- **SQL Server** 



## ⚙️ Instalación y ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/repositorio.git
   cd repositorio
   ```
   2. Configurar variables de entorno en application.properties
```bash
  spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring
    username: root
    password: password
  jpa:
    hibernate:
      ddl-auto: update

 ```
3. Compilar y ejecutar con maven
```bash
   mvn clean install
   mvn spring-boot:run

 ```
## Uso 
### ✅ Tareas
**Url principal**
`api/tareas`
- **Listar todas las tareas**  
  `GET /listarTareas`

- **Obtener detalle de una tarea por ID**  
  `GET /listarTarea/{id}`

- **Crear nueva tarea**  
  `POST /guardarTarea`  
  **Body (JSON ejemplo):**
  ```json
  {
    "title": "Estudiar Spring",
    "description": "Repasar controladores y servicios",
    "status": "PENDIENTE",
    "due_date": "2025-09-20",
    "active": true
  }
    ```
- **Actualizar tarea (totalmente)**  
  `PUT /actualizacionTotal/{id}`
  **Body (JSON ejemplo):**
 ```json
  {
  "title": "Estudiar Spring Boot",
  "description": "Completar CRUD con validaciones",
  "status": "EN_PROGRESO",
  "due_date": "2025-09-22",
  "active": true
  }
  ```
- **Actualizar tarea (parcialmente)**  
  `Patch /actualizacionParcial/{id}`
  **Body (JSON ejemplo):**
 ```json
  {
  "status": "EN_PROGRESO",
  "due_date": "2025-09-22",
  "active": true
  }
  ```
- **Eliminar tarea( eliminacion logica)**  
  `Delete /eliminarTarea/{id}`
## Estructura 
📦 src
┣ 📂 main
┃ ┣ 📂 java/com/usuario/proyecto
┃ ┃ ┣ 📂 Controllers # Controladores REST (endpoints)
┃ ┃ ┣ 📂 Services # Lógica de negocio
┃ ┃ ┣ 📂 Repository # Repositorios de datos (Spring Data JPA)
┃ ┃ ┣ 📂 Entity # Entidades del modelo (JPA/Hibernate)
┃ ┃ ┣ 📂 Dto # Objetos de transferencia de datos (validaciones)
┃ ┃ ┗ 📂 Exception # Excepciones personalizadas y manejadores de errores

┣ 📂 test
┃ ┗ 📂 java/com/usuario/proyecto # Tests unitarios y de integración
## Autor
### Jorge Estuardo Rustrian del pinal



