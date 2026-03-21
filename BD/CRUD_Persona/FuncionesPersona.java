package BD.CRUD_Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionesPersona {
    public void insertar(Persona persona) throws SQLException {
        String sql = "INSERT INTO personas (nombre, edad, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, persona.getNombre());
            pstmt.setInt(2, persona.getEdad());
            pstmt.setString(3, persona.getEmail());
            pstmt.executeUpdate();
        }
    }
    
    public List<Personas> enlistarTodos() throws SQLException{
        List<Personas> personas = new ArrayList<>();
        String sql = "SELECT * FROM datos_personas";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    Personas p = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("email")
                    );
                    personas.add(p);
                }
            }
        return personas;
    }

    public void actualizar(Persona persona) throws SQLException{
        String sql = "UPDATE datos_personas SET nombre=?, edad=?, email=? WHERE id=?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, persona.getNombre());
                pstmt.setInt(2, persona.getEdad());
                pstmt.setString(3, persona.getEmail());
                pstmt.setInt(4, persona.getId());
                pstmt.executeUpdate();
        }
    }

    public void eliminar(Persona persona) throws SQLException{
        String sql = "DELETE FROM datos_personas WHERE id=?";
        try(Connection conn = DatabaseConnection.getConnection();
            prepareStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
    }
}
