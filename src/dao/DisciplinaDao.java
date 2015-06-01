package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Disciplina;

public class DisciplinaDao
{
	private Conexao conexao;
	public DisciplinaDao()
	{
		conexao = new Conexao();
	}
	
	public List<Disciplina> select(int id)
	{
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		String sqlSelect = "SELECT * FROM disciplina";
		if (id > 0)
			sqlSelect += " WHERE ID = " + id;
		try
		{
			Statement stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			
			while (rs.next())
			{
				Disciplina newDisciplina = new Disciplina(rs.getInt("ID"), rs.getString("DisciplinaNome"));
				disciplinas.add(newDisciplina);
			}
		}catch (SQLException ex)
		{
			// nothing to do here :(
		}
		
		return disciplinas;
	}
	
	public boolean insert(Disciplina disciplina)
	{
		try
		{
			String sqlInsert = "INSERT INTO disciplina (DisciplinaNome) VALUES ('" + disciplina.getDisciplinaNome() + "')";
			conexao.executePreparedInsert(this.conexao.getConnection(), sqlInsert);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
	
	public boolean update(Disciplina disciplina)
	{
		try
		{
			String sqlUpdate = "UPDATE disciplina SET DisciplinaNome = '" + disciplina.getDisciplinaNome() + "' WHERE id =" + disciplina.getID();
			conexao.executePreparedUpdate(this.conexao.getConnection(), sqlUpdate);
			
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
			String sqlDelete = "DELETE FROM disciplina WHERE ID = " + disciplina.getID();
			conexao.executePreparedDelete(this.conexao.getConnection(), sqlDelete);
			
			return true;
		}catch (SQLException e)
		{
			return false;
		}
	}
}