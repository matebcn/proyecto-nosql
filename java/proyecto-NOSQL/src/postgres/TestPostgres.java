package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestPostgres {
	static final String DRIVER = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/proyectoblanco";
	static final String USER = "blanco";
	static final String PWD = "blanco";
	
	public static void main(String[] args) throws Exception{
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL,USER,PWD);
		
		if (conn != null) {
			System.out.println("OK");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT VERSION()");
			
			if ( rs.next() ) {
				System.out.println(rs.getString(1));
			}
			
			rs = st.executeQuery("SELECT * FROM usuarios");
			
			while ( rs.next() ) {
				System.out.println(rs.getString("nombre"));
			}
			
			st.close();
			conn.close();
			
		}
		else System.out.println("KO");
	}
}
