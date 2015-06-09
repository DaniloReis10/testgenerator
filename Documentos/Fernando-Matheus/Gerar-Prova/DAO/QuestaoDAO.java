package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.QuestaoDissertativa;
import javabeans.QuestaoObjetiva;
import javabeans.QuestaoVF;
import conexao.Conexao;

/**
 * QuestaoDAO é a classe responsavel pelos metodos da persistencia da classe questao, para obter alguns dados do banco, nome, chave primaria, chave estrangeira entre outros.
 * @author Fernando Matheus
 *
 */

public class QuestaoDAO {
	
	private Connection con = Conexao.getConnection();
	
	public List<QuestaoDissertativa> buscarQuestaoDissertativa(){
		String sql = "SELECT * FROM questaodissertativa";
		
		List<QuestaoDissertativa> listaDissertativa = new ArrayList<QuestaoDissertativa>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery(); 
			
			while(resultados.next()){
				String sPergunta = resultados.getString("pergunta");
				String sResposta = resultados.getString("resposta");
				int sid = resultados.getInt("Topico_idTopico");
				QuestaoDissertativa qD = new QuestaoDissertativa(sPergunta, sResposta, sid);
				listaDissertativa.add(qD);
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}return listaDissertativa;
		
}
	
	public List<QuestaoObjetiva> buscarQuestaoObjetiva(){
		String sql = "SELECT * FROM questaoobjetiva";
		
		List<QuestaoObjetiva> listaObjetiva = new ArrayList<QuestaoObjetiva>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery(); 
			
			while(resultados.next()){
				String sPerguntaO = resultados.getString("pergunta");
				String sItemA = resultados.getString("item_a");
				String sItemB = resultados.getString("item_b");
				String sItemC = resultados.getString("item_c");
				String sItemD = resultados.getString("item_d");
				String sRespostaO = resultados.getString("resposta");
				int sid = resultados.getInt("Topico_idTopico");
				QuestaoObjetiva qO = new QuestaoObjetiva(sPerguntaO, sItemA, sItemB, sItemC, sItemD, sRespostaO, sid);
				listaObjetiva.add(qO);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}return listaObjetiva;
		
		
	}
	
	public List<QuestaoVF> buscarQuestaoVF(){
		String sql = "SELECT * FROM questaovf";
		
		List<QuestaoVF> listaVF = new ArrayList<QuestaoVF>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultados = stmt.executeQuery(); 
			
			while(resultados.next()){
				String sPergunta = resultados.getString("pergunta");
				String sItem1_VF = resultados.getString("item_1_VF");
				String sItem2_VF = resultados.getString("item_2_VF");
				String sItem3_VF = resultados.getString("item_3_VF");
				String sItem4_VF = resultados.getString("item_4_VF");
				String sResposta1 = resultados.getString("resposta_1");
				String sResposta2 = resultados.getString("resposta_2");
				String sResposta3 = resultados.getString("resposta_3");
				String sResposta4 = resultados.getString("resposta_4");
				int sid = resultados.getInt("Topico_idTopico");
				QuestaoVF qVF = new QuestaoVF(sPergunta, sItem1_VF, sItem2_VF, sItem3_VF, sItem4_VF,
						sResposta1, sResposta2, sResposta3, sResposta4, sid);
				listaVF.add(qVF);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+e.getMessage());
		}return listaVF;
		
		
	}
	
	
	
	

}
