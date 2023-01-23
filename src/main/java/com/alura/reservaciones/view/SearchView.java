package com.alura.reservaciones.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import com.alura.reservaciones.enums.Nationalities;
import com.alura.reservaciones.enums.PaymentMethods;
import com.alura.reservaciones.utilities.BookingTableModel;
import com.alura.reservaciones.utilities.GuestTableModel;
import com.alura.reservaciones.utilities.MyColor;
import com.alura.reservaciones.utilities.DateChooserEditor;
import com.alura.reservaciones.utilities.DateChooserRenderer;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class SearchView extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable tbGuest;
	private JTable tbBooking;
	private BookingTableModel modelBooking;
	private GuestTableModel modelGuest;
	private JLabel lblBack;
	private JLabel lblExit;
	private JLabel lblNewLabel_4;
	private JTabbedPane tabSearch;
	private JLabel lblNewLabel_2;
	private JPanel header;
	private JPanel btnBack;
	private JPanel btnExit;
	private JSeparator separator_1_2;
	private JPanel btnSearch;
	private JLabel lblSearch;
	private JPanel btnEdit;
	private JLabel lblEdit;
	private JPanel btnDelete;
	private JLabel lblDelete;
	private int xMouse, yMouse;
	private MyColor myColor;

	

	public SearchView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchView.class.getResource("/images/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		myColor = new MyColor();
		setTables();
		initComponents();
		
		
		
		
	}
	
	private void initComponents() {
		txtSearch = new JTextField();
		txtSearch.setBounds(536, 127, 193, 31);
		txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(this.myColor.getCustomBlue());
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 301, 42);
		contentPane.add(lblNewLabel_4);
		
		tabSearch = new JTabbedPane(JTabbedPane.TOP);
		tabSearch.setBackground(this.myColor.getCustomBlue());
		tabSearch.setFont(new Font("Roboto", Font.PLAIN, 16));
		tabSearch.setBounds(20, 169, 865, 328);
		contentPane.add(tabSearch);
				
		tabSearch.addTab("Huéspedes", new ImageIcon(SearchView.class.getResource("/images/pessoas.png")), new JScrollPane(tbGuest), null);
		tabSearch.addTab("Reservas", new ImageIcon(SearchView.class.getResource("/images/reservado.png")), new JScrollPane(tbBooking), null);
	
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SearchView.class.getResource("/images/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		btnBack = new JPanel();
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(myColor.getCustomBlue());
				lblBack.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnBack.setBackground(Color.white);
			     lblBack.setForeground(Color.black);
			}
		});
		btnBack.setLayout(null);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(0, 0, 53, 36);
		header.add(btnBack);
		
		lblBack = new JLabel("<");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblBack.setBounds(0, 0, 53, 36);
		btnBack.add(lblBack);
		
		btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				btnExit.setBackground(Color.red);
				lblExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { 
				 btnExit.setBackground(Color.white);
			     lblExit.setForeground(Color.black);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		
		lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.BLACK);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExit.setBounds(0, 0, 53, 36);
		btnExit.add(lblExit);
		
		separator_1_2 = new JSeparator();
		separator_1_2.setForeground(this.myColor.getCustomBlue());
		separator_1_2.setBackground(this.myColor.getCustomBlue());
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		btnSearch = new JPanel();
		btnSearch.setLayout(null);
		btnSearch.setBackground(this.myColor.getCustomBlue());
		btnSearch.setBounds(748, 125, 122, 35);
		btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnSearch);
		
		lblSearch = new JLabel("BUSCAR");
		lblSearch.setBounds(0, 0, 122, 35);
		btnSearch.add(lblSearch);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		btnEdit = new JPanel();
		btnEdit.setLayout(null);
		btnEdit.setBackground(this.myColor.getCustomBlue());
		btnEdit.setBounds(635, 508, 122, 35);
		btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEdit);
		
		lblEdit = new JLabel("EDITAR");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setForeground(Color.WHITE);
		lblEdit.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEdit.setBounds(0, 0, 122, 35);
		btnEdit.add(lblEdit);
		
		btnDelete = new JPanel();
		btnDelete.setLayout(null);
		btnDelete.setBackground(this.myColor.getCustomBlue());
		btnDelete.setBounds(767, 508, 122, 35);
		btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDelete);
		
		lblDelete = new JLabel("ELIMINAR");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblDelete.setBounds(0, 0, 122, 35);
		btnDelete.add(lblDelete);
	}
	
	 
	private void setTables() {
		setGuestTable();
		setBookingTable();
		
	}
	
	private void setGuestTable() {
		tbGuest = new JTable();
		tbGuest.setRowHeight(30);
		tbGuest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbGuest.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		modelGuest = new GuestTableModel(null);
		tbGuest.setModel(modelGuest);
		
		JComboBox<String> nationalities = new JComboBox<>();
		for(Nationalities nationality: Nationalities.values()) {
			nationalities.addItem(nationality.toString());
		}
		
		
		tbGuest.getColumnModel().getColumn(3).setCellRenderer(new DateChooserRenderer());
		tbGuest.getColumnModel().getColumn(3).setCellEditor(new DateChooserEditor());
		tbGuest.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(nationalities));
	}
	
	private void setBookingTable() {
		tbBooking = new JTable();
		tbBooking.setRowHeight(30);
		tbBooking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBooking.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		modelBooking = new BookingTableModel(null);
		tbBooking.setModel(modelBooking);
		
		JComboBox<String> paymentMethods = new JComboBox<>();
		for(PaymentMethods method: PaymentMethods.values()) {
			paymentMethods.addItem(method.toString());
		}
		
		tbBooking.getColumnModel().getColumn(1).setCellRenderer(new DateChooserRenderer());
		tbBooking.getColumnModel().getColumn(1).setCellEditor(new DateChooserEditor());
		tbBooking.getColumnModel().getColumn(2).setCellRenderer(new DateChooserRenderer());
		tbBooking.getColumnModel().getColumn(2).setCellEditor(new DateChooserEditor());
		tbBooking.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(paymentMethods));

		
	}
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}

		public JTextField getTxtSearch() {
			return txtSearch;
		}

		public JTable getTbGuest() {
			return tbGuest;
		}

		public JTable getTbBooking() {
			return tbBooking;
		}

		public JPanel getBtnBack() {
			return btnBack;
		}

		public JPanel getBtnExit() {
			return btnExit;
		}

		public JPanel getBtnSearch() {
			return btnSearch;
		}

		public JPanel getBtnEdit() {
			return btnEdit;
		}

		public JPanel getBtnDelete() {
			return btnDelete;
		}

		public GuestTableModel getModelGuest() {
			return modelGuest;
		}
		
		
		public BookingTableModel getModelBooking() {
			return modelBooking;
		}

		public JTabbedPane getTabSearch() {
			return tabSearch;
		}
		
		
		
		
		
	    
}

