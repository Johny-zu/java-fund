package BD.Gestion_hotel.FuncionesHotel;
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

    public void eliminarPorID(int id) throws SQLException {
        String sqlVerificar = "SELECT COUNT(*) FROM reservas WHERE id_huesped=?";
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmtVerificar = conn.prepareStatement(sqlVerificar)) {
            pstmtVerificar.setInt(1, id);
            ResultSet rs = pstmtVerificar.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("No se puede eliminar el huésped porque tiene reservas asociadas.");
                return;
            }
        }
        String sqlEliminar = "DELETE FROM huespedes WHERE id_huesped=?";
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmtEliminar = conn.prepareStatement(sqlEliminar)) {
            pstmtEliminar.setInt(1, id);
            int filaAfectada = pstmtEliminar.executeUpdate();    
            if (filaAfectada > 0) {
                System.out.println("Huésped eliminado con éxito");
            } else {
                System.out.println("No se halló al huésped");
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

    public List<Huesped> buscarPorNombre(String nombre) throws SQLException{
        List<Huesped> huespedes = new ArrayList<>();
        String sql = "SELECT * FROM huespedes WHERE nombre=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, nombre);
                ResultSet rs = pstmt.executeQuery();
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

    public Huesped buscarPorDocumento(String documento) throws SQLException{
        String sql = "SELECT * FROM huespedes WHERE documento=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, documento);
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
