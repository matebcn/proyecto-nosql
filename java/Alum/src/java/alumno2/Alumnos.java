package alumno2;

import alumno2.Alumnado;
import java.util.ArrayList;

public class Alumnos {

    public String listado_OLD() {
        Alumnado alumnosDB = new Alumnado();
        alumnosDB.conecta();
        String alumnos = alumnosDB.listado_OLD();
        alumnosDB.desconecta();
        return alumnos;

    }

    public ArrayList<Alumno> listado() {
        Alumnado alumnosDB = new Alumnado();
        alumnosDB.conecta();
        ArrayList<Alumno> alumnos = alumnosDB.listado();
        alumnosDB.desconecta();
        return alumnos;
    }
}
