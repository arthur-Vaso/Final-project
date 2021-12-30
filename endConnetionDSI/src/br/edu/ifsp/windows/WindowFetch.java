package br.edu.ifsp.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFetch extends JFrame {

	private JPanel pnl;
	private InternalFrameFetch internalFrameFetch;
	private InternalFrameName internalFrameName;
	
	public WindowFetch() {
		
	}
	
	public void createWindowFetch(InternalFrameFetch internalFrameFetch) {
		this.internalFrameFetch = internalFrameFetch;
		
		pnl = new JPanel();
		pnl.add(internalFrameFetch);
		
		add(pnl);
		
		loadWindow();
	}

	public void createWindowName(InternalFrameName internalFrameName) {
		this.internalFrameName = internalFrameName;
		
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
