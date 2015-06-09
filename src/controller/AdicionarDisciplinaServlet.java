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
	
	/**
	 * Processa as requisições GET da página
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		getServletConfig().getServletContext()
		.getRequestDispatcher("/disciplina/adicionar.jsp")
		.forward(request, response);
	}
	
	/**
	 * Processa as requisiçoes POST da página
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String disciplinaNome = request.getParameter("inputNome");
		
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		// verificando se a disciplina já existe no banco de dados
		List<Disciplina> disciplinaCheck = daoDisciplina.select("DisciplinaNome", disciplinaNome);
		
		if (disciplinaCheck.size() <= 0)
		{
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplinaNome(disciplinaNome);
			
			// tentando inserir a disciplina
			if (daoDisciplina.insert(disciplina))
			{
				session.setAttribute("sucesso", "Disciplina adicionada.");
			}else
			{ // caso não consiga, retorna um erro
				session.setAttribute("erro", "Ocorreu um erro interno ao tentar adicionar a disciplina. Por favor, tente novamente.");
			}
			
			// redireciona para a página
			response.sendRedirect(request.getContextPath() + "/disciplina");
		}else
		{ // caso exista uma disciplina, redireciona para a página
			session.setAttribute("erro", "Já existe uma disciplina cadastrada com este nome no banco de dados. Por favor, tente novamente.");
			response.sendRedirect(request.getContextPath() + "/disciplina/adicionar");
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
