package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.InternalFrameName;

public class FetchControler implements ActionListener {

	private InternalFrameFetch internalFrameFetch;

	public FetchControler(InternalFrameFetch internalFrameFetch) {
		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnFetch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();
		if(cg.isBlank(internalFrameFetch.getFldFetch(), internalFrameFetch.getLblFetch(), " precisa ser preenchido.")) {
			internalFrameFetch.dispose();
			InternalFrameName ifn = new InternalFrameName();
		}
	}

}
