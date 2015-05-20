package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Conexao;

public class AlunoDAO {

	private Conexao conexao = null;
        
        private Connection con = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        private final String tabela = "alunos";
        
	public AlunoDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Aluno aluno) {
		
		try {
                    con = new Conexao().getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (nome, matricula) values (?, ?)"
                                                  , aluno.getNome()
                                                  , aluno.getMatricula()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Aluno aluno){
		
		final String query = "update "+tabela+" set nome = ?, matricula = ? where ID = ? ";
		
                
		try {
                        con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, aluno.getNome()
														, aluno.getMatricula()
                                                        , aluno.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Aluno prova){
             
           try {
               con = conexao.getConnection();
               conexao.executePreparedDelete(con, prova.getId(),tabela);
                                             
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
	

