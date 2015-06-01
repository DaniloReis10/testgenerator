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

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// carregando as disciplinas
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		List<Disciplina> disciplinas = daoDisciplina.select(0);
		
		request.setAttribute("disciplinas", disciplinas);
		getServletConfig().getServletContext()
			.getRequestDispatcher("/topico/adicionar.jsp")
			.forward(request, response);
	}

	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String disciplinaId = request.getParameter("inputDisciplina");
		String topicoNome = request.getParameter("inputNome");
		
		Topico topico = new Topico();
		topico.setDisciplinaID(Integer.parseInt(disciplinaId));
		topico.setTopicoNome(topicoNome);
		
		TopicoDao daoTopico = new TopicoDao();
		if (daoTopico.insert(topico))
		{
			session.setAttribute("sucesso", "Tópico adicionado.");
		}else
		{
			session.setAttribute("erro", "Ocorreu um erro interno ao tentar adicionar o tópico. Por favor, tente novamente.");
		}
		
		response.sendRedirect(request.getContextPath() + "/topico");
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
