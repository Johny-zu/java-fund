package BD.Gestion_hotel;
import java.sql.*;  
import java.util.ArrayList;
import java.util.List;
import BD.Gestion_hotel.Modelo.Habitacion;
import BD.Gestion_hotel.Modelo.TipoHabitacion;
import BD.Gestion_hotel.Modelo.EstadoHabitacion;    

public class FuncionHabitacion {
    public boolean listaVacia(ArrayList<Habitacion> listadoHabitacion){
        if (listadoHabitacion == null || listadoHabitacion.isEmpty()) {
            return true;
        } else return false;
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
}