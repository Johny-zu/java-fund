package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.Estado;
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
}
