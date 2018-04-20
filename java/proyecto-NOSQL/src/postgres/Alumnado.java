package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proyectonosql.Alumno;

public class Alumnado {
	private static final int REGISTROS = 100;
	private static final int CAMPOS = 5;
	
	static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/proyectoblanco";
	static final String USER = "blanco";
	static final String PWD = "blanco";
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
	
	public String listado_OLD(){
		// primeras pruebas
		String retorno = "";
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
				ResultSet rs;
				try {
					rs = st.executeQuery("SELECT * FROM "+TABLA);
					while ( rs.next() ) {
						retorno += rs.getInt("id")+" "+rs.getString("nombre")+" "+rs.getString("apellido")+"\n";
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

	public Alumno[] buscar(String campo, String valor){
		Alumno[] retorno = new Alumno[REGISTROS];		// no es la manera más correcta
		
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
						retorno[contador++] = new Alumno(id);
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
	
	public Alumno[] listado(){
		Alumno[] retorno = new Alumno[REGISTROS];
		
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
				ResultSet rs;
				try {
					rs = st.executeQuery("SELECT id FROM "+TABLA);
					
					int contador = 0;
					while ( rs.next() ) {
						int id = rs.getInt("id");
						retorno[contador++] = new Alumno(id);
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
	
	public void borrar(int id) {
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
					st.executeUpdate("DELETE FROM "+TABLA+" WHERE id="+id);
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
	
	public String[] recuperar(int id) {
		
		String[] retorno = new String[CAMPOS];
		if (conn != null) {
			Statement st;
			try {
				ResultSet rs;
				st = conn.createStatement();
				rs = st.executeQuery("SELECT nombre,apellido,mail,caracteristicas FROM "+TABLA+" WHERE id="+id);
				
				while (rs.next()) {
					// mejor MAP
					retorno[0] = rs.getString("nombre");
					retorno[1] = rs.getString("apellido");
					retorno[2] = rs.getString("mail");
					retorno[3] = rs.getString("caracteristicas");
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