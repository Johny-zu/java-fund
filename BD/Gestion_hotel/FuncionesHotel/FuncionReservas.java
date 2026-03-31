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
import BD.Gestion_hotel.Modelo.Huesped;
import BD.Gestion_hotel.Modelo.Reservas;

public class FuncionReservas {
    public List<Reservas> enlistarReservas() throws SQLException{
        List<Reservas> listadoReservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try(Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    java.sql.Date sqlDateInicio = rs.getDate("fecha_inicio");
                    LocalDate fechaInicio = sqlDateInicio.toLocalDate();
                    java.sql.Date sqlDateFin = rs.getDate("fecha_fin");
                    LocalDate fechaFin = sqlDateFin.toLocalDate();
                    java.sql.Timestamp  sqlDateReserva = rs.getTimestamp("fecha_reserva");
                    LocalDateTime fechaReserva = sqlDateReserva.toLocalDateTime();

                    Reservas r = new Reservas(
                        rs.getInt("id_reserva"),
                        fechaInicio,
                        fechaFin,
                        fechaReserva,
                        Estado.fromString(rs.getString("estado")),
                        rs.getDouble("total")
                    );
                    listadoReservas.add(r);
                }
            }
        return listadoReservas;
    }

    public List<Reservas> enlistarPorEstado(String estado) throws SQLException{
        List<Reservas> listaEstados = new ArrayList<>();
        String sql = "SELECT * FROM reservas WHERE estado=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){  
            pstmt.setString(1, estado);  
            try(ResultSet rs = pstmt.executeQuery()){  
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
                    listaEstados.add(r);
                }
            }
        }
        return listaEstados;
    }

    public List<Reservas> enlistarPorHuesped(Huesped huesped) throws SQLException{
        List<Reservas> listaHuespedes = new ArrayList<>();
        String sql = "SELECT * FROM reservas WHERE id_huesped=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){  
            pstmt.setInt(1, huesped.getId_huesped());  
            try(ResultSet rs = pstmt.executeQuery()){  
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
                    listaHuespedes.add(r);
                }
            }
        }
        return listaHuespedes;
    }

    public List<Reservas> enlistarPorFechas(LocalDate fecha_inicio, LocalDate fecha_fin) throws SQLException {
        List<Reservas> listadoPorFechas = new ArrayList<>();
        String sql = "SELECT * FROM reservas WHERE fecha_inicio >= ? AND fecha_fin <= ?";
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                java.sql.Date sqlFechaInicio = java.sql.Date.valueOf(fecha_inicio);
                java.sql.Date sqlFechaFin = java.sql.Date.valueOf(fecha_fin);
                
                pstmt.setDate(1, sqlFechaInicio);
                pstmt.setDate(2, sqlFechaFin);
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
                        listadoPorFechas.add(r);
                    }
                }
            }
        return listadoPorFechas;
    }

    public void insertar(Reservas reservas) throws SQLException{
        String sql = "INSERT INTO reservas (id_huesped, fecha_inicio, fecha_fin, fecha_reserva, estado, total) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, reservas.getHuesped().getId_huesped());
                pstmt.setDate(2, java.sql.Date.valueOf(reservas.getFecha_inicio()));
                pstmt.setDate(3, java.sql.Date.valueOf(reservas.getFecha_fin()));
                pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(reservas.getFecha_reserva()));
                pstmt.setString(5, reservas.getEstado().getValor());
                pstmt.setDouble(6, reservas.getTotal());
                
                pstmt.executeUpdate();
        }
    }

    public void actualizar(Reservas reservas) throws SQLException{
        String sql = "UPDATE reservas SET id_huesped=?, fecha_inicio=?, fecha_fin=?, fecha_reserva=?, estado=?, total=? WHERE id_reserva=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, reservas.getHuesped().getId_huesped());
                pstmt.setDate(2, java.sql.Date.valueOf(reservas.getFecha_inicio()));
                pstmt.setDate(3, java.sql.Date.valueOf(reservas.getFecha_fin()));
                pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(reservas.getFecha_reserva()));
                pstmt.setString(5, reservas.getEstado().getValor());
                pstmt.setDouble(6, reservas.getTotal());
                pstmt.setInt(7, reservas.getId_reserva());  
                pstmt.executeUpdate();
        }
    }

    public void eliminarPorID(int id) throws SQLException {
        // Primero verificar si el huésped tiene reservas
        String sqlVerificar = "SELECT COUNT(*) FROM reservas WHERE id_huesped = ?";
        String sqlEliminar = "DELETE FROM huespedes WHERE id_huesped = ?";
        try (Connection conn = ConexionBaseDatos.getConnection()) {
            // Verificar reservas existentes
            try (PreparedStatement pstmtVerificar = conn.prepareStatement(sqlVerificar)) {
                pstmtVerificar.setInt(1, id);
                try (ResultSet rs = pstmtVerificar.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) {
                        System.out.println("No se puede eliminar el huésped porque tiene reservas asociadas.");
                        return;
                    }
                }
            }
            // Si no tiene reservas, proceder a eliminar
            try (PreparedStatement pstmtEliminar = conn.prepareStatement(sqlEliminar)) {
                pstmtEliminar.setInt(1, id);
                int filaAfectada = pstmtEliminar.executeUpdate();
                if (filaAfectada > 0) {
                    System.out.println("Huésped eliminado con éxito");
                } else {
                    System.out.println("No se halló al huésped");
                }
            }
        }
    }
}
