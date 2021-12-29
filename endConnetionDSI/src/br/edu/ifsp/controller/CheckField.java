package br.edu.ifsp.controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CheckField {

	public CheckField() {

	}

	public Boolean isBlank(JTextField field, JLabel label, String text) {
		if (field.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "O campo " + label.getText() + text);
			return false;
		}
		return true;
	}

	public boolean isBlank(JTextArea field, JLabel label, String text) {
		if (field.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "O campo " + label.getText() + text);
			return false;
		}
		return true;
	}
}
