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
| Validar OTP y guardar    | POST   | `/usuarios/validar-otp`     |
| Login usuario            | POST   | `/auth/login`      |
| Registrar Reserva        | POST   | `/reservas/crear`      |
| Filtrar Habitaciones     | GET    | `/habitaciones//sede/{idSede}/buscar`      |

---

## ENDPOINTS

### 1. LOGIN
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

### 2. USUARIO

- **Registrar usuario**
  - **Request URL:** `POST /usuarios/crear`
  - **Descripción:** Este endpoint permite registrar un nuevo usuario de manera temporal y enviara un OTP al correo del usuario.
  - **Request Body:**
    ```json
    {
        "telefono": "933777024",
        "email": "ivanrual61@gmail.com",
        "contrasena": "test123",
        "dni": 74231760
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
  - **Request URL:** `POST /usuarios/validar-otp`
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

### 3. Habitaciones 

- **Buscar Habitaciones por Filtros**
  - **Request URL:** `GET /habitaciones/sede/{idSede}/buscar`
  - **Descripción:** Este endpoint permite filtrar habitaciones por tipo de cama, tipo de habitacion, precio minimo, precio maximo, nombre de la habitacion y habitaciones no reservadas por fecha de entrada y fecha de salida.
    ### Parámetros de Consulta

    | Parámetro | Tipo | Descripción | Ejemplo |
    |-----------|------|-------------|---------|
    | `tipoCama` | String | Nombre del Tipo de Cama | `indi` |
    | `tipoHabitacion` | String | Nombre del Tipo de Habitacion | `indi` |
    | `minPrecio` | BigDecimal | Precio Minimo | `100` |
    | `maxPrecio` | BigDecimal | Precio Maximo | `150` |
    | `fechaEntrada` | Datetime | Fecha de entrada | `2024-11-28T22:03:00` |
    | `fechaSalida` | Datetime | Fecha de salida | `2024-11-29T21:10:00` |
    | `nombreHabitacion` | String | Nombre de la Habitacion | `estan` |
  - **Response:**
    ```json
    {
        "message": "Habitaciones encontradas",
        "data": [
            {
                "id": 5,
                "nombre": "Estándar Pacífico",
                "precioNoche": 120.00,
                "capacidadMax": 1,
                "estado": "DISPONIBLE",
                "imagenUrl": "estandar_pacifico.jpg",
                "tipoCama": {
                    "id": 1,
                    "nombre": "Individual",
                    "descripcion": "Cama de tamaño estándar para una persona, ideal para habitaciones individuales o compartidas."
                },
                "tipoHabitacion": {
                    "id": 1,
                    "nombre": "Individual",
                    "descripcion": "Habitación diseñada para una persona, equipada con una cama individual y todas las comodidades básicas, ideal para viajes en solitario."
                },
                "sede": {
                    "id": 1,
                    "nombre": "Hotel Centro",
                    "ciudad": "Lima",
                    "pais": "Perú",
                    "direccion": "Av. Central 123",
                    "estado": "DISPONIBLE"
                }
            }
        ]
    }
    ```
### 4. RESERVA 

- **Registrar reserva**
  - **Request URL:** `POST /reservas/crear`
  - **Obligatorio Authentication: Bearer Token del Usuario**
  - **Descripción:** Este endpoint permite registrar una reserva y generar un codigo QR como identificacion del huesped.
  - **Request Body:**
    ```json
    {
        "fechaEntrada": "2024-11-28T22:03:00",
        "fechaSalida": "2024-11-29T21:10:00",
        "cantidadHuespedes": "4",
        "habitacion": 3,
    }
    ```
  - **Response:**
    ```json
    {
        "message": "Reserva creada con éxito",
        "data": "https://imageneshoteleria.blob.core.windows.net/imagenes-usuarios/codQR_2024-11-28T13%3A34%3A11.305075100_R911440.png"
    }
    ```
---
