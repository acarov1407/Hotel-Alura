package com.alura.reservaciones.test;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.alura.reservaciones.dao.GuestDAO;
import com.alura.reservaciones.enums.PaymentMethods;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.Guest;
import com.alura.reservaciones.utilities.CustomTableModel;
import com.alura.reservaciones.utilities.DateChooserEditor;
import com.alura.reservaciones.utilities.DateChooserRenderer;

public class TableTest extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableTest() {
		super("test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		List<Guest> guests = new GuestDAO(new ConnectionFactory().createConnection()).getAllGuests();
		
		String[] columnName = {"Fecha", "Nombre"};
		JTable table = new JTable();
		
		CustomTableModel model = new CustomTableModel(null);
		table.setModel(model);
		
		JComboBox<String> paymentMethods = new JComboBox<>();
		for(PaymentMethods method: PaymentMethods.values()) {
			paymentMethods.addItem(method.toString());
		}
		
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(paymentMethods));
		table.getColumnModel().getColumn(3).setCellRenderer(new DateChooserRenderer());
		table.getColumnModel().getColumn(3).setCellEditor(new DateChooserEditor());

		
		frame.add(table);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		   
		 Guest temp = new Guest(12, "Mario", "Diaz", new Date(), "Colombiano", "21212112");
		 model.addRow(temp);
	}
	
	
}
