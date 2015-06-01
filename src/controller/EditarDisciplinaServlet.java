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

@WebServlet("/disciplina/editar")
public class EditarDisciplinaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String idDisciplina = request.getParameter("id");
		if (idDisciplina != null)
		{
			DisciplinaDao daoDisciplina = new DisciplinaDao();
			List<Disciplina> disciplina = daoDisciplina.select(Integer.parseInt(idDisciplina));
			
			if (disciplina.size() > 0)
			{
				request.setAttribute("disciplina", disciplina);
				getServletConfig().getServletContext()
						.getRequestDispatcher("/disciplina/editar.jsp")
						.forward(request, response);
			}else
			{
				session.setAttribute("erro", "Disciplina não encontrada.");
				response.sendRedirect(request.getContextPath() + "/disciplina");
			}
		}else
		{
			session.setAttribute("erro", "Disciplina não encontrada.");
			response.sendRedirect(request.getContextPath() + "/disciplina");
		}
		
	}
	
	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idDisciplina = request.getParameter("id");
		
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		List<Disciplina> disciplina = daoDisciplina.select(Integer.parseInt(idDisciplina));
		
		if (disciplina.size() > 0)
		{
			String disciplinaNome = request.getParameter("inputNome");
			disciplina.get(0).setDisciplinaNome(disciplinaNome);
			
			HttpSession session = request.getSession(false);
			if (daoDisciplina.update(disciplina.get(0)))
			{
				session.setAttribute("sucesso", "Disciplina editada.");
			}else
			{
				session.setAttribute("erro", "Ocorreu um erro interno ao tentar editar a disciplina. Por favor, tente novamente.");
			}
			
			response.sendRedirect(request.getContextPath() + "/disciplina");
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processPostRequest(request, response);
    }
}
