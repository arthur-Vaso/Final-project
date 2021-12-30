package br.edu.ifsp.windows;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.controller.LoadConstraintPanel;
import br.edu.ifsp.controller.TableController;

public class InternalFrameName extends JInternalFrame {
	private JPanel pnl;
	private JScrollPane scroll;
	private JTable table;
	
	private WindowFetch window;
	private DefaultTableModel model;

	public InternalFrameName(WindowFetch window) {
		this.window = window;
		model = new DefaultTableModel();
		
		loadTable();
		createWindow();
		loadWindow();
	}

	private void loadWindow() {
		pnl = new JPanel();

		//table = new JTable();
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(800, 200));
		//TableModel tc = new TableModel(model, this, table);

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
		//setResizable(true);
	}

	public void loadTable() {
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

		// loadData(model);
	}
	
	private void loadData(DefaultTableModel model) {
        model.setNumRows(0);
        
        /*internalFrameName.getGerenciador().getVeiculo().forEach((v) -> {
            model.addRow(new Object[]{
                v.getCodigo(),
                v.getModelo(),
                v.getCor(),
                v.getAnoFabricacao(),
                v.getTipoTransmicao(),
                v.getValor()
            });
        });*/
    }
}
