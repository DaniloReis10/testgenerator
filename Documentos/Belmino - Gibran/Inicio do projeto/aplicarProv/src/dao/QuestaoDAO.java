package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conexao;
import model.Opcao;
import model.Questao;

public class QuestaoDAO {

	private Conexao conexao = null;
        
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Statement stmt2 = null;
    private ResultSet rs2 = null;
    private final String tabela = "questoes";
        
	public QuestaoDAO () {
		conexao = new Conexao();
	}
	
	
       public void inserir (Questao questao) {
		
		try {
                    con = conexao.getConnection();
                    conexao.executePreparedInsert(con
                                                  ,"insert into "+tabela+" (enunciado, tipo, id_topico) values (?, ?, ?)"
                                                  , questao.getEnunciado()
                                                  , questao.getTipo().toString()
                                                  , questao.getId_topico()
                                                  );
			
			
			conexao.release(con);
                        
		} catch (SQLException e) {
			
		 System.out.println("Erro: "+e.getMessage());
			
		} 
		
	}
	
	

	
	public void atualizar (Questao questao){
		
		final String query = "update "+tabela+" set enunciado = ?, tipo = ?, id_topico = ? where ID = ? ";
		
                
		try {
                        con = conexao.getConnection();
			conexao.executePreparedUpdate(con, query, tabela, questao.getEnunciado()
                                                        , questao.getTipo()
                                                        , questao.getId_topico()
                                                        , questao.getId()
                                                        );

			conexao.release(con);
		} catch (SQLException e) {
			System.out.println("Erro: "+e.getMessage());
		}
                
        }
        
        
        public void deletar (Questao questao){
             
           try {
               con = conexao.getConnection();
               conexao.executePreparedDelete(con, questao.getId(),tabela);
                                             
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
	
         public List<Questao> getQuestoes(int prova) {
        		
             final String query = "select q.id, q.enunciado, q.tipo from provas_questoes pq "+
             					"left outer join questoes q on q.id = pq.id_questao "+
             					" where pq.id_prova = "+String.valueOf(prova);
             List<Questao> questoes = new ArrayList<Questao>();
             try{
             	Questao questao = null;
             	con = conexao.getConnection();
             	stmt = con.createStatement();
             	rs = stmt.executeQuery(query);
                             
             	while(rs.next()){
             		Integer id = rs.getInt("id");
             		String enunciado = rs.getString("enunciado");
             		String tipo = rs.getString("tipo");
             		
             		final String query2 = "select o.id, o.enunciado from opcoes o "+
             				 			"where o.id_questao = "+String.valueOf(id);
             		 
             		List<Opcao> opcoes = new ArrayList<Opcao>();
             		
             		Opcao opcao = null;
                 	stmt2 = con.createStatement();
                 	rs2 = stmt2.executeQuery(query2);
             		
                 	while(rs2.next()){
                 		Integer id2 = rs2.getInt("id");
                 		String enunciado2 = rs2.getString("enunciado");
                 		
                 		opcao = new Opcao();
                 		
                 		opcao.setId(id2);
                 		opcao.setEnunciado(enunciado2);
                 		opcoes.add(opcao);
                 	}
             		
             		questao = new Questao();
             		
             		questao.setId(id);
             		questao.setEnunciado(enunciado);
             		questao.setTipo(tipo);
             		questao.setOpcoes(opcoes);
             		
             		questoes.add(questao);
             				
             	}
                            
     	}catch(SQLException e){
                  System.out.println(e.getMessage());
             }finally{
                 conexao.releaseAll(con, stmt, rs);
             }
     	
     	return questoes;
             
     	}
       
}
	

