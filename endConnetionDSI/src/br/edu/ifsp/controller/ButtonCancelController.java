package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowAdd;
import br.edu.ifsp.windows.WindowEdit;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonCancelController implements ActionListener {

	private MainWindow mainWindow;
	private WindowAdd windowAdd;
	private WindowSelectFetch windowSelectFetch;
	private InternalFrameFetch internalFrameFetch;
	private WindowFetch windowFetch;

	private int optionSelected;
	private WindowEdit windowEdit;

	public ButtonCancelController(WindowAdd windowAdd, MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		this.windowAdd = windowAdd;
		this.windowAdd.getBtnCancel().addActionListener(this);

		optionSelected = 0;
	}

	public ButtonCancelController(WindowSelectFetch windowSelectFetch, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowSelectFetch = windowSelectFetch;
		this.windowSelectFetch.getBtnCancel().addActionListener(this);

		optionSelected = 1;
	}

	public ButtonCancelController(InternalFrameFetch internalFrameFetch, WindowSelectFetch windowSelectFetch, WindowFetch windowFetch) {
		this.windowSelectFetch = windowSelectFetch;
		this.windowFetch = windowFetch;
		
		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnCancel().addActionListener(this);

		optionSelected = 2;
	}

	public ButtonCancelController(WindowEdit windowEdit, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.windowEdit = windowEdit;
		this.windowEdit.getBtnCancel().addActionListener(this);

		optionSelected = 3;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionSelected) {
		case 0: {
			this.windowAdd.dispose();
			this.mainWindow.setVisible(true);
			break;
		}
		case 1: {
			this.windowSelectFetch.dispose();
			this.mainWindow.setVisible(true);
			break;
		}
		case 2: {
			this.internalFrameFetch.dispose();
			this.windowFetch.dispose();
			this.windowSelectFetch.setVisible(true);
			break;
		}
		case 3: {
			this.windowEdit.dispose();
			this.mainWindow.setVisible(true);
			break;
		}
		}
	}
}
