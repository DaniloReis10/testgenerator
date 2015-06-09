package servletcontrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javabeans.QuestaoDissertativa;
import javabeans.QuestaoObjetiva;
import javabeans.QuestaoVF;
import javabeans.Topico;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.QuestaoDAO;
import DAO.TopicoDAO;

/**
 * Classe controladora para geraçao das provas, recebe os dados da jsp gerar.jsp executa os metodos da persistencia, e envia os dados para recebedados.jsp
 */

/**
 * Servlet implementation class ControladorProva
 */
@WebServlet("/ControladorProva")
public class ControladorProva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questoes = request.getParameter("quantidadeQuestoes");
		String nomeTopico = request.getParameter("topicos");
		String tipoQuestao = request.getParameter("tipos");
		
		QuestaoDAO questaoDAO = new QuestaoDAO();
		Integer questoesInteiro = Integer.parseInt(questoes);
		
		TopicoDAO t = new TopicoDAO();
		
		int numero = t.buscarId(nomeTopico);
		
		request.setAttribute("numero", numero);
		
		PrintWriter out = response.getWriter();
		
		
		
			List<Topico> listaTeste = t.buscarLista();
			request.setAttribute("listaTeste", listaTeste);
		
			
			List<QuestaoDissertativa> listaDiss = questaoDAO.buscarQuestaoDissertativa();
			List<QuestaoObjetiva> listaObj = questaoDAO.buscarQuestaoObjetiva();
			List<QuestaoVF> listaVF = questaoDAO.buscarQuestaoVF();
		
			request.setAttribute("listaDiss", listaDiss);
			request.setAttribute("listaObj", listaObj);
			request.setAttribute("listaVF", listaVF);		
		
		
			request.setAttribute("questoesInteiro", questoesInteiro);
			request.setAttribute("tipoQuestao", tipoQuestao);
			
			
			RequestDispatcher saida = request.getRequestDispatcher("RecebeDados.jsp");
			saida.forward(request, response);
			
		
		
		
		
		
		
	}

}
