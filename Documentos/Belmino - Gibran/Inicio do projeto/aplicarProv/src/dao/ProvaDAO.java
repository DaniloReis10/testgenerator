package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conexao;
import model.Prova;

public class ProvaDAO {

	private Conexao conexao = null;
        
        private Connection con = null;
        private Statement stmt = null;
        private ResultSet rs = null;
        private final String tabela = "provas";
        
	public ProvaDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Prova prova) {
		
		try {
                    con = conexao.getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (nome) values (?)"
                                                  , prova.getNome()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Prova prova){
		
		final String query = "update "+tabela+" set nome = ? where ID = ? ";
		
                
		try {
            con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, prova.getNome()
                                                        , prova.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Prova prova){
             
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
	
         public List<Prova> getProvas() {
        		
             final String query = "select p.id, p.nome, d.nome as disciplina, count(pq.id) as qtd from provas p "+
             					"left outer join provas_questoes pq on pq.id_prova = p.id "+
             					"left outer join disciplinas d on d.id = p.id_disciplina "+
             					"group by p.id;";
             List<Prova> provas = new ArrayList<Prova>();
             try{
             	Prova prova = null;
             	con = conexao.getConnection();
             	stmt = con.createStatement();
             	rs = stmt.executeQuery(query);
             	
             	while(rs.next()){
             		Integer id = rs.getInt("id");
             		String nome = rs.getString("nome");
             		String disciplina = rs.getString("disciplina");
             		Integer qtd = rs.getInt("qtd");
             		
             		prova = new Prova();
             		
             		prova.setId(id);
             		prova.setNome(nome);
             		prova.setDisciplina(disciplina);
             		prova.setQtdQuestoes(qtd);
             		
             		provas.add(prova);
             				
             	}
             	
                             
                            
             }catch(SQLException e){
                  System.out.println(e.getMessage());
     	    }finally{
     	        conexao.releaseAll(con, stmt, rs);
     	    }
             return provas;
     	
             
     	}
       
}
	

