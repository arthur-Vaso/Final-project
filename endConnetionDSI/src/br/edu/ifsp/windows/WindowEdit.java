package br.edu.ifsp.windows;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import br.edu.ifsp.controller.ButtonCancelController;
import br.edu.ifsp.controller.ButtonConfirmAddController;
import br.edu.ifsp.controller.ButtonFetchController;
import br.edu.ifsp.controller.CloseProgram;
import br.edu.ifsp.controller.CreateButton;
import br.edu.ifsp.controller.CreateField;
import br.edu.ifsp.controller.CreateFieldArea;
import br.edu.ifsp.controller.CreateFormattedField;
import br.edu.ifsp.controller.CreateLabel;
import br.edu.ifsp.controller.LoadConstraintPanel;

public class WindowEdit extends JFrame{
	private JPanel pnlFetch;
	private JLabel lblFetch;
	private JFormattedTextField fldFetch;
	private JButton btnFetch;
	
	private JPanel pnlEdit;

	private JPanel pnlFields;
	private JLabel lblTitle;
	private JTextField fldTitle;
	private JLabel lblDescription;
	private JTextArea fldDescription;
	private JScrollPane scroll;
	private JLabel lblHardware;
	private JTextField fldHardware;
	private JLabel lblMinimumAge;
	private JTextField fldMinimumAge;
	private JLabel lblGenderOne;
	private JTextField fldGenderOne;
	private JLabel lblGenderTwo;
	private JTextField fldGenderTwo;
	private JLabel lblPrice;
	private JFormattedTextField fldPrice;
	private JLabel lblAmount;
	private JFormattedTextField fldAmount;

	private JPanel pnlButtons;
	private JButton btnConfirm;
	private JButton btnCancel;

	private LoadConstraintPanel lcp;
	private GridBagConstraints gbc;
	private GridBagLayout gridBag;
	
	private MainWindow mainWindow;

	public WindowEdit(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		createWindow();
		loadWindow();

		ButtonFetchController bfc = new ButtonFetchController(this);
		ButtonConfirmAddController bcac = new ButtonConfirmAddController(this, mainWindow);
		ButtonCancelController bcc = new ButtonCancelController(this, mainWindow);
		
		CloseProgram window = new CloseProgram(this, mainWindow);
	}
	
	private void createWindow() {
		gridBag = new GridBagLayout();
		
		pnlFetch = new JPanel(gridBag);
		pnlFetch.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lblFetch = new CreateLabel().setLabel(lblFetch, "ID", "Arial", 0, 15);
		try {
			fldFetch = new CreateFormattedField().setFormattedField(fldAmount, 3, "####", "Arial", 0, 12, true);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		btnFetch = new CreateButton().setButton(btnFetch,   "Buscar", "Arial", 0, 15, "/br/edu/ifsp/assets/findIcon.png");

		pnlEdit = new JPanel(gridBag);
		pnlEdit.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		pnlFields = new JPanel(gridBag);
		lblTitle = new CreateLabel().setLabel(lblTitle, "Título", "Arial", 0, 15);
		fldTitle = new CreateField().setField(fldTitle, 34, "Arial", 0, 12, true);

		lblDescription = new CreateLabel().setLabel(lblDescription, "Descrição", "Arial", 0, 15);
		fldDescription = new CreateFieldArea().setFieldArea(fldDescription, 5, 34, "Arial", 0, 12, true);
		scroll = new JScrollPane(fldDescription);
		
		lblHardware = new CreateLabel().setLabel(lblHardware, "Tipo de sistema", "Arial", 0, 15);
		fldHardware = new CreateField().setField(fldHardware, 10, "Arial", 0, 12, true);

		lblMinimumAge = new CreateLabel().setLabel(lblMinimumAge, "Classificação etária", "Arial", 0, 15);
		fldMinimumAge = new CreateField().setField(fldMinimumAge, 9, "Arial", 0, 12, true);

		lblGenderOne = new CreateLabel().setLabel(lblGenderOne, "Gênero 1", "Arial", 0, 15);
		fldGenderOne = new CreateField().setField(fldGenderOne, 10, "Arial", 0, 12, true);

		lblGenderTwo = new CreateLabel().setLabel(lblGenderTwo, "Gênero 2", "Arial", 0, 15);
		fldGenderTwo = new CreateField().setField(fldGenderTwo, 9, "Arial", 0, 12, true);

		lblPrice = new CreateLabel().setLabel(lblPrice, "Valor", "Arial", 0, 15);
		try {
			fldPrice = new CreateFormattedField().setFormattedField(fldPrice, 7, "#,##0.00", "Arial", 0, 12, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblAmount = new CreateLabel().setLabel(lblAmount, "Quantidade", "Arial", 0, 15);
		try {
			fldAmount = new CreateFormattedField().setFormattedField(fldAmount, 3, "###", "Arial", 0, 12, true);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pnlButtons = new JPanel(gridBag);
		btnConfirm = new CreateButton().setButton(btnConfirm, "Confirmar", "Arial", 0, 15, "/br/edu/ifsp/assets/confirmIcon.png");
		btnConfirm.setEnabled(false);

		btnCancel = new CreateButton().setButton(btnCancel, "Cancelar", "Arial", 0, 15, "/br/edu/ifsp/assets/cancelIcon.png");

		addComponents(gridBag);
	}

	private void addComponents(GridBagLayout gridBag) {
		lcp = new LoadConstraintPanel();
		gbc = new GridBagConstraints();

		lcp.setLoadConstraintPanel(pnlFetch, lblFetch, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFetch, fldFetch, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFetch, btnFetch, gbc, gridBag, 1, 1, 1, 1, 5, 10, GridBagConstraints.LINE_END);
		
		lcp.setLoadConstraintPanel(pnlFields, lblTitle, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldTitle, gbc, gridBag, 0, 1, 3, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblDescription, gbc, gridBag, 1, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		
		lcp.setLoadConstraintPanel(pnlFields, scroll, gbc, gridBag, 1, 1, 3, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(pnlFields, lblHardware, gbc, gridBag, 2, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldHardware, gbc, gridBag, 2, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblMinimumAge, gbc, gridBag, 2, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldMinimumAge, gbc, gridBag, 2, 3, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblGenderOne, gbc, gridBag, 3, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldGenderOne, gbc, gridBag, 3, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblGenderTwo, gbc, gridBag, 3, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldGenderTwo, gbc, gridBag, 3, 3, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblPrice, gbc, gridBag, 4, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldPrice, gbc, gridBag, 4, 1, 1, 1, 5, 10, GridBagConstraints.WEST);
		lcp.setLoadConstraintPanel(pnlFields, lblAmount, gbc, gridBag, 4, 2, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlFields, fldAmount, gbc, gridBag, 4, 3, 1, 1, 5, 10, GridBagConstraints.WEST);

		lcp.setLoadConstraintPanel(pnlButtons, btnConfirm, gbc, gridBag, 0, 0, 1, 1, 5, 10, GridBagConstraints.EAST);
		lcp.setLoadConstraintPanel(pnlButtons, btnCancel, gbc, gridBag, 0, 1, 1, 1, 5, 10, GridBagConstraints.WEST);

		
		lcp.setLoadConstraintPanel(pnlEdit, pnlFields, gbc, gridBag, 0, 0, 1, 1, 5, 5,
				GridBagConstraints.ABOVE_BASELINE);
		lcp.setLoadConstraintPanel(pnlEdit, pnlButtons, gbc, gridBag, 1, 0, 1, 1, 5, 5,
				GridBagConstraints.BELOW_BASELINE);

		add(pnlFetch, "North");
		add(pnlEdit, "South");

	}

	private void loadWindow() {
		setTitle("Adicionar jogos");
		URL url = getClass().getResource("/br/edu/ifsp/assets/joystickIcon.png");
        Image icone = Toolkit.getDefaultToolkit().getImage(url);
        setIconImage(icone);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
	
	public JLabel getLblFetch() {
		return lblFetch;
	}

	public JTextField getFldFetch() {
		return fldFetch;
	}

	public JButton getBtnFetch() {
		return btnFetch;
	}

	public JButton getBtnConfirm() {
		return btnConfirm;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public JTextField getFldTitle() {
		return fldTitle;
	}

	public JLabel getLblDescription() {
		return lblDescription;
	}

	public JTextArea getFldDescription() {
		return fldDescription;
	}

	public JLabel getLblHardware() {
		return lblHardware;
	}

	public JTextField getFldHardware() {
		return fldHardware;
	}

	public JLabel getLblMinimumAge() {
		return lblMinimumAge;
	}

	public JTextField getFldMinimumAge() {
		return fldMinimumAge;
	}

	public JLabel getLblGenderOne() {
		return lblGenderOne;
	}

	public JTextField getFldGenderOne() {
		return fldGenderOne;
	}

	public JLabel getLblGenderTwo() {
		return lblGenderTwo;
	}

	public JTextField getFldGenderTwo() {
		return fldGenderTwo;
	}

	public JLabel getLblPrice() {
		return lblPrice;
	}

	public JFormattedTextField getFldPrice() {
		return fldPrice;
	}

	public JLabel getLblAmount() {
		return lblAmount;
	}

	public JFormattedTextField getFldAmount() {
		return fldAmount;
	}

	public void setFldFetch(String string) {
		this.fldFetch.setText(string);
	}

	public void setFldTitle(String string) {
		this.fldTitle.setText(string);
	}

	public void setFldDescription(String string) {
		this.fldDescription.setText(string);
	}

	public void setFldHardware(String string) {
		this.fldHardware.setText(string);
	}

	public void setFldMinimumAge(String string) {
		this.fldMinimumAge.setText(string);
	}

	public void setFldGenderOne(String string) {
		this.fldGenderOne.setText(string);
	}

	public void setFldGenderTwo(String string) {
		this.fldGenderTwo.setText(string);
	}

	public void setFldPrice(String string) {
		this.fldPrice.setText(string);
	}

	public void setFldAmount(String string) {
		this.fldAmount.setText(string);
	}

}
