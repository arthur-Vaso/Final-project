package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.JButton;

public class CreateButton {

	public JButton setButton(JButton button, String text, String font, int style, int size) {
		button = new JButton(text);
		button.setFont(new Font(font, style, size));
		
		return button;
	}

	public JButton setButton(JButton button, String text) {
		button = new JButton(text);
		
		return button;
	}

}
