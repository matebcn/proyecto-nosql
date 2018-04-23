package alumno2;

import alumno2.Alumnado;

public class Alumnos {

    public String listado_OLD() {
        Alumnado alumnosDB = new Alumnado();
        alumnosDB.conecta();
        String alumnos = alumnosDB.listado_OLD();
        alumnosDB.desconecta();
        return alumnos;

    }

    public Alumno[] listado() {
        Alumnado alumnosDB = new Alumnado();
        alumnosDB.conecta();
        Alumno[] alumnos = alumnosDB.listado();
        alumnosDB.desconecta();
        return alumnos;
    }
}
