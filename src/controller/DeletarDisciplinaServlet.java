package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	/**
	 * Processa as requisiçoes POST da página
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idDisciplina = request.getParameter("id");
		DisciplinaDao daoDisciplina = new DisciplinaDao();
		List<Disciplina> disciplina = daoDisciplina.select(Integer.parseInt(idDisciplina));
		
		JSONObject json = new JSONObject();
		if (disciplina.size() > 0)
		{ // caso a disciplina exista...
			// deletando os tópicos
			TopicoDao daoTopico = new TopicoDao();
			daoTopico.delete(disciplina.get(0));
			
			if (daoDisciplina.delete(disciplina.get(0))) // caso consiga deletar a disciplina
			{
				try
				{
					json.accumulate("status", "1");
					json.accumulate("msg", "Registro removido.");
				} catch (JSONException e)
				{
					// nothing to do here...
				}
			}else 
			{ // caso não consiga deletar a disciplina
				try
				{
					json.accumulate("status", "0");
					json.accumulate("msg", "Registro não encontrado.");
				} catch (JSONException e)
				{
					// nothing to do here...
				}
			}
		}else
		{ // caso a disciplina não exista
			try
			{
				json.accumulate("status", "0");
				json.accumulate("msg", "Registro não encontrado.");
			} catch (JSONException e)
			{
				// nothing to do here...
			}
		}
		
		// retorna o json
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
