package br.com.fiap.bank;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.bank.dao.ClienteDAO;
import br.com.fiap.bank.modelo.Cliente;
import br.com.fiap.bank.util.Mensagem;

public class TestaConsultaDeClientes extends Object {

	public static void main(String[] args) {

		try{
			ClienteDAO clienteDAO = new ClienteDAO(ConnectionFactory.getConnection());
			
			List<Cliente> lista = clienteDAO.buscarTodos();
			JOptionPane.showMessageDialog(null, lista);
			

		} catch (SQLException e) {
			Mensagem.erro("Erro de conexão: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
