# API Hotel

Lo siguiente es una lista de endpoints disponibles y recursos necesarios para consumir con esta API.

**URL de la aplicación:**  
`https://hoteleria-cuh2gzacd2fkg5f9.mexicocentral-01.azurewebsites.net/`

### AUTORIZACIÓN

Se requiere incluir un **Bearer Token** proporcionado al usuario en el encabezado de autorización para ciertas solicitudes.

## ENDPOINTS

### 1. USUARIO

- **Registrar usuario**
  - **Request URL:** `POST /users/register/user`
  - **Request Body (form data):**
    ```json
    {
      "key": "usuario",
      "value": {
        "telefono": "933777024",
        "email": "ivanrual61@gmail.com",
        "contrasena": "test123",
        "dni": 74231760
    },
      [Opcional]
      "key": "imagen",
      "value": "Download.jpg"
    }
    ```
  - **Response:**
    ```json
    {
      "code": 200,
      "message": "Usuario registrado con éxito y Token generado"
    }
    ```

- **Loguear usuario**
  - **Request URL:** `POST auth/login`
  - **Request Body i.e:**
    ```json
    {
        "email": "ivanrual61@gmail.com",
        "contrasena": "test123"
    }
    ```
  - **Response:**
    ```json
    {
        "message": "Login exitoso",
        "data": {
            "id": 22,
            "token": "[Token generado automáticamente]"
        }
    }
    ```
