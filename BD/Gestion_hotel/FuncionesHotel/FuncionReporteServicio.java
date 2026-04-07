package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.Estado;
import BD.Gestion_hotel.Modelo.EstadoHabitacion;
import BD.Gestion_hotel.Modelo.Habitacion;
import BD.Gestion_hotel.Modelo.Huesped;
import BD.Gestion_hotel.Modelo.Reservas;
import BD.Gestion_hotel.Modelo.TipoHabitacion;

public class FuncionReporteServicio {
    public double obtenerOcupacionPorFecha(LocalDate fecha) throws SQLException {
        double porcentaje = 0;
        String sqlTotal = "SELECT COUNT(*) as total FROM habitaciones";
        String sqlOcupadas = "SELECT COUNT(DISTINCT h.id_habitacion) as ocupadas " +
                        "FROM habitaciones h " +
                        "INNER JOIN reservas_has_habitaciones rh ON h.id_habitacion = rh.id_habitacion " +
                        "INNER JOIN reservas r ON rh.id_reserva = r.id_reserva " +
                        "WHERE r.fecha_inicio <= ? " +
                        "AND r.fecha_fin >= ? " +
                        "AND r.estado != 'cancelada'";

        try(Connection conn = ConexionBaseDatos.getConnection()){
            int totalHabitaciones = 0;
            try(Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlTotal)){
                    if (rs.next()) {
                        totalHabitaciones = rs.getInt("total");
                    }
                }
            if (totalHabitaciones == 0) {
                return 0.0;
            }

            int habitacionesOcupados = 0;
            try(PreparedStatement pstmt = conn.prepareStatement(sqlOcupadas)){
                java.sql.Date sqlFecha = java.sql.Date.valueOf(fecha); 
                pstmt.setDate(1, sqlFecha);
                pstmt.setDate(2, sqlFecha);
                try(ResultSet rs = pstmt.executeQuery()){
                    if (rs.next()) {
                        habitacionesOcupados = rs.getInt("ocupadas");
                    }
                }
            }

            porcentaje = (habitacionesOcupados * 100.0) / totalHabitaciones;
        }
        return porcentaje;
    }

    public double obtenerIngresosPorPeriodo(LocalDate inicio, LocalDate fin) throws SQLException {
        double totalIngresos = 0.0;
        String sql = "SELECT SUM(monto) as total FROM pagos WHERE fecha_pago BETWEEN ? AND ?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                java.sql.Date sqlinicio = java.sql.Date.valueOf(inicio);
                java.sql.Date sqlfin = java.sql.Date.valueOf(fin);
                pstmt.setDate(1, sqlinicio);
                pstmt.setDate(2, sqlfin);

                try(ResultSet rs = pstmt.executeQuery()){
                    if (rs.next()) {
                        totalIngresos = rs.getDouble("total");
                    }
                }
        }
        return totalIngresos;
    }
    
    public List<Habitacion> obtenerHabitacionesMasReservadas() throws SQLException {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT h.id_habitacion, h.numero, h.tipo, h.precio_noche, h.capacidad, h.estado, " +
                    "COUNT(rh.id_habitacion) as total_reservas " +
                    "FROM habitaciones h " +
                    "INNER JOIN reservas_has_habitaciones rh ON h.id_habitacion = rh.id_habitacion " +
                    "GROUP BY h.id_habitacion " +
                    "ORDER BY total_reservas DESC " +
                    "LIMIT 5";
        
        try (Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Habitacion h = new Habitacion(
                    rs.getInt("id_habitacion"),
                    rs.getString("numero"),
                    TipoHabitacion.fromString(rs.getString("tipo")),
                    rs.getDouble("precio_noche"),
                    rs.getInt("capacidad"),
                    EstadoHabitacion.fromString(rs.getString("estado"))
                );
                habitaciones.add(h);
            }
        }
        return habitaciones;
    }

    public List<Huesped> obtenerHuespedesFrecuentes() throws SQLException {
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT hu.id_huesped, hu.nombre, hu.email, hu.telefono, hu.documento, hu.fecha_registro, " +
                    "COUNT(r.id_reserva) as total_reservas " +
                    "FROM huespedes hu " +
                    "INNER JOIN reservas r ON hu.id_huesped = r.id_huesped " +
                    "GROUP BY hu.id_huesped " +
                    "ORDER BY total_reservas DESC " +
                    "LIMIT 5";
        try (Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                java.sql.Date sqlDate = rs.getDate("fecha_registro");
                LocalDate fechaRegistro = sqlDate.toLocalDate();
                Huesped h = new Huesped(
                    rs.getInt("id_huesped"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("documento"),
                    fechaRegistro
                );
                huespedes.add(h);
            }
        }
        return huespedes;
    }

    public List<Reservas> obtenerReservasActivasHoy() throws SQLException {
        List<Reservas> reservasActivas = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        String sql = "SELECT * FROM reservas WHERE fecha_inicio <= ? AND fecha_fin >= ? AND estado != 'cancelada'";
        
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            java.sql.Date sqlHoy = java.sql.Date.valueOf(hoy);
            pstmt.setDate(1, sqlHoy);
            pstmt.setDate(2, sqlHoy);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    java.sql.Date sqlDateInicio = rs.getDate("fecha_inicio");
                    LocalDate fechaInicio = sqlDateInicio.toLocalDate();
                    java.sql.Date sqlDateFin = rs.getDate("fecha_fin");
                    LocalDate fechaFin = sqlDateFin.toLocalDate();
                    java.sql.Timestamp sqlDateReserva = rs.getTimestamp("fecha_reserva");
                    LocalDateTime fechaReserva = sqlDateReserva.toLocalDateTime();
                    
                    Reservas r = new Reservas(
                        rs.getInt("id_reserva"),
                        fechaInicio,
                        fechaFin,
                        fechaReserva,
                        Estado.fromString(rs.getString("estado")),
                        rs.getDouble("total")
                    );
                    reservasActivas.add(r);
                }
            }
        }
        return reservasActivas;
    }
}
