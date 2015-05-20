package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prova;
import dao.ProvaDAO;

@WebServlet(urlPatterns = "/excluir")
public class ExcluirProva extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("prova");
		Prova prova = new Prova();
		prova.setId(Integer.parseInt(id));
		new ProvaDAO().deletar(prova);
		resp.sendRedirect("index.jsp");
	}
	
}
