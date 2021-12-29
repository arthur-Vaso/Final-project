package br.edu.ifsp.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.windows.MainWindow;

public class CloseProgram implements WindowListener {
	private MainWindow window;

	public CloseProgram(MainWindow window) {
		this.window = window;
		this.window.addWindowListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

		if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Alerta",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null)) {

			System.out.println("Fechar");
			System.exit(0);

		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
