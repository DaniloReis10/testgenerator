package Testes;

import java.util.List;

import javabeans.Topico;
import DAO.TopicoDAO;

public class TesteDAO {
	
	public static void main(String[] args) {
//		Topico top = new Topico(0, null, 0);
		TopicoDAO tdao = new TopicoDAO();
		
		List<Topico> listaResultado = tdao.buscarLista();
		
		for(Topico t: listaResultado){
			if(t.getDisciplina_idDisciplina() == 1){
				System.out.println("Nome:"+t.getNome());
			}
			
		}
		
	}
	
	

}
