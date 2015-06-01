package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geradorprova", "root", "1234");
			System.out.println("Banco conectado!");
		}catch(SQLException e){
			System.out.println("Erro - conexao"+e.getMessage());
			
		}catch (ClassNotFoundException e){
			System.out.println("Erro - driver"+e.getMessage());
		}
		return con;
		
	}

}
