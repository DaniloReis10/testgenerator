package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DisciplinaDao;
import dao.TopicoDao;
import entities.Disciplina;
import entities.Topico;

@WebServlet("/topico/adicionar")
public class AdicionarTopicoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Processa as requisi��es GET da p�gina
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// carregando as disciplinas
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		List<Disciplina> disciplinas = daoDisciplina.select(0); // lista todas as disciplinas
		
		// s� exibe a p�gina de cadastramento de t�picos se existir pelo menos uma disciplina
		if (disciplinas.size() > 0)
		{
			request.setAttribute("disciplinas", disciplinas);
			getServletConfig().getServletContext()
				.getRequestDispatcher("/topico/adicionar.jsp")
				.forward(request, response);
		}else
		{
			HttpSession session = request.getSession(false);
			session.setAttribute("erro", "A disciplina selecionada n�o existe mais no banco de dados. Por favor, tente novamente.");
			response.sendRedirect(request.getContextPath() + "/topico/adicionar");
		}
		
	}

	/**
	 * Processa as requisi�oes POST da p�gina
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String disciplinaId = request.getParameter("inputDisciplina");
		String topicoNome = request.getParameter("inputNome");
		
		TopicoDao daoTopico = new TopicoDao();
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		// buscando a disciplina
		List<Disciplina> disciplinaCheck = daoDisciplina.select(Integer.parseInt(disciplinaId));
		if (disciplinaCheck.size() > 0)
		{
			// verificando se o t�pico j� est� cadastrado no banco de dados
			List<Topico> topicoCheck = daoTopico.select(disciplinaCheck.get(0), "TopicoNome", topicoNome);
			if (topicoCheck.size() <= 0)
			{ // caso n�o exista nenhum t�pico com o mesmo nome na mesma disciplina...
				Topico topico = new Topico();
				topico.setDisciplinaID(Integer.parseInt(disciplinaId));
				topico.setTopicoNome(topicoNome);
				
				if (daoTopico.insert(topico))
				{ // insere o t�pico e redireciona para a p�gina
					session.setAttribute("sucesso", "T�pico adicionado.");
					response.sendRedirect(request.getContextPath() + "/topico");
				}else
				{ // caso n�o consiga, retorna o erro e redireciona para a p�gina
					session.setAttribute("erro", "Ocorreu um erro interno ao tentar adicionar o t�pico. Por favor, tente novamente.");
					response.sendRedirect(request.getContextPath() + "/topico/adicionar");
				}
			}else
			{ // caso j� exista, redireciona para a p�gina
				session.setAttribute("erro", "J� existe um t�pico com este nome para esta disciplina. Por favor, tente novamente.");
				response.sendRedirect(request.getContextPath() + "/topico/adicionar");
			}
		}else
		{ // caso a disciplina selecionada n�o exista mais
			session.setAttribute("erro", "A disciplina selecionada n�o existe mais no banco de dados. Por favor, tente novamente.");
			response.sendRedirect(request.getContextPath() + "/topico/adicionar");
		}
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		processPostRequest(request, response);
	}
}
