package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BD.Gestion_hotel.ConexionBaseDatos;

public class FuncionReporteServicio {
    public double obtenerOcupacionPorFecha(Date fecha) throws SQLException{
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
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
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

    public double obtenerIngresosPorPeriodo(Date inicio, Date fin) throws SQLException{
        double totalIngresos = 0.0;
        String sql = "SELECT SUM(monto) as total FROM pagos WHERE fecha_pago BETWEEN ? AND ?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                java.sql.Date sqlinicio = new java.sql.Date(inicio.getTime());
                java.sql.Date sqlfin = new java.sql.Date(fin.getTime());
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
}
