package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowAdd;
import br.edu.ifsp.windows.WindowEdit;

public class ButtonConfirmAddController implements ActionListener {

	private MainWindow mainWindow;
	private WindowAdd windowAdd;
	private WindowEdit windowEdit;
	
	private int optionControler;

	public ButtonConfirmAddController(WindowAdd windowAdd, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowAdd = windowAdd;
		this.windowAdd.getBtnConfirm().addActionListener(this);

		optionControler = 0;
	}

	public ButtonConfirmAddController(WindowEdit windowEdit) {
		this.windowEdit = windowEdit;
		this.windowEdit.getBtnConfirm().addActionListener(this);

		optionControler = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();

		switch (optionControler) {
		case 0: {
			if (cg.isBlank(windowAdd.getFldTitle(), windowAdd.getLblTitle(), " precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldDescription(), windowAdd.getLblDescription(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldMinimumAge(), windowAdd.getLblMinimumAge(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldGenderOne(), windowAdd.getLblGenderOne(), " precisa ser preenchido.")
					&& cg.isBlank(windowAdd.getFldPrice(), windowAdd.getLblPrice(),
							" precisa ser preenchido com números.")
					&& cg.isBlank(windowAdd.getFldAmount(), windowAdd.getLblAmount(),
							" precisa ser preenchido números.")) {

				System.out.println("Adicionado com sucesso!");
				JOptionPane.showMessageDialog(null, windowAdd.getFldTitle().getText() + " adicionado com sucesso!");

				windowAdd.dispose();
				mainWindow.setVisible(true);
			}
			break;
		}
		case 1: {
			if (cg.isBlank(windowEdit.getFldTitle(), windowEdit.getLblTitle(), " precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldDescription(), windowEdit.getLblDescription(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldMinimumAge(), windowEdit.getLblMinimumAge(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldGenderOne(), windowEdit.getLblGenderOne(),
							" precisa ser preenchido.")
					&& cg.isBlank(windowEdit.getFldPrice(), windowEdit.getLblPrice(),
							" precisa ser preenchido com números.")
					&& cg.isBlank(windowEdit.getFldAmount(), windowEdit.getLblAmount(),
							" precisa ser preenchido números.")) {

				System.out.println("Edição realizada com sucesso!");
				JOptionPane.showMessageDialog(null, windowEdit.getFldTitle().getText() + " editado com sucesso!");

				windowEdit.dispose();
			}
			break;
		}
		}
	}

}
