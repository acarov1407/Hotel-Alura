package com.alura.reservaciones.utilities;


import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import com.toedter.calendar.JDateChooser;


public class DateChooserRenderer extends DefaultTableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate((Date) value);
        return dateChooser;
    }
}
