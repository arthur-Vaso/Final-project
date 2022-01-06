package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.gameDAO.GameDAO;
import br.edu.ifsp.model.Game;
import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowAdd;
import br.edu.ifsp.windows.WindowDelete;
import br.edu.ifsp.windows.WindowEdit;

public class ButtonConfirmAddController implements ActionListener {

	private MainWindow mainWindow;
	private WindowAdd windowAdd;
	private WindowEdit windowEdit;

	private int optionControler;
	private GameDAO gameDao;
	private WindowDelete windowDelete;

	public ButtonConfirmAddController(WindowAdd windowAdd, MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		this.windowAdd = windowAdd;
		this.windowAdd.getBtnConfirm().addActionListener(this);

		optionControler = 0;
	}

	public ButtonConfirmAddController(WindowEdit windowEdit, MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		this.windowEdit = windowEdit;
		this.windowEdit.getBtnConfirm().addActionListener(this);

		optionControler = 1;
	}

	public ButtonConfirmAddController(WindowDelete windowDelete, MainWindow mainWindow) {
		this.mainWindow = mainWindow;

		this.windowDelete = windowDelete;
		this.windowDelete.getBtnConfirm().addActionListener(this);

		optionControler = 2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();

		switch (optionControler) {
		case 0: {
			if (cg.isBlank(windowAdd.getFldTitle(), windowAdd.getLblTitle(), " precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldDescription(), windowAdd.getLblDescription(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldHardware(), windowAdd.getLblHardware(), " precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldMinimumAge(), windowAdd.getLblMinimumAge(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldGenderOne(), windowAdd.getLblGenderOne(), " precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldPrice(), windowAdd.getLblPrice(),
							" precisa ser preenchido com números.")
					&& cg.isBlank(windowAdd.getFldAmount(), windowAdd.getLblAmount(),
							" precisa ser preenchido números.")) {

				Game g = new Game();
				g.setTitle(windowAdd.getFldTitle().getText());
				g.setDescription(windowAdd.getFldDescription().getText());
				g.setHardware(windowAdd.getFldHardware().getText());
				g.setMinimumAge(windowAdd.getFldMinimumAge().getText());
				g.setGenderOne(windowAdd.getFldGenderOne().getText());
				g.setGenderTwo(windowAdd.getFldGenderTwo().getText());
				g.setPrice(windowAdd.getFldPrice().getText());
				g.setAmount(windowAdd.getFldAmount().getText());

				gameDao = new GameDAO();
				g = gameDao.saveGame(g);

				if (g != null) {
					System.out.println("diferente de nulo");
					System.out.println("titulo: " + g.getTitle().toString());

					System.out.println("Adicionado com sucesso!");
					JOptionPane.showMessageDialog(null, windowAdd.getFldTitle().getText() + " adicionado com sucesso!");

					windowAdd.dispose();
					mainWindow.setVisible(true);
				}
			}
			break;
		}
		case 1: {
			if (cg.isBlank(windowEdit.getFldTitle(), windowEdit.getLblTitle(), " precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldDescription(), windowEdit.getLblDescription(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldHardware(), windowEdit.getLblHardware(), " precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldMinimumAge(), windowEdit.getLblMinimumAge(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldGenderOne(), windowEdit.getLblGenderOne(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldPrice(), windowEdit.getLblPrice(),
							" precisa ser preenchido com números.")
					&& cg.isBlank(windowEdit.getFldAmount(), windowEdit.getLblAmount(),
							" precisa ser preenchido números.")) {

				Game g = new Game();
				g.setId(Integer.valueOf(windowEdit.getFldFetch().getText()));
				g.setTitle(windowEdit.getFldTitle().getText());
				g.setDescription(windowEdit.getFldDescription().getText());
				g.setHardware(windowEdit.getFldHardware().getText());
				g.setMinimumAge(windowEdit.getFldMinimumAge().getText());
				g.setGenderOne(windowEdit.getFldGenderOne().getText());
				g.setGenderTwo(windowEdit.getFldGenderTwo().getText());
				g.setPrice(windowEdit.getFldPrice().getText());
				g.setAmount(windowEdit.getFldAmount().getText());

				gameDao = new GameDAO();
				g = gameDao.saveGame(g);

				if (g != null) {
					System.out.println("Edição realizada com sucesso!");
					JOptionPane.showMessageDialog(null, windowEdit.getFldTitle().getText() + " editado com sucesso!");

					windowEdit.dispose();
					mainWindow.setVisible(true);
				}
			}
			break;
		}
		case 2: {
			if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
					"Deseja excluir " + windowDelete.getFldTitle().getText() + "?", "Alerta", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null)) {

				gameDao = new GameDAO();
				gameDao.removeGame(Integer.valueOf(windowDelete.getFldFetch().getText()));

				System.out.println("Exclusão realizada com sucesso!");
				JOptionPane.showMessageDialog(null, windowDelete.getFldTitle().getText() + " excluido com sucesso!");

				windowDelete.dispose();
				mainWindow.setVisible(true);
			}

			break;
		}
		}
	}

}
