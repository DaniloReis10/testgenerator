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
import entities.Disciplina;

@WebServlet("/disciplina/adicionar")
public class AdicionarDisciplinaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		getServletConfig().getServletContext()
		.getRequestDispatcher("/disciplina/adicionar.jsp")
		.forward(request, response);
	}

	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String disciplinaNome = request.getParameter("inputNome");
		Disciplina disciplina = new Disciplina();
		disciplina.setDisciplinaNome(disciplinaNome);
		
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		
		if (daoDisciplina.insert(disciplina))
		{
			session.setAttribute("sucesso", "Disciplina adicionada.");
		}else
		{
			session.setAttribute("erro", "Ocorreu um erro interno ao tentar adicionar a disciplina. Por favor, tente novamente.");
		}
		
		response.sendRedirect(request.getContextPath() + "/disciplina");
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
