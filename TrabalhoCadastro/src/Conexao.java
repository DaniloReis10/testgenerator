import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	/**
	 * Fornecer conexao ao banco de dados
	 * 
	 * @return Connection
	 * @throws java.sql.SQLException
	 */

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private final String DRIVER = "com.mysql.jdbc.Driver";
	public Connection getConnection() throws SQLException {

		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cadastro", "root", "123456");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return conn;

	}

	public void executePreparedUpdate(Connection conn, String query,
			String tabela, Object... params) {

		try {
				pstmt = conn.prepareStatement(query);
				int i = 0;
				for (Object param : params) {
					pstmt.setObject(++i, param);
				}
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			release(pstmt);
		}
	}

	public void executePreparedInsert(Connection conn, String query,
			Object... params) {

		try {
			pstmt = conn.prepareStatement(query);
			int i = 0;
			for (Object param : params) {
				pstmt.setObject(++i, param);
			}
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			release(pstmt);
		}
	}


	public void executePreparedDelete(Connection conn, long id, String tabela) {

		final String query = "delete from " + tabela
				+ " where ID = " + id;

		try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			release(pstmt);
			release(conn);
		}

	}

	public void release(Statement stmt) {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException e) {
		}
	}

	public void release(Connection conn) {

		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
		}

	}

	public void release(ResultSet rset) {
		if (rset == null)
			return;
		try {
			rset.close();
		} catch (SQLException e) {
		}
	}

	public void releaseAll(Connection conn, Statement stmt) {
		release(stmt);
		release(conn);
	}

	public void releaseAll(Connection conn, Statement stmt, ResultSet rset) {
		release(rset);
		releaseAll(conn, stmt);
	}

}