package sistemas;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import componentes.Partida;

public class PartidaTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Partida> partidas;
	private final List<String> headers = Arrays.asList(
			"ID", 
			"Ultimo Guardado");
	
	public PartidaTableModel(List<Partida> partidas) {
		this.partidas = partidas;
	}
	
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
	}

	@Override
	public int getRowCount() {
		if (partidas != null) {
			return partidas.size();
		} else { 
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return headers.size(); 
	}
	
	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {    	
    }
    
    @Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Partida partida = partidas.get(rowIndex);
		
		switch (columnIndex) {
			case 0: return partida.getId();
			case 1: return partida.getFecha();
			default: return null;
		}
	}
}
