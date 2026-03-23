-- 1. Tablas sin dependencias
CREATE TABLE Habitaciones (
  id_habitacion INT NOT NULL AUTO_INCREMENT,
  numero VARCHAR(10) NOT NULL,
  tipo ENUM('individual', 'doble', 'suite') NOT NULL,
  precio_noche DECIMAL(10,2) NOT NULL,
  capacidad INT NOT NULL,
  estado ENUM('disponible', 'mantenimiento') DEFAULT 'disponible',
  PRIMARY KEY(id_habitacion),
  UNIQUE KEY unique_numero (numero)
);

CREATE TABLE Huespedes (
  id_huesped INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefono VARCHAR(20),
  documento VARCHAR(50) NOT NULL,
  fecha_registro DATE NOT NULL DEFAULT (CURRENT_DATE),
  PRIMARY KEY(id_huesped),
  UNIQUE KEY unique_email (email),
  UNIQUE KEY unique_documento (documento)
);

-- 2. Reservas depende de Huespedes
CREATE TABLE Reservas (
  id_reserva INT NOT NULL AUTO_INCREMENT,
  id_huesped INT NOT NULL,
  fecha_inicio DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  fecha_reserva DATETIME DEFAULT CURRENT_TIMESTAMP,
  estado ENUM('confirmada', 'check_in', 'check_out', 'cancelada') DEFAULT 'confirmada',
  total DECIMAL(10,2) DEFAULT 0.00,
  PRIMARY KEY(id_reserva),
  FOREIGN KEY (id_huesped) REFERENCES Huespedes(id_huesped) ON DELETE RESTRICT,
  CHECK (fecha_fin > fecha_inicio)
);

-- 3. Tabla puente depende de Reservas y Habitaciones
CREATE TABLE Reservas_has_Habitaciones (
  id INT NOT NULL AUTO_INCREMENT,
  id_reserva INT NOT NULL,
  id_habitacion INT NOT NULL,
  precio_noche_aplicado DECIMAL(10,2) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (id_reserva) REFERENCES Reservas(id_reserva) ON DELETE CASCADE,
  FOREIGN KEY (id_habitacion) REFERENCES Habitaciones(id_habitacion) ON DELETE RESTRICT,
  UNIQUE KEY unique_reserva_habitacion (id_reserva, id_habitacion)
);

-- 4. Pagos depende de Reservas
CREATE TABLE Pagos (
  id_pago INT NOT NULL AUTO_INCREMENT,
  id_reserva INT NOT NULL,
  monto DECIMAL(10,2) NOT NULL,
  fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
  metodo ENUM('efectivo', 'tarjeta', 'transferencia') NOT NULL,
  referencia VARCHAR(100),
  PRIMARY KEY(id_pago),
  FOREIGN KEY (id_reserva) REFERENCES Reservas(id_reserva) ON DELETE RESTRICT
);