package br.edu.ifsp.windows;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.model.Game;

public class InternalFrameName extends JInternalFrame {
	private JPanel pnl;
	private JScrollPane scroll;
	private JTable table;

	private WindowFetch window;
	private WindowFetch windowFetch;
	
	private DefaultTableModel model;
	private Game game;
	private List<Game> list;

	public InternalFrameName(WindowFetch window, Game game) {
		this.window = window;
		model = new DefaultTableModel();
		this.game = game;

		loadTable(0);
		createWindow();
		loadWindow();
	}

	public InternalFrameName(WindowFetch windowFetch, List<Game> list) {
		this.list = list;
		this.windowFetch = windowFetch;
		model = new DefaultTableModel();

		loadTable(1);
		createWindow();
		loadWindow();
	}

	private void loadWindow() {
		pnl = new JPanel();

		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(800, 200));

		addComponents();
	}

	private void addComponents() {
		pnl.add(scroll);

		add(pnl);
	}

	private void createWindow() {
		setTitle("Lista");
		pack();
		setVisible(true);
	}

	public void loadTable(int option) {
		table = new JTable(model);
		model.addColumn("ID");
		model.addColumn("Título");
		model.addColumn("Descrição");
		model.addColumn("Sistema");
		model.addColumn("Classificação");
		model.addColumn("Genero 1");
		model.addColumn("Genero 2");
		model.addColumn("Preço");
		model.addColumn("Quantidade");

		table.getColumnModel().getColumn(0).setMinWidth(4);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(3).setMinWidth(10);
		table.getColumnModel().getColumn(4).setMinWidth(10);
		table.getColumnModel().getColumn(5).setMinWidth(10);
		table.getColumnModel().getColumn(6).setMinWidth(10);
		table.getColumnModel().getColumn(7).setMinWidth(10);
		table.getColumnModel().getColumn(8).setMinWidth(5);

		switch (option) {
		case 0: {
			loadDataName(model);
			break;
		}
		case 1: {
			loadDataList(model);
			break;
		}
		}
		
	}

	private void loadDataName(DefaultTableModel model) {
		model.setNumRows(0);
		
		model.addRow(new Object[] { 
				game.getId(), 
				game.getTitle(), 
				game.getDescription(), 
				game.getHardware(),
				game.getMinimumAge(), 
				game.getGenderOne(), 
				game.getGenderTwo(), 
				game.getPrice(), 
				game.getAmount() });
	}
	
	private void loadDataList(DefaultTableModel model) {
		model.setNumRows(0);

		list.forEach((game) -> {
            model.addRow(new Object[]{
            		game.getId(), 
    				game.getTitle(), 
    				game.getDescription(), 
    				game.getHardware(),
    				game.getMinimumAge(), 
    				game.getGenderOne(), 
    				game.getGenderTwo(), 
    				game.getPrice(), 
    				game.getAmount()
            });
        });
	}
}
