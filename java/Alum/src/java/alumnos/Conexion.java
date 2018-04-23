/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author devweb
 */
public class Conexion {

    public static LinkedList<Alumno> getAlumnos() {
        LinkedList<Alumno> listaContactos = new LinkedList<Alumno>();

        String url = "jdbc:postgresql://localhost:5432/Alumnos";
        String user = "postgres";
        String password = "toor";
        String SQL = "SELECT * FROM alumnos";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servAlum.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Alumno alum = new Alumno();
                alum.setId(rs.getInt("id"));
                alum.setNombre(rs.getString("nombre"));
                alum.setApellido(rs.getString("apellido"));
                alum.setMail(rs.getString("mail"));
                alum.setActive(rs.getInt("active"));
                alum.setCaracteristicas(rs.getString("caracteristicas"));

                listaContactos.add(alum);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaContactos;
    }
}


