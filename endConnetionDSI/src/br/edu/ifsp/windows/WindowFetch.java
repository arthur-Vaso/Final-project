package br.edu.ifsp.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.ifsp.controller.CloseProgram;

public class WindowFetch extends JFrame {
	private WindowSelectFetch windowSelectFetch;

	private JPanel pnl;
	private InternalFrameFetch internalFrameFetch;
	private InternalFrameName internalFrameName;
	
	public WindowFetch(WindowSelectFetch windowSelectFetch) {
		this.windowSelectFetch = windowSelectFetch;
		
		CloseProgram window = new CloseProgram(this, windowSelectFetch);
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
