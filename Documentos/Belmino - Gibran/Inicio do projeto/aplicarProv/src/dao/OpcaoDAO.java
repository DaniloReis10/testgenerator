package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Conexao;
import model.Opcao;

public class OpcaoDAO {

	private Conexao conexao = null;
        
        private Connection con = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        private final String tabela = "opcoes";
        
	public OpcaoDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Opcao opcao) {
		
		try {
                    con = conexao.getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (enunciado, id_questao, resposta, status) values (?, ?, ?, ?)"
                                                  , opcao.getEnunciado()
                                                  , opcao.getId_questao()
                                                  , opcao.getResposta()
                                                  , opcao.getStatus()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Opcao opcao){
		
		final String query = "update "+tabela+" set enunciado = ?, id_questao = ?, resposta = ?, status = ? where ID = ? ";
		
                
		try {
                        con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, opcao.getEnunciado()
                                                        , opcao.getId_questao()
                                                        , opcao.getResposta()
                                                        , opcao.getStatus()
                                                        , opcao.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Opcao opcao){
             
           try {
               con = conexao.getConnection();
               conexao.executePreparedDelete(con, opcao.getId(),tabela);
                                             
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
	
        public ResultSet getOpcoes() {
	
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
	

