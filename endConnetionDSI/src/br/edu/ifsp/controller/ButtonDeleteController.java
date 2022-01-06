package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowDelete;

public class ButtonDeleteController implements ActionListener {

	private MainWindow mainWindow;

	public ButtonDeleteController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.getBtnDelete().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.mainWindow.dispose();
		WindowDelete wd = new WindowDelete(mainWindow);

	}

}
