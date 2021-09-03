package br.com.fiap.bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class TestaCadastroDeCliente {
	
	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectionFactory.getConnection(); 
			JOptionPane.showMessageDialog(null, "Conectado com sucesso");
			
			String nome = JOptionPane.showInputDialog("Nome: ");
			String cpf = JOptionPane.showInputDialog("CPF: ");
			String email = JOptionPane.showInputDialog("E-mail: ");
			
			Statement statement = connection.createStatement(); 
			
			String sql = String.format(
					"INSERT INTO clientes (nome, cpf, email) VALUES ('%s', '%s', '%s')", 
					nome,
					cpf,
					email
				);
			
			System.out.println(sql);
			
			statement.execute(sql);
			
			connection.close();
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(
					null, 
					"Erro ao conectar: " +
					e.getMessage()
					);
			e.printStackTrace();
		}
		

		
		
	}

}
