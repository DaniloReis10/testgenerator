package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Conexao;
import model.Topico;

public class TopicoDAO {

	private Conexao conexao = null;
        
        private Connection con = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        private final String tabela = "topicos";
        
	public TopicoDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Topico topico) {
		
		try {
                    con = conexao.getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (nome, id_disciplina) values (?, ?)"
                                                  , topico.getNome()
                                                  , topico.getId_disciplina()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Topico topico){
		
		final String query = "update "+tabela+" set nome = ?, id_disciplina = ? where ID = ? ";
		
                
		try {
                        con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, topico.getNome()
                                                        , topico.getId_disciplina()
                                                        , topico.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Topico topico){
             
           try {
               con = conexao.getConnection();
               conexao.executePreparedDelete(con, topico.getId(),tabela);
                                             
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
	
        public ResultSet getTopicos() {
	
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
	

