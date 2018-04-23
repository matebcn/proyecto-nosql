package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import proyectonosql.Alumno;

public class Alumnado {
	//private static final int REGISTROS = 100;
	private static final int CAMPOS = 5;
	
	static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/proyectoblanco";
	static final String USER = "blanco";
	static final String PWD = "blanco";
//	static final String URL = "jdbc:postgresql://192.168.40.156:5432/Alumnos";
//	static final String USER = "postgres";
//	static final String PWD = "toor";
	static final String TABLA = "alumnos";
	
	Connection conn;
	
	public void conecta() {
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);
		} catch (SQLException e) {
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
	

	public ArrayList<Alumno> buscar(String campo, String valor){
		ArrayList<Alumno> retorno = new ArrayList<Alumno>();
		
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
				ResultSet rs;
				try {
					rs = st.executeQuery("SELECT id FROM "+TABLA+ " WHERE caracteristicas->>'"+campo+"'='"+valor+"'");
					
					int contador = 0;
					while ( rs.next() ) {
						int id = rs.getInt("id");
						retorno.add(new Alumno(id));
					}
					rs.close();
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retorno;
	}
	
	
    public ArrayList<Alumno> listado() {
        ArrayList<Alumno> returnList = new ArrayList<Alumno>();

        if (conn != null) {
            try (Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT id FROM " + TABLA + " WHERE active > 0")) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    returnList.add(new Alumno(id));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnList;
    }
	
	public void borrar(int id) {
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
					//st.executeUpdate("DELETE FROM "+TABLA+" WHERE id="+id);
					st.executeUpdate("UPDATE "+TABLA+" SET active=0 WHERE id="+id);
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertar(String campos, String valores) {
		
		if (conn != null) {
			Statement st;
			try {
				
				st = conn.createStatement();
				st.executeUpdate("INSERT INTO "+TABLA+" ("+campos+") VALUES ("+valores+")");
				
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actualizar(String actualizar,int id) {
		
		if (conn != null) {
			Statement st;
			try {
				
				st = conn.createStatement();
				st.executeUpdate("UPDATE "+TABLA+" SET "+actualizar+" WHERE id="+id);
				
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Map<String,String> recuperar(int id) {
		
		Map<String,String> retorno = new HashMap<String,String>();
		if (conn != null) {
			Statement st;
			try {
				ResultSet rs;
				st = conn.createStatement();
				rs = st.executeQuery("SELECT nombre,apellido,mail,caracteristicas FROM "+TABLA+" WHERE id="+id);
				
				while (rs.next()) {

					retorno.put( "nombre", rs.getString("nombre") );
					retorno.put( "apellido", rs.getString("apellido") );
					retorno.put( "mail", rs.getString("mail") );
					retorno.put( "caracteristicas", rs.getString("caracteristicas") );
				}
				
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return retorno;
	}

}