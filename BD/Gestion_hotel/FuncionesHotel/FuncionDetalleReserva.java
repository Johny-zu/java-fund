package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.Habitacion;
import BD.Gestion_hotel.Modelo.Reservas;
import BD.Gestion_hotel.Modelo.ReservasHasHabitaciones;

public class FuncionDetalleReserva {
    public List<ReservasHasHabitaciones> listarPorReserva(int id) throws SQLException{
        List<ReservasHasHabitaciones> detalles = new ArrayList<>();
        String sql = "SELECT * FROM Reservas_has_Habitaciones WHERE id_reservas=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                try(ResultSet rs = pstmt.executeQuery()){
                    Reservas reserva = new FuncionReservas().buscarPorID(rs.getInt("id_reserva"));
                    Habitacion habitacion = new FuncionHabitacion().buscarID(rs.getInt("id_habitacion"));
                    while (rs.next()) {
                        ReservasHasHabitaciones detalle = new ReservasHasHabitaciones(
                            reserva,
                            habitacion,
                            rs.getDouble("Precio_noche_aplicado")
                        );
                        detalles.add(detalle);
                    }
                }
            }
        return detalles;
    }

    public void insertar(ReservasHasHabitaciones detalle) throws SQLException {
        String sql = "INSERT INTO reservas_has_habitaciones (id_reserva, id_habitacion, precio_noche_aplicado) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBaseDatos.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detalle.getReserva().getId_reserva());
            pstmt.setInt(2, detalle.getHabitacion().getId_habitacion());
            pstmt.setDouble(3, detalle.getPrecioNocheAplicado());
            pstmt.executeUpdate();
        }
    }

    public void eliminarPorReserva(int id) throws SQLException{
        String sql = "DELETE FROM reservas_has_habitaciones WHERE id_reserva=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
    }
}
