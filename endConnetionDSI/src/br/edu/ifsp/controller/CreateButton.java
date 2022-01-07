package br.edu.ifsp.controller;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreateButton {

	public JButton setButton(JButton button, String text, String font, int style, int size, String url) {
		button = new JButton(text);
		button.setFont(new Font(font, style, size));
		try {
			button.setIcon(new ImageIcon(getClass().getResource(url)));
		} catch (NullPointerException npe) {
			// TODO: handle exception
		}
		return button;
	}

	public JButton setButton(JButton button, String text, String url) {
		button = new JButton(text);
		button.setIcon(new ImageIcon(getClass().getResource(url)));

		return button;
	}

}
