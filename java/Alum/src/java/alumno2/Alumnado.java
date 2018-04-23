package alumno2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import alumno2.Alumno;

public class Alumnado {

    static final String DRIVER = "org.postgresql.Driver";
    static final String URL = "jdbc:postgresql://localhost:5432/Alumnos";
    static final String USER = "postgres";
    static final String PWD = "toor";
    static final String TABLA = "alumnos";

    private Connection conn = null;

    public void conecta() {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String listado_OLD() {
        // primeras pruebas
        String retorno = "";
        if (conn != null) {
            try (Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA);) {

                while (rs.next()) {
                    retorno += rs.getInt("id") + " " + rs.getString("nombre") + " " + rs.getString("apellido") + "\n";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return retorno;
    }

    public Alumno[] listado() {
        Alumno[] retorno = new Alumno[100];

        if (conn != null) {
            try (Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT id FROM " + TABLA + " WHERE active > 0")) {
                int contador = 0;
                while (rs.next()) {
                    int id = rs.getInt("id");
                    retorno[contador++] = new Alumno(id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }

    public void borrar(int id) {
        if (conn != null) {
            try (Statement st = conn.createStatement()) {
                 st.executeUpdate("update " + TABLA + " set active = 0 where id =" + id);
                //st.executeUpdate("DELETE FROM " + TABLA + " WHERE id=" + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertar(String campos, String valores) {
        if (conn != null) {
            try (Statement st = conn.createStatement()) {
                st.executeUpdate("INSERT INTO " + TABLA + " (" + campos + ") VALUES (" + valores + ")");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizar(String actualizar, int id) {
        if (conn != null) {
            try (Statement st = conn.createStatement()) {
                st.executeUpdate("UPDATE " + TABLA + " SET " + actualizar + " WHERE id=" + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String[] recuperar(int id) {

        String[] retorno = new String[5];
        if (conn != null) {
            try (Statement st = conn.createStatement(); 
                    ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=" + id)) {
                while (rs.next()) {
                    // mejor MAP
                    retorno[0] = rs.getString("nombre");
                    retorno[1] = rs.getString("apellido");
                    retorno[2] = rs.getString("mail");
                    retorno[3] = rs.getString("caracteristicas");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }

}
