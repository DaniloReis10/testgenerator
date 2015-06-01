package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import dao.DisciplinaDao;
import dao.TopicoDao;
import entities.Disciplina;

@WebServlet("/disciplina/deletar")
public class DeletarDisciplinaServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		
		String idDisciplina = request.getParameter("id");
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		List<Disciplina> disciplina = daoDisciplina.select(Integer.parseInt(idDisciplina));
		
		JSONObject json = new JSONObject();
		if (disciplina.size() > 0)
		{
			// deletando os tópicos
			TopicoDao daoTopico = new TopicoDao();
			daoTopico.delete(disciplina.get(0));
			
			if (daoDisciplina.delete(disciplina.get(0)))
			{
				try
				{
					json.accumulate("status", "1");
					json.accumulate("msg", "Registro removido.");
				} catch (JSONException e)
				{
					// nothing to do here...
				}
			}
		}else
		{
			try
			{
				json.accumulate("status", "0");
				json.accumulate("msg", "Registro não encontrado.");
			} catch (JSONException e)
			{
				// nothing to do here...
			}
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// nothing to do here...
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processPostRequest(request, response);
	}
}
