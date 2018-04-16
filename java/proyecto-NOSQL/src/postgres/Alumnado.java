package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Alumnado {
	static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/proyectoblanco";
	static final String USER = "blanco";
	static final String PWD = "blanco";
	
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
	
	public String listado(){
		String retorno = "";
		if (conn != null) {
			Statement st;
			try {
				st = conn.createStatement();
				ResultSet rs;
				try {
					rs = st.executeQuery("SELECT * FROM usuarios");
					while ( rs.next() ) {
						retorno += rs.getInt("id")+" "+rs.getString("nombre")+"\n";
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
					st.executeUpdate("DELETE FROM usuarios WHERE id="+id);
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
					st.executeUpdate("INSERT INTO usuarios ("+campos+") VALUES ("+valores+")");
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}