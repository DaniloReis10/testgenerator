package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao
{
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	
	/**
	 * Conecta com o banco de dados e retorna a conexão
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException
	{

		Connection conn = null;
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://127.0.1.1/testgenerator", "root", "123456");
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		} 

		return conn;
	}
	
	/**
	 * Executa um update no banco de dados
	 * @param conn
	 * @param query
	 */
	public void executePreparedUpdate(Connection conn, String query)
	{

		try
		{
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			release(pstmt);
		}
	}
	
	/**
	 * Executa um insert no banco de dados
	 * @param conn
	 * @param query
	 */
	public void executePreparedInsert(Connection conn, String query)
	{

		try
		{
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();

		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			release(pstmt);
		}
	}

	public void executePreparedDelete(Connection conn, String query)
	{
		try
		{
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e)
		{
			System.out.println(e.getMessage());
		} finally
		{
			release(pstmt);
			release(conn);
		}

	}
	
	/**
	 * Libera a conexão com o banco de dados
	 * @param stmt
	 */
	public void release(Statement stmt)
	{
		if (stmt == null)
			return;
		try
		{
			stmt.close();
		} catch (SQLException e)
		{
		}
	}
	
	/**
	 * Libera a conexão com o banco de dados
	 * @param conn
	 */
	public void release(Connection conn)
	{

		if (conn == null)
			return;
		try
		{
			conn.close();
		} catch (SQLException e)
		{
		}

	}
	
	/**
	 * Libera a conexão com o banco de dados
	 * @param rset
	 */
	public void release(ResultSet rset)
	{
		if (rset == null)
			return;
		try
		{
			rset.close();
		} catch (SQLException e)
		{
		}
	}
	
	/**
	 * Libera a conexão com o banco de dados
	 * @param conn
	 * @param stmt
	 */
	public void releaseAll(Connection conn, Statement stmt)
	{
		release(stmt);
		release(conn);
	}
	
	/**
	 * Libera a conexão com o banco de dados
	 * @param conn
	 * @param stmt
	 * @param rset
	 */
	public void releaseAll(Connection conn, Statement stmt, ResultSet rset)
	{
		release(rset);
		releaseAll(conn, stmt);
	}
}
