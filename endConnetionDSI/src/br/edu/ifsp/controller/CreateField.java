package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.JTextField;

public class CreateField {
	
	public CreateField () {
		
	}

	public JTextField setField(JTextField field, int columns, String font, int style, int size) {
		field = new JTextField(columns);
		field.setFont(new Font(font, style, size));

		return field;
	}
	
	public JTextField setField(JTextField field, int columns) {
		field = new JTextField(columns);

		return field;
	}

}
