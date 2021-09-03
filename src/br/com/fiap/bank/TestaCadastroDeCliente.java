package br.com.fiap.bank;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.bank.dao.ClienteDAO;
import br.com.fiap.bank.modelo.Cliente;
import br.com.fiap.bank.util.Mensagem;

public class TestaCadastroDeCliente {

	
	public static void main(String[] args) {
		
		
		try {
			
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionFactory.getConnection());
			
			Cliente cliente = new Cliente(
					JOptionPane.showInputDialog("Nome: "), 
					JOptionPane.showInputDialog("CPF: "), 
					JOptionPane.showInputDialog("E-mail: ")
				);
			
			clienteDAO.salvar(cliente);
			
	
		}catch(SQLException e) {
			Mensagem.erro("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	
		
	}

}
