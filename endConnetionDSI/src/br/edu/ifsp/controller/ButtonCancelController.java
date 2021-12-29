package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.WindowAdd;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonCancelController implements ActionListener {

	private WindowAdd windowAdd;
	private WindowSelectFetch windowFetch;
	private InternalFrameFetch internalFrameFetch;

	private int optionSelected;

	public ButtonCancelController(WindowAdd window) {
		this.windowAdd = window;
		this.windowAdd.getBtnCancel().addActionListener(this);

		optionSelected = 0;
	}

	public ButtonCancelController(WindowSelectFetch window) {
		this.windowFetch = window;
		this.windowFetch.getBtnCancel().addActionListener(this);

		optionSelected = 1;
	}

	public ButtonCancelController(InternalFrameFetch internalFrameFetch) {
		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnCancel().addActionListener(this);

		optionSelected = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionSelected) {
		case 0: {
			this.windowAdd.dispose();
			break;
		}
		case 1: {
			this.windowFetch.dispose();
			break;
		}
		case 2: {
			this.internalFrameFetch.dispose();
			break;
		}
		}
	}
}
