package br.com.menu.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		//Metódo GetConnection - Não irá tratar erros.
		try {
			//Indica o DB MySQL e aponta para o Driver.
			Class.forName("com.mysql.jdbc.Driver");
			//Conexão com o DB.
			String login = "root"; //Login do DB
			String senha = "";  //Senha do DB em branco, para facilitar o acesso
			String url = "jdbc:mysql://localhost/dbuniversidade?characterEncoding=UTF-8";  //Acrescenta o conjunto de caracteres a URL de conexão
			return DriverManager.getConnection(url,login,senha);  //aponta o Driver para a Url utilizando o login e a senha informados.
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro na conexão");  //Apresenta o Erro caso haja algum problema na conexão do banco de dados
		}
	}

	// fecha uma conexão de três formas: conn, stmt, rs

	public static void closeConnection(Connection conn, Statement stmt,
			ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt)
			throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs)
			throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}


