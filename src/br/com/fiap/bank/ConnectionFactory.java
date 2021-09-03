package br.com.fiap.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fábrica de conexao com banco de dados.
 * 
 * @author João Carlos Lima
 * @version 1.0
 *
 */
public class ConnectionFactory {
	
	
	/**
	 * Método que retorna uma conexao com o BD
	 *
	 * @return Connection - conexao com o BD
	 * @throws SQLException - caso não for possível estabelecer uma conexao
	 */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		url = "jdbc:mysql://localhost:3306/fiapbank"; 
		String username = "root";
		String password = "";
		
		Connection connection = DriverManager.getConnection(url, username, password); 
		
		return connection;
		
	}
	

}
