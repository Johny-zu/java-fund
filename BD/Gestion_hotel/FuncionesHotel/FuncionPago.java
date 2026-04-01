package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.Pagos;
import BD.Gestion_hotel.Modelo.Metodo;

public class FuncionPago {
    public void listarPorReserva(int id) throws SQLException {
        String sql = "SELECT * FROM pagos WHERE id_reserva = ?";
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    java.sql.Timestamp sqlFechaPago = rs.getTimestamp("fecha_pago");
                    LocalDateTime fechaPago = sqlFechaPago.toLocalDateTime();
                    Pagos pago = new Pagos(
                        rs.getInt("id_pago"),
                        rs.getDouble("monto"),
                        fechaPago,
                        Metodo.fromString(rs.getString("metodo")),
                        rs.getString("referencia")
                    );
                    System.out.println(pago);
                }
            }
        }
    }
}
