package br.edu.ifsp.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsp.controller.ButtonCancelController;
import br.edu.ifsp.controller.ButtonNameSelectFetchController;
import br.edu.ifsp.controller.CreateButton;
import br.edu.ifsp.controller.CreateLabel;
import br.edu.ifsp.controller.LoadConstraintPanel;

public class WindowSelectFetch extends JFrame {

	private JPanel pnl;
	private GridBagLayout gridBag;
	private JLabel lblInfo;
	private JButton btnByName;
	private JButton btnListALL;
	private JButton btnCancel;
	private MainWindow window;

	public WindowSelectFetch(MainWindow window) {
		this.window = window;
		
		createWindow();
		loadWindow();

		ButtonNameSelectFetchController bnsfc = new ButtonNameSelectFetchController(this);
		ButtonCancelController bcc = new ButtonCancelController(this, window);
	}

	private void createWindow() {
		gridBag = new GridBagLayout();

		pnl = new JPanel(gridBag);

		lblInfo = new CreateLabel().setLabel(lblInfo, "Procurar por:", "Arial", 0, 20);

		btnByName = new CreateButton().setButton(btnByName,   "    Nome    ", "Arial", 0, 20);
		btnListALL = new CreateButton().setButton(btnListALL, "Listar todos", "Arial", 0, 20);

		btnCancel = new CreateButton().setButton(btnCancel,   "  Cancelar  ", "Arial", 0, 20);

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		LoadConstraintPanel lcp = new LoadConstraintPanel();
		GridBagConstraints gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(pnl, lblInfo, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnl, btnByName, gbc, gridBag, 1, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);
		lcp.setLoadConstraintPanel(pnl, btnListALL, gbc, gridBag, 2, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);

		lcp.setLoadConstraintPanel(pnl, btnCancel, gbc, gridBag, 3, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);

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

	public JButton getBtnByName() {
		return btnByName;
	}

	public JButton getBtnListALL() {
		return btnListALL;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}
	
	
}
