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

	protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		String idTopico = request.getParameter("id");
		TopicoDao daoTopico = new TopicoDao();
		List<Topico> topico = daoTopico.select(Integer.parseInt(idTopico));
		
		JSONObject json = new JSONObject();
		if (topico.size() > 0)
		{
			if (daoTopico.delete(topico.get(0)))
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
