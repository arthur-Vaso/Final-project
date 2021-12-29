package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateFieldArea {

	public JTextArea setFieldArea(JTextArea field, int rows, int columns, String font, int style, int size) {
		field = new JTextArea(rows, columns);
		field.setFont(new Font(font, style, size));
		
		return field;
	}

	public JTextArea setFieldArea(JTextArea field, int rows, int columns) {
		field = new JTextArea(rows, columns);
		
		return field;
	}

}
