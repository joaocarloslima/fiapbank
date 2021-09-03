package br.com.fiap.bank;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.bank.dao.ClienteDAO;
import br.com.fiap.bank.util.Mensagem;

public class TestaExclusaoDeCliente {
	
	
	public static void main(String[] args) {
		
		try {
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionFactory.getConnection());
			
			String id = JOptionPane.showInputDialog("Id:");
			int linhas = clienteDAO.apagar(Long.valueOf(id));
			
			if (linhas > 0)	Mensagem.sucesso("Cliente Apagado");
			else Mensagem.erro("Cliente não encontrado");			
			
		} catch (SQLException e) {
			Mensagem.erro( "Erro de conexão: " + e.getMessage() );
			e.printStackTrace();
		}
		
	}

}
