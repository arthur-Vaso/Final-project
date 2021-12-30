package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonNameSelectFetchController implements ActionListener {

	private WindowSelectFetch windowSelectFetch;
	private MainWindow mainWindow;

	public ButtonNameSelectFetchController(WindowSelectFetch windowSelectFetch, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowSelectFetch = windowSelectFetch;
		this.windowSelectFetch.getBtnByName().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		WindowFetch wfn = new WindowFetch(windowSelectFetch);
		wfn.createWindowFetch(new InternalFrameFetch(wfn, windowSelectFetch));
		
		windowSelectFetch.dispose();
	}

}
