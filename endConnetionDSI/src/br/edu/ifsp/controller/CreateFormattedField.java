package br.edu.ifsp.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class CreateFormattedField {

	public JFormattedTextField setFormattedField(JFormattedTextField field, int columns, String mask, String font, int style,
			int size) throws ParseException {
		field = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat(mask))));
		field.setColumns(columns);
		return field;
	}

}
