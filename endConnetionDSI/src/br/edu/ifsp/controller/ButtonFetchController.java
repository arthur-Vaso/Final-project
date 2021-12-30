package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowEdit;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonFetchController implements ActionListener {

	private MainWindow window;
	private WindowEdit windowEdit;
	private int optionControler;

	public ButtonFetchController(MainWindow window) {
		this.window = window;
		
		window.getBtnFetch().addActionListener(this);

		optionControler = 0;
	}

	public ButtonFetchController(WindowEdit windowEdit) {
		this.windowEdit = windowEdit;
		
		windowEdit.getBtnFetch().addActionListener(this);

		optionControler = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionControler) {
		case 0: {
			WindowSelectFetch wsf = new WindowSelectFetch(window);
			window.dispose();
			break;
		}
		case 1: {
			System.out.println("ainda nao sei o que colocar aqui");
			break;
		}

		}
	}
}
