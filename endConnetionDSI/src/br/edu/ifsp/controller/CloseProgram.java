package br.edu.ifsp.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import br.edu.ifsp.windows.MainWindow;
import br.edu.ifsp.windows.WindowAdd;
import br.edu.ifsp.windows.WindowDelete;
import br.edu.ifsp.windows.WindowEdit;
import br.edu.ifsp.windows.WindowFetch;
import br.edu.ifsp.windows.WindowSelectFetch;

public class CloseProgram implements WindowListener {
	private MainWindow mainWindow;
	private WindowSelectFetch windowSelectFetch;
	private WindowFetch windowFetch;
	private WindowEdit windowEdit;

	private int optionClose;
	private WindowDelete windowDelete;
	private WindowAdd windowAdd;

	public CloseProgram(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.mainWindow.addWindowListener(this);

		optionClose = 0;
	}

	public CloseProgram(WindowSelectFetch windowSelectFetch, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowSelectFetch = windowSelectFetch;
		this.windowSelectFetch.addWindowListener(this);

		optionClose = 1;
	}

	public CloseProgram(WindowFetch windowFetch, WindowSelectFetch windowSelectFetch) {
		this.windowSelectFetch = windowSelectFetch;
		
		this.windowFetch = windowFetch;
		this.windowFetch.addWindowListener(this);

		optionClose = 2;
	}

	public CloseProgram(WindowEdit windowEdit, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowEdit = windowEdit;
		this.windowEdit.addWindowListener(this);

		optionClose = 3;
	}

	public CloseProgram(WindowDelete windowDelete, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowDelete = windowDelete;
		this.windowDelete.addWindowListener(this);

		optionClose = 4;
	}

	public CloseProgram(WindowAdd windowAdd, MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.windowAdd = windowAdd;
		this.windowAdd.addWindowListener(this);

		optionClose = 5;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		switch (optionClose) {
		case 0: {
			if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Deseja fechar?", "Alerta",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null)) {

				System.out.println("Fechar");
				System.exit(0);

			}
			break;
		}
		case 1: {
			windowSelectFetch.dispose();
			mainWindow.setVisible(true);
			break;
		}
		case 2: {
			windowFetch.dispose();
			windowSelectFetch.setVisible(true);
			break;
		}
		case 3: {
			windowEdit.dispose();
			mainWindow.setVisible(true);
			break;
		}
		case 4: {
			windowDelete.dispose();
			mainWindow.setVisible(true);
			break;
		}
		case 5: {
			windowAdd.dispose();
			mainWindow.setVisible(true);
			break;
		}
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
