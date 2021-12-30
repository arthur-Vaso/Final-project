package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.InternalFrameName;
import br.edu.ifsp.windows.WindowFetch;

public class FetchControler implements ActionListener {

	private InternalFrameFetch internalFrameFetch;
	private WindowFetch window;

	public FetchControler(InternalFrameFetch internalFrameFetch, WindowFetch window) {
		this.window = window;
		
		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnFetch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();
		if(cg.isBlank(internalFrameFetch.getFldFetch(), internalFrameFetch.getLblFetch(), " precisa ser preenchido.")) {
			
			internalFrameFetch.dispose();
			this.window.dispose();
			
			WindowFetch wfn = new WindowFetch();
			wfn.createWindowName(new InternalFrameName(wfn));
		}
	}

}
