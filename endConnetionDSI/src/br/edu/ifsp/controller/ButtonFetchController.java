package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonFetchController implements ActionListener {

	private MainWindow window;

	public ButtonFetchController(MainWindow window) {
		this.window = window;
		window.getBtnFetch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowSelectFetch wsf = new WindowSelectFetch();
		
	}

}
