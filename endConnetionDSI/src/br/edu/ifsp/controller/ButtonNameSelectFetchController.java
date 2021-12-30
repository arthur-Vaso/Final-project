package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonNameSelectFetchController implements ActionListener {

	private WindowSelectFetch window;

	public ButtonNameSelectFetchController(WindowSelectFetch window) {
		this.window = window;
		this.window.getBtnByName().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		WindowFetch wfn = new WindowFetch();
		wfn.createWindowFetch(new InternalFrameFetch(wfn));
		
		window.dispose();
	}

}
