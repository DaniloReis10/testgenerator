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
	
	/**
	 * Processa as requisi��es GET da p�gina
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("utf-8");
		
		String idTopico = request.getParameter("id");
		if (idTopico != null)
		{ // caso o ID do t�pico n�o seja nulo...
			TopicoDao daoTopico = new TopicoDao(); 
			List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
			
			if (topico.size() > 0)
			{ // caso encontre o t�pico
				DisciplinaDao daoDisciplina = new DisciplinaDao();
				List<Disciplina> disciplinas = daoDisciplina.select(0);
				
				request.setAttribute("disciplinas", disciplinas);
				request.setAttribute("topico", topico.get(0));
				
				getServletConfig().getServletContext()
						.getRequestDispatcher("/topico/editar.jsp")
						.forward(request, response);  // redireciona para a p�gina
			}else
			{ // caso n�o encontre, retorna o erro
				session.setAttribute("erro", "T�pico n�o encontrado.");
				response.sendRedirect(request.getContextPath() + "/topico"); // redireciona para a p�gina
			}
		}else
		{ // caso o ID do t�pico seja nulo
			session.setAttribute("erro", "T�pico n�o encontrado.");
			response.sendRedirect(request.getContextPath() + "/topico");  // redireciona para a p�gina
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
		String idTopico = request.getParameter("id");
		
		TopicoDao daoTopico = new TopicoDao();
		List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
		
		if (topico.size() > 0)
		{ // caso o t�pico exista
			String disciplinaId = request.getParameter("inputDisciplina");
			String topicoNome = request.getParameter("inputNome");
			
			topico.get(0).setDisciplinaID(Integer.parseInt(disciplinaId));
			topico.get(0).setTopicoNome(topicoNome);
			
			HttpSession session = request.getSession(false);
			if (daoTopico.update(topico.get(0))) // tenta atualizar o registro
			{
				session.setAttribute("sucesso", "T�pico editado.");
			}else
			{ // se n�o conseguir, retorna o erro
				session.setAttribute("erro", "Ocorreu um erro interno ao tentar editar o t�pico. Por favor, tente novamente.");
			}
			
			response.sendRedirect(request.getContextPath() + "/topico");  // redireciona para a p�gina
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
