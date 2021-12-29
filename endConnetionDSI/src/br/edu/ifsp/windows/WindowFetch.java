package br.edu.ifsp.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFetch extends JFrame{

	private JPanel pnl;
	private InternalFrameFetch internalFrameFetch;

	public WindowFetch(InternalFrameFetch internalFrameFetch) {
		this.internalFrameFetch = internalFrameFetch;
		
		createWindow();
		loadWindow();
		
		
	}
	
	private void createWindow() {
		pnl = new JPanel();

		addComponents();
	}

	private void addComponents() {
		pnl.add(internalFrameFetch);
		
		add(pnl);
	}

	private void loadWindow() {
		setTitle("");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
