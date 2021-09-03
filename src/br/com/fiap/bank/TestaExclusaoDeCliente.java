package br.com.fiap.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.bank.util.Mensagem;

public class TestaExclusaoDeCliente {
	
	public static void main(String[] args) {
		
		try (Connection connection = ConnectionFactory.getConnection()) {
			
			String id = JOptionPane.showInputDialog("Id:");
			
			String sql = "DELETE FROM clientes WHERE id = ?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, Integer.valueOf(id));
			
			int linhas = prepareStatement.executeUpdate();
			
			if (linhas > 0)	Mensagem.sucesso("Cliente Apagado");
			else Mensagem.erro("Cliente n�o encontrado");			
			
		} catch (SQLException e) {
			Mensagem.erro( "Erro de conex�o: " + e.getMessage() );
			e.printStackTrace();
		}
		
	}

}
