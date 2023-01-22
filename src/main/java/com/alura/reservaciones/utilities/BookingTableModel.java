package com.alura.reservaciones.utilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.alura.reservaciones.model.Booking;
import com.alura.reservaciones.model.Guest;


public class BookingTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private List<Booking> data;
    private String[] columnNames = {"Id", "Fecha de CheckIn", "Fecha de CheckOut", "Valor", "Metodo de Pago", "Hecha por"};

    public BookingTableModel(List<Booking> data) {
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
        case 1: return data.get(rowIndex).getCheckIn();
        case 2: return data.get(rowIndex).getCheckOut();
        case 3: return data.get(rowIndex).getFormatedPrice();
        case 4: return data.get(rowIndex).getPaymentMethod();
        case 5: return data.get(rowIndex).getOwner();
        default: return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	
    	Booking booking;
    	switch(columnIndex) {
    	case 0:
    		booking = data.get(rowIndex);
    		booking.setId(String.valueOf(aValue));
    		data.set(rowIndex, booking);
    		break;
    	case 1:
    		booking = data.get(rowIndex);
    		booking.setCheckIn((Date) aValue);
    		data.set(rowIndex, booking);
    		break;
    	case 2:
    		booking = data.get(rowIndex);
    		booking.setCheckOut((Date) aValue);
    		data.set(rowIndex, booking);
    		break;
    	case 3:
    		booking = data.get(rowIndex);
    		booking.setPrice(Double.valueOf(String.valueOf(aValue)));
    		data.set(rowIndex, booking);
    		break;
    	case 4:
    		booking = data.get(rowIndex);
    		booking.setPaymentMethod(String.valueOf(aValue));
    		data.set(rowIndex, booking);
    		break;
    	case 5:
    		booking = data.get(rowIndex);
    		booking.setOwner((Guest) aValue);
    		data.set(rowIndex, booking);
    		break;
    	default:
    		break;
    	}

        fireTableCellUpdated(rowIndex, columnIndex);
    }
    

    public void addRow(Booking booking) {
        data.add(booking);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    public void clear() {
    	data.clear();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        if (columnIndex == 0 || columnIndex == 3 || columnIndex == 5) {
            return false;
        }
        return true;
    }
}
