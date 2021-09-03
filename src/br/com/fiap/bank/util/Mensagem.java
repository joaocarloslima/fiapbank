package br.com.fiap.bank.util;

import javax.swing.JOptionPane;


public class Mensagem {

	public static void sucesso(String mensagem) {
		JOptionPane.showInternalMessageDialog(null, 
				mensagem);
	}

	public static void erro(String mensagem) {
		JOptionPane.showInternalMessageDialog(null, 
				mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}

}
