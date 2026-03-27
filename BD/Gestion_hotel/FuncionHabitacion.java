package BD.Gestion_hotel;
import java.util.ArrayList;
import BD.Gestion_hotel.Modelo.Habitacion;

public class FuncionHabitacion {
    public boolean listaVacia(ArrayList<Habitacion> listadoHabitacion){
        if (listadoHabitacion == null || listadoHabitacion.isEmpty()) {
            return true;
        } else return false;
    }
}
