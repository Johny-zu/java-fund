package BD.Gestion_hotel;
import java.sql.*;  
import java.util.ArrayList;
import java.util.List;
import BD.CRUD_Persona.DatabaseConnection;
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
        try(Connection conn = DatabaseConnection.getConnection();
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
}