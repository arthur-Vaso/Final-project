package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.gameDAO.GameDAO;
import br.edu.ifsp.model.Game;
import br.edu.ifsp.windows.InternalFrameFetch;
import br.edu.ifsp.windows.InternalFrameName;
import br.edu.ifsp.windows.WindowEdit;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class FetchControler implements ActionListener {

	private InternalFrameFetch internalFrameFetch;
	private WindowSelectFetch windowSelectFetch;
	private WindowFetch windowFetch;
	private WindowEdit windowEdit;

	public FetchControler(InternalFrameFetch internalFrameFetch, WindowSelectFetch windowSelectFetch,
			WindowFetch windowFetch) {
		this.windowSelectFetch = windowSelectFetch;
		this.windowFetch = windowFetch;

		this.internalFrameFetch = internalFrameFetch;
		this.internalFrameFetch.getBtnFetch().addActionListener(this);
	}

	public FetchControler(WindowEdit windowEdit) {
		this.windowEdit = windowEdit;

		this.windowEdit.getBtnFetch().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();
		if (cg.isBlank(internalFrameFetch.getFldFetch(), internalFrameFetch.getLblFetch(),
				" precisa ser preenchido.")) {
			
			GameDAO gameDAO = new GameDAO();
			
			Game g = gameDAO.fetchGameById(Integer.valueOf(internalFrameFetch.getFldFetch().getText()));
			
			if (g != null) {
				
				this.internalFrameFetch.dispose();
				this.windowFetch.dispose();
				this.windowSelectFetch.dispose();
				
				WindowFetch wfn = new WindowFetch(windowSelectFetch);
				wfn.createWindowName(new InternalFrameName(wfn, g));
			}
			internalFrameFetch.setFldFetch("");
		}
	}

}
