package br.edu.ifsp.windows;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.edu.ifsp.controller.ButtonAddController;
import br.edu.ifsp.controller.ButtonDeleteController;
import br.edu.ifsp.controller.ButtonEditController;
import br.edu.ifsp.controller.ButtonFetchController;
import br.edu.ifsp.controller.CloseProgram;
import br.edu.ifsp.controller.CreateButton;
import br.edu.ifsp.controller.CreateLabel;

public class MainWindow extends JFrame {

	private JPanel pnl;

	private JPanel pnlInfo;
	private JLabel lblInfo;

	private JPanel pnlButtons;
	private JButton btnAdd;
	private JButton btnFetch;
	private JButton btnEdit;
	private JButton btnDelete;

	public MainWindow() {
		createWindow();
		loadWindow();

		ButtonAddController bac = new ButtonAddController(this);
		ButtonFetchController bfc = new ButtonFetchController(this);
		ButtonEditController bec = new ButtonEditController(this);
		ButtonDeleteController bdc = new ButtonDeleteController(this);
		
		CloseProgram window = new CloseProgram(this);

	}

	private void createWindow() {
		pnl = new JPanel(new GridLayout(2, 1));

		pnlInfo = new JPanel();
		lblInfo = new CreateLabel().setLabel(lblInfo, "Selecione a opção que deseja executar.", "Arial", 0, 20);

		pnlButtons = new JPanel(new GridLayout(1, 4));
		btnAdd = new CreateButton().setButton(btnAdd, "Adicionar", "Arial", 0, 20, "/br/edu/ifsp/assets/addIcon.png");
		btnFetch= new CreateButton().setButton(btnFetch, "Procurar", "Arial", 0, 20, "/br/edu/ifsp/assets/listIcon.png");
		btnEdit = new CreateButton().setButton(btnEdit, "Editar", "Arial", 0, 20, "/br/edu/ifsp/assets/updateIcon.png");
		btnDelete = new CreateButton().setButton(btnDelete, "Excluir", "Arial", 0, 20, "/br/edu/ifsp/assets/deleteIcon.png");

		addComponents();
	}

	private void addComponents() {
		pnlInfo.add(lblInfo);

		pnlButtons.add(btnAdd);
		pnlButtons.add(btnFetch);
		pnlButtons.add(btnEdit);
		pnlButtons.add(btnDelete);

		pnl.add(pnlInfo);
		pnl.add(pnlButtons);

		add(pnl);

	}

	private void loadWindow() {
		setTitle("Inicio");
		URL url = getClass().getResource("/br/edu/ifsp/assets/joystickIcon.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(icone);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}	

	public JButton getBtnFetch() {
		return btnFetch;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
}
