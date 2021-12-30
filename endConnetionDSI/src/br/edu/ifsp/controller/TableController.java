package br.edu.ifsp.controller;

import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.windows.InternalFrameName;

public class TableController {

	public TableController(DefaultTableModel model, InternalFrameName internalFrameName) {
		loadData(model, internalFrameName);
	}
	
	 private void loadData(DefaultTableModel model, InternalFrameName internalFrameName) {
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
