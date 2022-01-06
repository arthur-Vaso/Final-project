package br.edu.ifsp.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.ifsp.controller.CloseProgram;

public class WindowFetch extends JFrame {
	private JPanel pnl;
	public WindowFetch(WindowSelectFetch windowSelectFetch) {
		new CloseProgram(this, windowSelectFetch);
	}
	
	public void createWindowFetch(InternalFrameFetch internalFrameFetch) {
		pnl = new JPanel();
		pnl.add(internalFrameFetch);
		
		add(pnl);
		
		loadWindow();
	}

	public void createWindowName(InternalFrameName internalFrameName) {
		pnl = new JPanel();
		pnl.add(internalFrameName);
		
		add(pnl);
		
		loadWindow();
	}

	private void loadWindow() {
		setTitle("");
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		repaint();
		pack();
		setLocationRelativeTo(null);
	}

}
