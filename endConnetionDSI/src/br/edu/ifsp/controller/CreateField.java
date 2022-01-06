package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.JTextField;

public class CreateField {

	public CreateField() {

	}

	public JTextField setField(JTextField field, int columns, String font, int style, int size, boolean editable) {
		field = new JTextField(columns);
		field.setFont(new Font(font, style, size));
		field.setEditable(editable);

		return field;
	}

	public JTextField setField(JTextField field, int columns, boolean editable) {
		field = new JTextField(columns);
		field.setEditable(editable);
		
		return field;
	}

}
