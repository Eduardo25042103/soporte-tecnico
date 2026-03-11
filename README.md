# API de Soporte Técnico

Sistema RESTful desarrollado con **Spring Boot 4** para la gestión de solicitudes de soporte técnico, clientes y técnicos. Permite registrar, consultar, actualizar y eliminar entidades mediante endpoints HTTP con documentación integrada vía Swagger/OpenAPI.

---

## Requisitos previos

| Herramienta | Versión mínima | Verificación |
|-------------|----------------|--------------|
| Java JDK    | 21             | `java -version` |
| Maven       | 3.9+           | `mvn -version` |
| Git         | Cualquiera     | `git --version` |

---

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/Eduardo25042103/soporte-tecnico
cd soporte-tecnico
```

### 2. Compilar el proyecto

```bash
./mvnw clean install
```


### 3. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```


La aplicación iniciará en: **http://localhost:8080**

---

## Documentación Swagger / OpenAPI

Una vez iniciada la aplicación, acceder a:

| Interfaz      | URL |
|---------------|-----|
| Swagger UI    | http://localhost:8080/swagger-ui/index.html |
| OpenAPI JSON  | http://localhost:8080/v3/api-docs |

---

## Endpoints disponibles

### Clientes — `/v1/clientes`

| Método | Endpoint             | Descripción                     |
|--------|----------------------|---------------------------------|
| GET    | `/v1/clientes`       | Listar todos los clientes       |
| GET    | `/v1/clientes/{id}`  | Obtener cliente por ID          |
| POST   | `/v1/clientes`       | Crear un nuevo cliente          |
| PUT    | `/v1/clientes/{id}`  | Actualizar cliente existente    |
| DELETE | `/v1/clientes/{id}`  | Eliminar un cliente             |

**Ejemplo — Crear cliente (POST):**
```json
{
  "nombre": "Ana",
  "apellido": "García",
  "correo": "ana.garcia@empresa.com",
  "telefono": "987654321",
  "empresa": "TechCorp S.A."
}
```

---

###  Técnicos — `/tecnicos`

| Método | Endpoint                   | Descripción                        |
|--------|----------------------------|------------------------------------|
| GET    | `/tecnicos`                | Listar todos los técnicos          |
| GET    | `/tecnicos/{id}`           | Obtener técnico por ID             |
| GET    | `/tecnicos/disponibles`    | Listar técnicos disponibles        |
| POST   | `/tecnicos`                | Registrar nuevo técnico            |
| PUT    | `/tecnicos/{id}`           | Actualizar datos de técnico        |
| DELETE | `/tecnicos/{id}`           | Eliminar técnico                   |

**Ejemplo — Crear técnico (POST):**
```json
{
  "nombre": "Carlos",
  "apellido": "López",
  "correo": "carlos.lopez@soporte.com",
  "especialidad": "Redes y Conectividad",
  "disponible": true
}
```

---

###  Solicitudes — `/v1/solicitudes`

| Método | Endpoint                               | Descripción                              |
|--------|----------------------------------------|------------------------------------------|
| GET    | `/v1/solicitudes`                      | Listar todas las solicitudes             |
| GET    | `/v1/solicitudes/{id}`                 | Obtener solicitud por ID                 |
| GET    | `/v1/solicitudes/cliente/{clienteId}`  | Solicitudes por cliente                  |
| GET    | `/v1/solicitudes/estado/{estado}`      | Solicitudes filtradas por estado         |
| POST   | `/v1/solicitudes`                      | Crear nueva solicitud                    |
| PUT    | `/v1/solicitudes/{id}`                 | Actualizar solicitud                     |
| PATCH  | `/v1/solicitudes/{id}/estado`          | Cambiar estado de solicitud              |
| DELETE | `/v1/solicitudes/{id}`                 | Eliminar solicitud                       |

**Estados válidos:** `PENDIENTE` | `EN_PROCESO` | `RESUELTA` | `CANCELADA`

**Prioridades válidas:** `ALTA` | `MEDIA` | `BAJA`

**Ejemplo — Crear solicitud (POST):**
```json
{
  "titulo": "Fallo en conexión VPN",
  "descripcion": "El usuario no puede conectarse a la VPN corporativa desde casa.",
  "prioridad": "ALTA",
  "estado": "PENDIENTE",
  "clienteId": 1,
  "tecnicoId": 1
}
```

**Ejemplo — Cambiar estado (PATCH):**
```
PATCH /v1/solicitudes/1/estado?nuevoEstado=EN_PROCESO
```

---

## Manejo de errores

La API responde con un objeto de error estructurado ante validaciones fallidas (HTTP 400):

```json
{
  "fechaHora": "2025-06-10T14:30:00",
  "status": 400,
  "error": "Operación fallida",
  "mensaje": "nombre: El nombre no puede estar vacio",
  "ruta": "uri=/v1/clientes"
}
```

---

##  Estructura del proyecto

```
soporte-tecnico/
├── src/main/java/com/soporte/
│   ├── config/          # Configuración Swagger/OpenAPI
│   ├── controller/      # Controladores REST (ClienteController, TecnicoController, SolicitudController)
│   ├── dto/             # Data Transfer Objects (ClienteDto, TecnicoDto, SolicitudDto)
│   ├── exception/       # Manejo global de excepciones
│   ├── model/           # Entidades del dominio (Cliente, Tecnico, Solicitud, EstadoSolicitud)
│   ├── repository/      # Repositorios en memoria (HashMap)
│   └── service/         # Interfaces e implementaciones de lógica de negocio
├── pom.xml              # Configuración Maven y dependencias
└── README.md
```

---

##  Repositorio

[https://github.com/Eduardo25042103/soporte-tecnico](https://github.com/Eduardo25042103/soporte-tecnico)

---

##  Equipo de desarrollo — Grupo 08

---

##  Dependencias principales

| Dependencia | Versión | Propósito |
|-------------|---------|-----------|
| Spring Boot Starter Web MVC | 4.0.3 | Framework web REST |
| Spring Boot Starter Validation | 4.0.3 | Validación de entidades con Jakarta |
| SpringDoc OpenAPI (Swagger) | 2.6.0 | Documentación interactiva de la API |
| Spring Boot DevTools | 4.0.3 | Recarga automática en desarrollo |
