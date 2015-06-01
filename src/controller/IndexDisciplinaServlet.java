package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DisciplinaDao;

@WebServlet("/disciplina")
public class IndexDisciplinaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		request.setAttribute("disciplinas", daoDisciplina.select(0));
		getServletConfig().getServletContext()
				.getRequestDispatcher("/disciplina/index.jsp")
				.forward(request, response);
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
