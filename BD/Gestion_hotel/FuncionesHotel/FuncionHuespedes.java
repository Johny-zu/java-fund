package BD.Gestion_hotel.FuncionesHotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.Huesped;

public class FuncionHuespedes {
    public List<Huesped> enlistarHuespedes()throws SQLException{
        List<Huesped> huesped = new ArrayList<>();
        String sql = "SELECT * FROM huespedes";
        try(Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
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
                    huesped.add(h);
                }
            }
        return huesped;
    }
}
