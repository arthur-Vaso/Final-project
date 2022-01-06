package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import br.edu.ifsp.gameDAO.GameDAO;
import br.edu.ifsp.model.Game;
import br.edu.ifsp.windows.InternalFrameName;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonListAllController implements ActionListener {

	private WindowSelectFetch windowSelectFetch;

	public ButtonListAllController(WindowSelectFetch windowSelectFetch) {
		this.windowSelectFetch = windowSelectFetch;
		this.windowSelectFetch.getBtnListALL().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GameDAO gameDAO = new GameDAO();
		List<Game> l =  gameDAO.fetchPersonByName();
		
		WindowFetch wfn = new WindowFetch(windowSelectFetch);
		wfn.createWindowName(new InternalFrameName(wfn, l));
		
		windowSelectFetch.dispose();

	}

}
