package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.Topico;
import conexao.Conexao;

/**
 * TopicoDAO é a classe responsavel pelos metodos da persistencia da classe topico, para buscar nome, chave primaria, chave estrangeira entre outro dados.
 *  @author Fernando Matheus
 *
 */

public class TopicoDAO {
	
	private Connection con = Conexao.getConnection();
	
	public String buscarTopico(int pk_idDisciplina){
		
			String sql ="SELECT * FROM topico WHERE Disciplina_idDisciplina = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, pk_idDisciplina);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
                int idT = rs.getInt("idTopico");
				String nomeT = rs.getString("nome");
				int idFK = rs.getInt("Disciplina_idDisciplina");
                
                return nomeT;
                
            }            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	public List<Topico> buscarLista(){
		String sql = "SELECT * FROM topico";
		
		List<Topico> lista = new ArrayList<Topico>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery(); 
			
			while(resultados.next()){
				int idT = resultados.getInt("idTopico");
				String nomeT = resultados.getString("nome");	
				int fk_id_d = resultados.getInt("Disciplina_idDisciplina");
				Topico topico = new Topico(idT, nomeT, fk_id_d);
				lista.add(topico);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}return lista;
		
		
	}
	
	public int buscarId(String nome){
		
		String sql ="SELECT * FROM topico WHERE nome = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
               int teste1 = rs.getInt("idTopico");
                return teste1;
                
            }            
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
		
		
		
	}

}
