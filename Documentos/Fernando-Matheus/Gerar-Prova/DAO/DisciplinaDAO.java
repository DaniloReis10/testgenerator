package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;

public class DisciplinaDAO {
	
	private Connection con = Conexao.getConnection();
	
	public int buscarDisciplina(String nome){
		
		String sql ="SELECT * FROM disciplina WHERE nome = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
                int id = rs.getInt("idDisciplina");
				String snome = rs.getString("nome");
                
                return id;
                
            }            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
		
		
	}

}
