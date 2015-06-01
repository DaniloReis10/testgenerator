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
	
	public List<Topico> select(int id)
	{
		List<Topico> topicos = new ArrayList<Topico>();
		
		String sqlSelect = "SELECT topico.*, disciplina.DisciplinaNome FROM topico LEFT JOIN disciplina ON topico.DisciplinaId = disciplina.ID";
		if (id > 0)
			sqlSelect += " WHERE topico.ID = " + id;
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