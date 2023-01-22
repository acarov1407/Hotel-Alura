package com.alura.reservaciones.utilities;

import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class DateChooserEditor extends AbstractCellEditor implements TableCellEditor {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDateChooser dateChooser;

    public DateChooserEditor() {
        dateChooser = new JDateChooser();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        dateChooser.setDate((Date) value);
        dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if("date".equals(evt.getPropertyName())) fireEditingStopped();
            }
        });
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEnabled(false);
		editor.setBackground(new Color(255, 255, 255));
		editor.setDisabledTextColor(new Color(0, 0, 0));
		
        return dateChooser;
    }

    @Override
    public Object getCellEditorValue() {
        return dateChooser.getDate();
    }
    
}
