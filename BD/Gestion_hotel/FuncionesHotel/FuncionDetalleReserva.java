package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.ReservasHasHabitaciones;

public class FuncionDetalleReserva {
    public List<ReservasHasHabitaciones> listarPorReserva(int id) throws SQLException{
        List<ReservasHasHabitaciones> detalles = new ArrayList<>();
        String sql = "SELECT * FROM Reservas_has_Habitaciones WHERE id_reservas=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                try(ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()) {
                        ReservasHasHabitaciones detalle = new ReservasHasHabitaciones(
                            null,
                            null,
                            rs.getDouble("Precio_noche_aplicado")
                        );
                        detalles.add(detalle);
                    }
                }
            }
        return detalles;
    }
}
