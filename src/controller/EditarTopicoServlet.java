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

@WebServlet("/topico/editar")
public class EditarTopicoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String idTopico = request.getParameter("id");
		if (idTopico != null)
		{
			TopicoDao daoTopico = new TopicoDao();
			List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
			
			if (topico.size() > 0)
			{
				DisciplinaDao daoDisciplina = new DisciplinaDao();
				List<Disciplina> disciplinas = daoDisciplina.select(0);
				
				request.setAttribute("disciplinas", disciplinas);
				request.setAttribute("topico", topico);
				
				getServletConfig().getServletContext()
						.getRequestDispatcher("/topico/editar.jsp")
						.forward(request, response);
			}else
			{
				session.setAttribute("erro", "Tópico não encontrado.");
				response.sendRedirect(request.getContextPath() + "/topico");
			}
		}else
		{
			session.setAttribute("erro", "Tópico não encontrado.");
			response.sendRedirect(request.getContextPath() + "/topico");
		}
		
	}
	
	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idTopico = request.getParameter("id");
		
		TopicoDao daoTopico = new TopicoDao();
		List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
		
		if (topico.size() > 0)
		{
			String disciplinaId = request.getParameter("inputDisciplina");
			String topicoNome = request.getParameter("inputNome");
			
			topico.get(0).setDisciplinaID(Integer.parseInt(disciplinaId));
			topico.get(0).setTopicoNome(topicoNome);
			
			HttpSession session = request.getSession(false);
			if (daoTopico.update(topico.get(0)))
			{
				session.setAttribute("sucesso", "Tópico editado.");
			}else
			{
				session.setAttribute("erro", "Ocorreu um erro interno ao tentar editar o tópico. Por favor, tente novamente.");
			}
			
			response.sendRedirect(request.getContextPath() + "/topico");
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
