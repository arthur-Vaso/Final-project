package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.gameDAO.GameDAO;
import br.edu.ifsp.model.Game;
import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowDelete;
import br.edu.ifsp.windows.WindowEdit;
import br.edu.ifsp.windows.WindowSelectFetch;

public class ButtonFetchController implements ActionListener {

	private MainWindow mainWindow;
	private WindowEdit windowEdit;
	private int optionControler;
	private WindowDelete windowDelete;

	public ButtonFetchController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		mainWindow.getBtnFetch().addActionListener(this);

		optionControler = 0;
	}

	public ButtonFetchController(WindowEdit windowEdit) {
		this.windowEdit = windowEdit;

		windowEdit.getBtnFetch().addActionListener(this);

		optionControler = 1;
	}

	public ButtonFetchController(WindowDelete windowDelete) {
		this.windowDelete = windowDelete;

		windowDelete.getBtnFetch().addActionListener(this);

		optionControler = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (optionControler) {
		case 0: {
			WindowSelectFetch wsf = new WindowSelectFetch(mainWindow);
			mainWindow.dispose();
			break;
		}
		case 1: {
			CheckField cg = new CheckField();
			if (cg.isBlank(windowEdit.getFldFetch(), windowEdit.getLblFetch(), " precisa ser preenchido.")) {
				
				GameDAO gameDAO = new GameDAO();
				
				Game g = gameDAO.fetchGameById(Integer.valueOf(windowEdit.getFldFetch().getText()));
				
				if (g != null) {
					
					windowEdit.setFldTitle(g.getTitle());
					windowEdit.setFldDescription(g.getDescription());
					windowEdit.setFldHardware(g.getHardware());
					windowEdit.setFldMinimumAge(g.getMinimumAge());
					windowEdit.setFldGenderOne(g.getGenderOne());
					windowEdit.setFldGenderTwo(g.getGenderTwo());
					windowEdit.setFldPrice(g.getPrice());
					windowEdit.setFldAmount(g.getAmount());
					
					windowEdit.getFldFetch().setEditable(false);
					windowEdit.getBtnFetch().setEnabled(false);
					
					windowEdit.getBtnConfirm().setEnabled(true);
					
				} else {
					windowEdit.setFldFetch("");
					windowEdit.getFldFetch().requestFocusInWindow();
				}
			}
			break;
		}
		case 2: {
			CheckField cg = new CheckField();
			if (cg.isBlank(windowDelete.getFldFetch(), windowDelete.getLblFetch(), " precisa ser preenchido.")) {

				GameDAO gameDAO = new GameDAO();

				Game g = gameDAO.fetchGameById(Integer.valueOf(windowDelete.getFldFetch().getText()));

				if (g != null) {

					windowDelete.setFldTitle(g.getTitle());
					windowDelete.setFldDescription(g.getDescription());
					windowDelete.setFldHardware(g.getHardware());
					windowDelete.setFldMinimumAge(g.getMinimumAge());
					windowDelete.setFldGenderOne(g.getGenderOne());
					windowDelete.setFldGenderTwo(g.getGenderTwo());
					windowDelete.setFldPrice(g.getPrice());
					windowDelete.setFldAmount(g.getAmount());

					windowDelete.getFldFetch().setEditable(false);
					windowDelete.getBtnFetch().setEnabled(false);
					
					windowDelete.getBtnConfirm().setEnabled(true);
					
				} else {
					windowDelete.setFldFetch("");
					windowDelete.getFldFetch().requestFocusInWindow();
				}
			}
			break;
		}

		}
	}
}
