package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.windows.WindowAdd;

public class ButtonConfirmAddController implements ActionListener {

	private WindowAdd window;

	public ButtonConfirmAddController(WindowAdd window) {
		this.window = window;
		this.window.getBtnConfirm().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CheckField cg = new CheckField();
		if (cg.isBlank(window.getFldTitle(), window.getLblTitle(), " precisa ser preenchido.")
				&& cg.isBlank(window.getFldDescription(), window.getLblDescription(), " precisa ser preenchido.")
				&& cg.isBlank(window.getFldMinimumAge(), window.getLblMinimumAge(), " precisa ser preenchido.")
				&& cg.isBlank(window.getFldGenderOne(), window.getLblGenderOne(), " precisa ser preenchido.")
				&& cg.isBlank(window.getFldPrice(), window.getLblPrice(), " precisa ser preenchido com números.")
				&& cg.isBlank(window.getFldAmount(), window.getLblAmount(), " precisa ser preenchido números.")) {
			
			System.out.println("Adicionado com sucesso!");
			JOptionPane.showMessageDialog(null, window.getFldTitle().getText() + " adicionado com sucesso!");
		
			window.dispose();
		}

	}

}
