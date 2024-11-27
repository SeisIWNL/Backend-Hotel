# API de Gestión de Hoteles

Lo siguiente es una lista de endpoints disponibles y recursos necesarios para consumir esta API.

**URL de la aplicación:**  
`https://hoteleria-cuh2gzacd2fkg5f9.mexicocentral-01.azurewebsites.net`

## Requisitos previos

- Algunas rutas requieren un **Bearer Token** proporcionado al usuario en el encabezado de autorización. Obtén este token al iniciar sesión en el endpoint `/auth/login`.
- Utiliza herramientas como Postman, curl o bibliotecas de cliente HTTP (Axios, Fetch, etc.).

## Endpoints disponibles

| Funcionalidad            | Método | Endpoint           |
|--------------------------|--------|--------------------|
| Registrar usuario        | POST   | `/usuarios/crear`  |
| Validar OTP y guardar    | POST   | `/validar-otp`     |
| Login usuario            | POST   | `/auth/login`      |

---

## ENDPOINTS

### 1. USUARIO

- **Registrar usuario**
  - **Request URL:** `POST /usuarios/crear`
  - **Descripción:** Este endpoint permite registrar un nuevo usuario de manera temporal.
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
      "value": "cualquierimagen.jpg-jpeg-png"
    }
    ```
  - **Response:**
    ```json
    {
        "message": "Usuario guarda temporalmente",
        "data": {
            "key": "NE&iaPWCz%",
            "nombre": "IVAN GUILLERMO",
            "apellido": "RUPAY ALVAREZ",
            "email": "ivanrual61@gmail.com"
        }
    }
    ```

- **Validar Otp y Guardar Usuario**
  - **Request URL:** `POST /validar-otp`
  - **Descripción:** Este endpoint valida el OTP enviado por correo y crea el usuario permanentemente en el sistema.
  - **Request Body:**
    ```json
    {
      "otp": "NE&iaPWCz%"
    }
    ```
  - **Response:**
    ```json
    {
        "message": "Otp validado y usuario creado correctamente",
        "data": {
            "id": 24,
            "nombre": "Ivan Guillermo",
            "apellido": "Rupay Alvarez",
            "email": "josuealva920@gmail.com"
        }
    }
    ```

- **Loguear usuario**
  - **Request URL:** `POST auth/login`
  - **Descripción:** Este endpoint permite a un usuario iniciar sesión y recibir un token JWT para autenticarse en futuros requests.
  - **Request Body:**
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

---
