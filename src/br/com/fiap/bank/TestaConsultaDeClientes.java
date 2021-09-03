package br.com.fiap.bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestaConsultaDeClientes extends Object {

	public static void main(String[] args) {

		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement()) {
			
			statement.execute("SELECT * FROM clientes");

			ResultSet resultSet = statement.getResultSet();
			
			String lista = "";
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cpf = resultSet.getString("cpf");
				String email = resultSet.getString("email");
				lista += String.format("%d - %s (%s) - %s \n", id, nome, email, cpf);
			}
			JOptionPane.showMessageDialog(null, lista);
			

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
