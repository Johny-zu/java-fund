package BD.Gestion_hotel.FuncionesHotel;
import java.sql.*;  
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.Modelo.Habitacion;
import BD.Gestion_hotel.Modelo.TipoHabitacion;
import BD.Gestion_hotel.ConexionBaseDatos;
import BD.Gestion_hotel.Modelo.EstadoHabitacion;    

public class FuncionHabitacion {
    public boolean hayRegistros() throws SQLException {
        String sql = "SELECT COUNT(*) FROM habitaciones";
        try (Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;  // true si hay al menos 1 registro
            }
        }
        return false;
    }

    public List<Habitacion> enlistarHabitaciones() throws SQLException{
        List<Habitacion> habitacion = new ArrayList<>();
        String sql = "SELECT * FROM habitaciones";
        try(Connection conn = ConexionBaseDatos.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
                while (rs.next()) {
                    Habitacion h = new Habitacion(
                        rs.getInt("id_habitacion"),                                    
                        rs.getString("numero"),                                        
                        TipoHabitacion.fromString(rs.getString("tipo")),              
                        rs.getDouble("precio_noche"),
                        rs.getInt("capacidad"),
                        EstadoHabitacion.fromString(rs.getString("estado"))           
                    );
                    habitacion.add(h);
                }
            }
        return habitacion;
    }

    public void insertar(Habitacion habitacion) throws SQLException{
    String sql = "INSERT INTO habitaciones (numero, tipo, precio_noche, capacidad, estado) VALUES (?, ?, ?, ?, ?)";
    try(Connection conn = ConexionBaseDatos.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.setString(1, habitacion.getNumero());                    
                stmt.setString(2, habitacion.getTipo().getValor());          
                stmt.setDouble(3, habitacion.getPrecio_noche());
                stmt.setInt(4, habitacion.getCapacidad());                   
                stmt.setString(5, habitacion.getEstado().getValor());        
                stmt.executeUpdate();
        }
    }

    public void actualizar(Habitacion habitacion) throws SQLException{
        String sql = "UPDATE habitaciones SET numero=?, tipo=?, precio_noche=?, capacidad=?, estado=? WHERE id_habitacion=?";
        try(Connection conn = ConexionBaseDatos.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)){
                    stmt.setString(1, habitacion.getNumero());                    
                    stmt.setString(2, habitacion.getTipo().getValor());          
                    stmt.setDouble(3, habitacion.getPrecio_noche());
                    stmt.setInt(4, habitacion.getCapacidad());                   
                    stmt.setString(5, habitacion.getEstado().getValor());
                    stmt.setInt(6, habitacion.getId_habitacion()); 
                    stmt.executeUpdate();
        }
    }

    public void eliminarPorID(int id)throws SQLException{
        String sql = "DELETE FROM habitaciones WHERE id_habitacion=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, id);
                int filaAfectada = pstmt.executeUpdate();
                if(filaAfectada > 0)
                    System.out.println("Habitacion eliminada con exito");
                else 
                    System.out.println("No se hallo la habitacion con el id: " + id);
            }
    }

    public Habitacion buscarID(int id) throws SQLException{
        String sql = "SELECT * FROM habitaciones WHERE id_habitacion=?";
        try(Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstst = conn.prepareStatement(sql)){
                pstst.setInt(1, id);
                ResultSet rs = pstst.executeQuery();
                if (rs.next()) {
                    return new Habitacion(
                        rs.getInt("id_habitacion"),                                    
                        rs.getString("numero"),                                        
                        TipoHabitacion.fromString(rs.getString("tipo")),              
                        rs.getDouble("precio_noche"),
                        rs.getInt("capacidad"),
                        EstadoHabitacion.fromString(rs.getString("estado"))           
                    );
                }
            }
        return null;
    }

    public List<Habitacion> listarDisponiblesPorFechas(Date inicio, Date fin) throws SQLException {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        
        String sql = "SELECT * FROM habitaciones h " +
                    "WHERE h.id_habitacion NOT IN ( " +
                    "    SELECT rh.id_habitacion " +
                    "    FROM reservas_has_habitaciones rh " +
                    "    INNER JOIN reservas r ON rh.id_reserva = r.id_reserva " +
                    "    WHERE r.estado != 'cancelada' " +
                    "    AND r.fecha_inicio < ? " +
                    "    AND r.fecha_fin > ? " +
                    ") " +
                    "AND h.estado = 'disponible'";
        
        try (Connection conn = ConexionBaseDatos.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            java.sql.Date sqlFechaInicio = new java.sql.Date(inicio.getTime());
            java.sql.Date sqlFechaFin = new java.sql.Date(fin.getTime());
            
            pstmt.setDate(1, sqlFechaFin);    // fecha_inicio < fecha_fin_buscada
            pstmt.setDate(2, sqlFechaInicio); // fecha_fin > fecha_inicio_buscada
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Habitacion h = new Habitacion(
                        rs.getInt("id_habitacion"),
                        rs.getString("numero"),
                        TipoHabitacion.fromString(rs.getString("tipo")),
                        rs.getDouble("precio_noche"),
                        rs.getInt("capacidad"),
                        EstadoHabitacion.fromString(rs.getString("estado"))
                    );
                    habitacionesDisponibles.add(h);
                }
            }
        }
        
        return habitacionesDisponibles;
    }
}