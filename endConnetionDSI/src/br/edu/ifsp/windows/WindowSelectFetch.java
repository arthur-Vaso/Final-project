package br.edu.ifsp.windows;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsp.controller.ButtonCancelController;
import br.edu.ifsp.controller.ButtonListAllController;
import br.edu.ifsp.controller.ButtonNameSelectFetchController;
import br.edu.ifsp.controller.CloseProgram;
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
	public WindowSelectFetch(MainWindow mainWindow) {
		createWindow();
		loadWindow();

		new ButtonNameSelectFetchController(this, mainWindow);
		new ButtonListAllController(this);
		new ButtonCancelController(this, mainWindow);
		
		new CloseProgram(this, mainWindow);
	}

	private void createWindow() {
		gridBag = new GridBagLayout();

		pnl = new JPanel(gridBag);

		lblInfo = new CreateLabel().setLabel(lblInfo, "Procurar por:", "Arial", 0, 20);

		btnByName = new CreateButton().setButton(btnByName,   "ID", "Arial", 0, 20, "/br/edu/ifsp/assets/oneIcon.png");
		
		btnListALL = new CreateButton().setButton(btnListALL, "Listar todos", "Arial", 0, 20, "/br/edu/ifsp/assets/twoMoreIcon.png");

		btnCancel = new CreateButton().setButton(btnCancel,   "  Cancelar  ", "Arial", 0, 20, "/br/edu/ifsp/assets/cancelIcon.png");

		btnByName.setPreferredSize(new Dimension(172, 30));
		btnListALL.setPreferredSize(new Dimension(172, 30));
		btnCancel.setPreferredSize(new Dimension(172, 30));
		
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
		URL url = getClass().getResource("/br/edu/ifsp/assets/joystickIcon.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(icone);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
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
