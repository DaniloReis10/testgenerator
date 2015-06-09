package entities;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Disciplina
{
	private int ID;
	private String DisciplinaNome;
	
	/**
	 * Inst�ncia de um novo objeto disciplina
	 */
	public Disciplina()
	{
		
	}
	
	/**
	 * Inst�ncia de um novo objeto disciplina
	 * @param ID
	 * @param disciplinaNome
	 */
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