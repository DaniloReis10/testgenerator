package servletcontrol;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DisciplinaDAO;
import DAO.TopicoDAO;

/**
 * Servlet implementation class ControladorDisciplina
 */
@WebServlet("/ControladorDisciplina")
public class ControladorDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("disciplina");
		PrintWriter out = response.getWriter();
		
		DisciplinaDAO dDAO = new DisciplinaDAO();
		TopicoDAO tDAO = new TopicoDAO();
				
		int resp = dDAO.buscarDisciplina(s);
		
		if(resp == 0){
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<H1>ERRO!! DISCIPLINA NAO ENCONTRADA!!</H1>");
			out.print("<a href='gerar.jsp'>< Voltar</a>");
			out.print("</BODY>");
			out.print("</HTML>");
			
		}
		
		
		
		
	}

}
