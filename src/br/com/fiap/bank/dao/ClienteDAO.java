package br.com.fiap.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bank.modelo.Cliente;

public class ClienteDAO {
	
	private Connection connection;
	
	public ClienteDAO(Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	public void salvar(Cliente cliente) throws SQLException {
		
		String sql = "INSERT INTO clientes (nome, cpf, email) VALUES (?, ?, ?)";
		PreparedStatement prepareStatement = connection.prepareStatement(sql); 
		prepareStatement.setString(1, cliente.getNome());
		prepareStatement.setString(2, cliente.getCpf());
		prepareStatement.setString(3, cliente.getEmail());
		
		prepareStatement.executeUpdate();
		
	}

	public int apagar(Long id) throws SQLException {

		String sql = "DELETE FROM clientes WHERE id = ?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setLong(1, id);
		
		return prepareStatement.executeUpdate();
	}

	public List<Cliente> buscarTodos() throws SQLException {
		Statement statement = connection.createStatement();

		statement.execute("SELECT * FROM clientes");

		ResultSet resultSet = statement.getResultSet();
		
		List<Cliente> lista = new ArrayList<Cliente>(); 
		
		while(resultSet.next()) {
			Cliente cliente = new Cliente(
					resultSet.getLong("id"), 
					resultSet.getString("nome"), 
					resultSet.getString("cpf"), 
					resultSet.getString("email")
				);
			
			lista.add(cliente);
		}
		
		return lista;
	}
	
	

}
