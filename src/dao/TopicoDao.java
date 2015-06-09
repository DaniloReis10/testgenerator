package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Disciplina;
import entities.Topico;

public class TopicoDao
{
	private Conexao conexao;
	
	public TopicoDao()
	{
		conexao = new Conexao();
	}
	
	/**
	 * Lista os tópicos de acordo com o ID enviado. Id = 0 -> lista todos
	 * @param id ID do tópico
	 * @return List<Topico>
	 */
	public List<Topico> select(int id)
	{
		List<Topico> topicos = new ArrayList<Topico>();
		
		String sqlSelect = "SELECT topico.*, disciplina.DisciplinaNome FROM topico LEFT JOIN disciplina ON topico.DisciplinaId = disciplina.ID";
		if (id > 0)
			sqlSelect += " WHERE topico.ID = " + id;
		sqlSelect += " ORDER BY disciplina.DisciplinaNome ASC, topico.TopicoNome ASC";
		try
		{
			Statement stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next())
			{
				Topico newTopico = new Topico(rs.getInt("ID"), rs.getInt("DisciplinaId"), rs.getString("TopicoNome"), rs.getString("DisciplinaNome"));
				topicos.add(newTopico);
			}
		}catch (SQLException ex)
		{
			// nothing to do here :(
		}
		
		return topicos;
	}
	
	/**
	 * Lista os tópicos de acordo com a disciplina enviada. Disciplina = null -> lista todos os tópicos
	 * @param disciplina Objeto com a disciplina desejada 
	 * @return List<Topico>
	 */
	public List<Topico> select(Disciplina disciplina)
	{
		List<Topico> topicos = new ArrayList<Topico>();
		
		String sqlSelect = "SELECT topico.*, disciplina.DisciplinaNome FROM topico LEFT JOIN disciplina ON topico.DisciplinaId = disciplina.ID";
		if (disciplina != null)
			sqlSelect += " WHERE topico.DisciplinaId = " + disciplina.getID();
		
		sqlSelect += " ORDER BY topico.id ASC";
		try
		{
			Statement stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next())
			{
				Topico newTopico = new Topico(rs.getInt("ID"), rs.getInt("DisciplinaId"), rs.getString("TopicoNome"), rs.getString("DisciplinaNome"));
				topicos.add(newTopico);
			}
		}catch (SQLException ex)
		{
			// nothing to do here :(
		}
		
		return topicos;
	}
	
	/**
	 * 
	 * @param disciplina Objeto com a disciplina desejada
	 * @param whereField Campo de busca
	 * @param whereClause Valor do campo de busca
	 * @return List<Topico>
	 */
	public List<Topico> select(Disciplina disciplina, String whereField, String whereClause)
	{
		List<Topico> topicos = new ArrayList<Topico>();
		
		String sqlSelect = "SELECT topico.*, disciplina.DisciplinaNome FROM topico LEFT JOIN disciplina ON topico.DisciplinaId = disciplina.ID";
		sqlSelect += " WHERE topico.DisciplinaId = " + disciplina.getID() + " AND " + whereField + " = '" + whereClause + "'";
		
		sqlSelect += " ORDER BY topico.id ASC";
		try
		{
			Statement stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next())
			{
				Topico newTopico = new Topico(rs.getInt("ID"), rs.getInt("DisciplinaId"), rs.getString("TopicoNome"), rs.getString("DisciplinaNome"));
				topicos.add(newTopico);
			}
		}catch (SQLException ex)
		{
			// nothing to do here :(
		}
		
		return topicos;
	}
	
	/**
	 * Insere um tópico no banco de dados
	 * @param topico
	 * @return boolean
	 */
	public boolean insert(Topico topico)
	{
		try
		{
			String sqlInsert = "INSERT INTO topico (DisciplinaId, TopicoNome) VALUES (" + topico.getDisciplinaID() + ", '" + topico.getTopicoNome() + "')";
			conexao.executePreparedInsert(this.conexao.getConnection(), sqlInsert);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
	
	/**
	 * Atualiza um registro tópico no banco de dados
	 * @param topico
	 * @return boolean
	 */
	public boolean update(Topico topico)
	{
		try
		{
			String sqlUpdate = "UPDATE topico SET DisciplinaId = " + topico.getDisciplinaID() + ", TopicoNome = '" + topico.getTopicoNome() + "' WHERE id =" + topico.getID();
			conexao.executePreparedUpdate(this.conexao.getConnection(), sqlUpdate);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
	
	/**
	 * Deleta um registro tópico de acordo com o objeto enviado
	 * @param topico
	 * @return boolean
	 */
	public boolean delete(Topico topico)
	{
		try
		{
			String sqlDelete = "DELETE FROM topico WHERE ID = " + topico.getID();
			conexao.executePreparedDelete(this.conexao.getConnection(), sqlDelete);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
	
	/**
	 * Deleta todos os tópicos de acordo com a disciplina enviada
	 * @param disciplina
	 * @return boolean
	 */
	public boolean delete(Disciplina disciplina)
	{
		try
		{
			String sqlDelete = "DELETE FROM topico WHERE DisciplinaId = " + disciplina.getID();
			conexao.executePreparedDelete(this.conexao.getConnection(), sqlDelete);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
}