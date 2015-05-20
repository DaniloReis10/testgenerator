package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Conexao;
import model.Disciplina;

public class DisciplinaDAO {

	private Conexao conexao = null;
        
        private Connection con = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        private final String tabela = "disciplinas";
        
	public DisciplinaDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Disciplina disciplina) {
		
		try {
                    con = conexao.getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (nome) values (?)"
                                                  , disciplina.getNome()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Disciplina disciplina){
		
		final String query = "update "+tabela+" set nome = ? where ID = ? ";
		
                
		try {
                        con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, disciplina.getNome()
                                                        , disciplina.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Disciplina disciplina){
             
           try {
               con = conexao.getConnection();
               conexao.executePreparedDelete(con, disciplina.getId(),tabela);
                                             
           }catch (SQLException e) {
        	   System.out.println("Erro: "+e.getMessage());
            }finally{
               conexao.release(con);
           }
             
         } 
        
         public ResultSet getById(String id){
            final String query = "select * from "+tabela+" where ID = "+id;
            try{
            
            Connection con = conexao.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            }catch (SQLException e){
               JOptionPane.showMessageDialog(null, e.getMessage());
            }finally{
                conexao.release(con);
            }
                     
            return rs;
        }
	
        public ResultSet getDisciplinas() {
	
        final String query = "select * from "+tabela;
        try{
        con = conexao.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
                        
                       
	}catch(SQLException e){
             System.out.println(e.getMessage());
        }finally{
            conexao.releaseAll(con, stmt, rs);
        }
	
	return rs;
        
	}
       
}
	

