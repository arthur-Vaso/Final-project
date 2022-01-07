package br.edu.ifsp.windows;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

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
		
		loadWindow("Busca");
	}

	public void createWindowName(InternalFrameName internalFrameName) {
		pnl = new JPanel();
		pnl.add(internalFrameName);
		
		add(pnl);
		
		loadWindow("Lista");
	}

	private void loadWindow(String title) {
		setTitle(title);
		URL url = getClass().getResource("/br/edu/ifsp/assets/joystickIcon.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(icone);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		repaint();
		pack();
		setLocationRelativeTo(null);
	}

}
