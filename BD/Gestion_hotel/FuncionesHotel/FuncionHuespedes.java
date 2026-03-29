package BD.Gestion_hotel.FuncionesHotel;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void insertar(Huesped huesped) throws SQLException{
        String sql = "INSERT INTO huespedes (nombre, email, telefono, documento, fecha_registro) VALUES (?, ? , ?, ?, ?)";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, huesped.getNombre());
                pstmt.setString(2, huesped.getEmail());
                pstmt.setString(3, huesped.getTelefono());
                pstmt.setString(4, huesped.getDocumento());
                pstmt.setDate(5, java.sql.Date.valueOf(huesped.getFecha_registro()));
                pstmt.executeUpdate();
            }
    }

    public void actualizar(Huesped huesped) throws SQLException{
        String sql = "UPDATE huespedes SET nombre=?, email=?, telefono=?, documento =?, fecha_registro=? WHERE id_huesped=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, huesped.getNombre());
                pstmt.setString(2, huesped.getEmail());
                pstmt.setString(3, huesped.getTelefono());
                pstmt.setString(4, huesped.getDocumento());
                pstmt.setDate(5, java.sql.Date.valueOf(huesped.getFecha_registro()));
                pstmt.setInt(6, huesped.getId_huesped());
                pstmt.executeUpdate();
            }
    }

    public void eliminarPorID(int id) throws SQLException{
        String sql = "DELETE FROM huespedes WHERE id_huesped=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);{
                    int filaAfectada = pstmt.executeUpdate();
                    if (filaAfectada > 0) System.out.println("Huesped eliminado con exito");
                    else System.out.println("No se hallo al huesped");
                }
            }
    }

    public Huesped buscarPorID(int id) throws SQLException{
        String sql = "SELECT * FROM huespedes WHERE id_huesped=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    java.sql.Date sqlDate = rs.getDate("fecha_registro");
                    LocalDate fechaRegistro = sqlDate.toLocalDate();
                    return new Huesped(
                        rs.getInt("id_huesped"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("documento"),
                        fechaRegistro
                    );
                }
            }
        
        return null;
    }
}
