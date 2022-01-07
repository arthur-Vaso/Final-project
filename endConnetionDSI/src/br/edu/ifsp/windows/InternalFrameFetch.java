package br.edu.ifsp.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import br.edu.ifsp.controller.ButtonCancelController;
import br.edu.ifsp.controller.CreateButton;
import br.edu.ifsp.controller.CreateField;
import br.edu.ifsp.controller.CreateLabel;
import br.edu.ifsp.controller.FetchControler;
import br.edu.ifsp.controller.LoadConstraintPanel;

public class InternalFrameFetch extends JInternalFrame{
	private JPanel pnl;
	private GridBagLayout gridBag;
	private JLabel lblFetch;
	private JTextField fldFetch;
	private JButton btnFetch;
	private JButton btnCancel;
	

	public InternalFrameFetch(WindowFetch windowFetch, WindowSelectFetch windowSelectFetch) {
		createWindow();
		loadWindow();
		
		new FetchControler(this, windowSelectFetch, windowFetch);
		new ButtonCancelController(this, windowSelectFetch, windowFetch);
	}

	private void createWindow() {
		gridBag = new GridBagLayout();

		pnl = new JPanel(gridBag);

		lblFetch = new CreateLabel().setLabel(lblFetch, "ID", "Arial", 0, 20);
		fldFetch = new CreateField().setField(fldFetch, 30, "Arial", 0, 20, true);
		
		btnFetch = new CreateButton().setButton(btnFetch,   "Buscar", "Arial", 0, 20, "/br/edu/ifsp/assets/findIcon.png");
		btnCancel = new CreateButton().setButton(btnCancel,   "Cancelar", "Arial", 0, 20, "/br/edu/ifsp/assets/cancelIcon.png");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		LoadConstraintPanel lcp = new LoadConstraintPanel();
		GridBagConstraints gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(pnl, lblFetch, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnl, fldFetch, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnl, btnFetch, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);

		lcp.setLoadConstraintPanel(pnl, btnCancel, gbc, gridBag, 1, 1, 1, 1, 5, 10, GridBagConstraints.EAST);

		add(pnl);

	}

	private void loadWindow() {
		BasicInternalFrameUI bifui = (BasicInternalFrameUI) this.getUI();
		bifui.setNorthPane(null);
		pack();
		setVisible(true);
		setResizable(true);
	}

	public JButton getBtnFetch() {
		return btnFetch;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLblFetch() {
		return lblFetch;
	}
	
	public JTextField getFldFetch() {
		return fldFetch;
	}

	public void setFldFetch(String string) {
		fldFetch.setText(string);
		fldFetch.requestFocusInWindow();
	}
	
}
