package entities;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Topico
{
	private int ID;
	private int DisciplinaID;
	private String DisciplinaNome;
	private String TopicoNome;
	
	public Topico()
	{
		
	}
	
	public Topico(int iD, int disciplinaID, String topicoNome)
	{
		ID = iD;
		DisciplinaID = disciplinaID;
		TopicoNome = topicoNome;
	}
	
	public Topico(int iD, int disciplinaID, String topicoNome, String disciplinaNome)
	{
		ID = iD;
		DisciplinaID = disciplinaID;
		TopicoNome = topicoNome;
		DisciplinaNome = disciplinaNome;
	}
	
	public int getID()
	{
		return ID;
	}
	public void setID(int iD)
	{
		ID = iD;
	}
	public int getDisciplinaID()
	{
		return DisciplinaID;
	}
	public void setDisciplinaID(int disciplinaID)
	{
		DisciplinaID = disciplinaID;
	}
	public String getTopicoNome()
	{
		return TopicoNome;
	}
	public void setTopicoNome(String topicoNome)
	{
		TopicoNome = topicoNome;
	}

	public String getDisciplinaNome()
	{
		return DisciplinaNome;
	}

	public void setDisciplinaNome(String disciplinaNome)
	{
		DisciplinaNome = disciplinaNome;
	}
	
	
}