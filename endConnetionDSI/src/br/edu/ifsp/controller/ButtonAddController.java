package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowAdd;

public class ButtonAddController implements ActionListener{

	private MainWindow window;

	public ButtonAddController(MainWindow window) {
		this.window = window;
		this.window.getBtnAdd().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowAdd wa = new WindowAdd();
		
	}

}
