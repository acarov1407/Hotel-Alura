package com.alura.reservaciones.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.alura.reservaciones.model.Guest;

public class CustomTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Guest> data;
    private String[] columnNames = {"Id", "Nombre", "Apellido", "Nacimiento", "Nacionalidad", "Telefono"};

    public CustomTableModel(List<Guest> data) {
    	if(data == null) this.data = new ArrayList<>();
    	else this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
        case 0: return data.get(rowIndex).getId();
        case 1: return data.get(rowIndex).getName();
        case 2: return data.get(rowIndex).getSurname();
        case 3: return data.get(rowIndex).getBirthDay();
        case 4: return data.get(rowIndex).getNationality();
        case 5: return data.get(rowIndex).getPhoneNumber();
        default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	
    	Guest guest;
    	switch(columnIndex) {
    	case 0:
    		guest = data.get(rowIndex);
    		guest.setId((Integer) aValue);
    		data.set(rowIndex, guest);
    		break;
    	case 1:
    		guest = data.get(rowIndex);
    		guest.setName(String.valueOf(aValue));
    		data.set(rowIndex, guest);
    		break;
    	case 2:
    		guest = data.get(rowIndex);
    		guest.setSurname(String.valueOf(aValue));
    		data.set(rowIndex, guest);
    		break;
    	case 3:
    		guest = data.get(rowIndex);
    		guest.setBirthDay((Date) aValue);
    		data.set(rowIndex, guest);
    		break;
    	case 4:
    		guest = data.get(rowIndex);
    		guest.setNationality(String.valueOf(aValue));
    		data.set(rowIndex, guest);
    		break;
    	case 5:
    		guest = data.get(rowIndex);
    		guest.setPhoneNumber(String.valueOf(aValue));
    		data.set(rowIndex, guest);
    		break;
    	default:
    		break;
    	}

        fireTableCellUpdated(rowIndex, columnIndex);
    }
    

    public void addRow(Guest guest) {
        data.add(guest);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    public void clear() {
    	data.clear();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        if (columnIndex == 0) {
            return false;
        }
        return true;
    }
}