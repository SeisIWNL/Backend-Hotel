-- Creación de tipos ENUM
CREATE TYPE tipo_rol AS ENUM ('huesped', 'admin');
CREATE TYPE estado_usuario AS ENUM ('activo', 'inactivo');
CREATE TYPE estado_habitacion AS ENUM ('disponible', 'ocupada', 'reservada', 'mantenimiento');
CREATE TYPE estado_reserva AS ENUM ('pendiente', 'confirmada', 'reservada', 'cancelada', 'completa');
CREATE TYPE estado_sede AS ENUM ('disponible', 'no disponible');

-- Creación de tablas
CREATE TABLE usuarios (
                          id_usuario SERIAL PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL,
                          telefono VARCHAR(9) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          contrasena VARCHAR(100) NOT NULL,
                          fecha_nacimiento DATE NOT NULL,
                          dni VARCHAR(8) NOT NULL,
                          departamento VARCHAR(100) NOT NULL,
                          provincia VARCHAR(100) NOT NULL,
                          distrito VARCHAR(100) NOT NULL,
                          rol tipo_rol NOT NULL DEFAULT 'huesped',
                          estado estado_usuario NOT NULL DEFAULT 'activo',
                          imagen_url VARCHAR(255),
                          fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                          email_verificado BOOLEAN DEFAULT FALSE NOT NULL
);

CREATE TABLE tipos_habitaciones (
                                    id_tipo_habitacion SERIAL PRIMARY KEY,
                                    nombre VARCHAR(100) NOT NULL,
                                    descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE tipos_camas (
                             id_tipo_cama SERIAL PRIMARY KEY,
                             nombre VARCHAR(100) NOT NULL,
                             descripcion VARCHAR(100) NOT NULL
);

CREATE TABLE sedes (
                       id_sede SERIAL PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       ciudad VARCHAR(100) NOT NULL,
                       pais VARCHAR(100) NOT NULL,
                       direccion VARCHAR(255) NOT NULL,
                       estado estado_sede NOT NULL DEFAULT 'disponible'
);

CREATE TABLE habitaciones (
                              id_habitacion SERIAL PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL,
                              precio_noche DECIMAL(10, 2) NOT NULL,
                              capacidad_max INTEGER NOT NULL,
                              estado estado_habitacion NOT NULL DEFAULT 'disponible',
                              imagen_url VARCHAR(255) NOT NULL,
                              id_tipo_cama INTEGER NOT NULL REFERENCES tipos_camas (id_tipo_cama) ON DELETE CASCADE,
                              id_tipo_habitacion INTEGER NOT NULL REFERENCES tipos_habitaciones (id_tipo_habitacion) ON DELETE CASCADE
);

CREATE TABLE reservas (
                          id_reserva SERIAL PRIMARY KEY,
                          fecha_entrada TIMESTAMP NOT NULL,
                          fecha_salida TIMESTAMP NOT NULL,
                          cantidad_huespedes INTEGER NOT NULL,
                          precio_total DECIMAL(10, 2) NOT NULL,
                          estado estado_reserva NOT NULL DEFAULT 'pendiente',
                          codigo_reserva VARCHAR(255) UNIQUE NOT NULL,
                          id_usuario INTEGER NOT NULL REFERENCES usuarios (id_usuario) ON DELETE CASCADE,
                          id_habitacion INTEGER NOT NULL REFERENCES habitaciones (id_habitacion) ON DELETE CASCADE,
                          id_sede INTEGER NOT NULL REFERENCES sedes (id_sede) ON DELETE CASCADE
);
