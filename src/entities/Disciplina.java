package entities;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Disciplina
{
	private int ID;
	private String DisciplinaNome;
	
	public Disciplina()
	{
		
	}
	
	public Disciplina(int ID, String disciplinaNome)
	{
		this.ID = ID;
		this.DisciplinaNome = disciplinaNome;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
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