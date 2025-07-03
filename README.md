
# Evaluación de Ingreso a Pagos Digitales Peruanos

## Configuración Inicial

1. **Configura la conexión a base de datos.**  
   Abre el archivo `src/main/resources/application.properties` y reemplaza los valores de la conexión según tu entorno local:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/[nombre-de-tu-base-de-datos]
   spring.datasource.username=[usuario-de-base-de-datos]
   spring.datasource.password=[contraseña-de-base-de-datos]
   ```

2. **Ejecuta la aplicación.**  
   En una terminal ubicada en la raíz de este proyecto, ejecuta el siguiente comando:

   ```bash
   ./gradlew bootRun
   ```
   
## Pruebas con Postman

Dentro de este proyecto verás el archivo `API Examen.postman_collection.json`, el cual puedes importar en Postman. Sigue los pasos en el orden indicado:

### 1. Registrar Usuario

- **Solicitud:** `POST /auth/register`
- **Body:**

  ```json
  {
    "email": "fredanup@gmail.com",
    "contrasena": "123456"
  }
  ```

### 2. Iniciar Sesión

- **Solicitud:** `POST /auth/login`
- **Body:**

  ```json
  {
    "email": "fredanup@gmail.com",
    "contrasena": "123456"
  }
  ```

- **Respuesta esperada:** Un JWT como este:

  ```
  eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmcmVkYW51cEBnbWFpbC5jb20iLCJpYXQiOjE3NTE1MzI0MzIsImV4cCI6MTc1MTUzNjAzMn0.SkY-OSKkWQm3ZRKGTboZ4PJUjNDpIF3b_WU0z_Q3tzE
  ```

**Guarda este token**, ya que será necesario para acceder a los endpoints protegidos.

## Autenticación con JWT

Para las siguientes solicitudes, añade el token en la cabecera:

| **Header**    | **Value**                               |
|---------------|-----------------------------------------|
| Authorization | `Bearer [token-generado-anteriormente]` |

## Operaciones con Tareas

### 3. Crear Tarea

- **Solicitud:** `POST /api/tareas`
- **Body:**

  ```json
  {
    "detalle": "Enviar examen",
    "terminado": true
  }
  ```

### 4. Listar Tareas

- **Solicitud:** `GET /api/tareas`
- **Body:** No requiere.

### 5. Actualizar Tarea

- **Solicitud:** `PUT /api/tareas/{id}`
- **Body:**

  ```json
  {
    "detalle": "Resolver examen",
    "terminado": true
  }
  ```

### 6. Eliminar Tarea

- **Solicitud:** `DELETE /api/tareas/{id}`
- **Body:** No requiere. El ID se pasa en la URL.
