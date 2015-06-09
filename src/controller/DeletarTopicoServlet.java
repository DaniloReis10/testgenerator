package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import dao.TopicoDao;
import entities.Topico;

@WebServlet("/topico/deletar")
public class DeletarTopicoServlet extends HttpServlet
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
		String idTopico = request.getParameter("id");
		TopicoDao daoTopico = new TopicoDao();
		List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
		
		JSONObject json = new JSONObject();
		if (topico.size() > 0)
		{ // caso o tópico exista
			if (daoTopico.delete(topico.get(0))) 
			{ // caso consiga deletar o tópico
				try
				{
					json.accumulate("status", "1");
					json.accumulate("msg", "Registro removido.");
				} catch (JSONException e)
				{
					// nothing to do here...
				}
			}else 
			{ // caso não consiga
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
		{ // caso o tópico não exista
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
