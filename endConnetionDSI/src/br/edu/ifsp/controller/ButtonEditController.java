package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowEdit;

public class ButtonEditController implements ActionListener {

	private MainWindow window;

	public ButtonEditController(MainWindow window) {
		this.window = window;
		this.window.getBtnEdit().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowEdit we = new WindowEdit(window);
		window.dispose();
	}

	
}
