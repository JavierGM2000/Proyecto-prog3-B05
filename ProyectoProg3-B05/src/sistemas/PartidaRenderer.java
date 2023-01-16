package sistemas;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PartidaRenderer implements TableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {		
		JLabel label = new JLabel();
		label.setBackground(table.getBackground());
		label.setHorizontalAlignment(JLabel.CENTER);
		
		if (column == 0) {
			label.setText(value.toString());
		}
		if (column == 1) {
			label.setText((String) value);
		}
		
		if (isSelected) {
			label.setBackground(table.getSelectionBackground());
			label.setForeground(table.getSelectionForeground());
		}
		
		label.setOpaque(true);
		
		return label;
	}
}
