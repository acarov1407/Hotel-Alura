package com.alura.reservaciones.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class UserMenuView extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel lblExit;
	private JLabel lblRegister;
	private JPanel header;
	private JPanel panelMenu;
	private JLabel lblNewLabel_2;
	private JPanel btnExit;
	private JPanel btnRegister;
	private JPanel btnSearch;
	private JLabel lblBookingSearch;
	private JSeparator separator;
	private JPanel panelDate;
	private JLabel lblNewLabel_1;
	private JLabel lblDate;
	private JLabel lblNewLabel;
	private JLabel lblDescription;
	private JLabel lblDescription_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;


	public UserMenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMenuView.class.getResource("/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		initComponents();
		
		
	}
	
	private void initComponents() {
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
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(50, 58, 150, 150);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(UserMenuView.class.getResource("/images/aH-150px.png")));
		
	    btnRegister = new JPanel();
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setBackground(new Color(12, 138, 199));	
			}
		});
		btnRegister.setBounds(0, 255, 257, 56);
		btnRegister.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegister);
		btnRegister.setLayout(null);
		
		lblRegister = new JLabel("Registro de reservas");
		lblRegister.setIcon(new ImageIcon(UserMenuView.class.getResource("/images/reservado.png")));
		lblRegister.setForeground(SystemColor.text);
		lblRegister.setBounds(25, 11, 205, 34);
		lblRegister.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.add(lblRegister);
		
		btnSearch = new JPanel();
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(new Color(12, 138, 199));
			}
		});
		btnSearch.setBounds(0, 312, 257, 56);
		btnSearch.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnSearch);
		btnSearch.setLayout(null);
		
		lblBookingSearch = new JLabel("Búsqueda");
		lblBookingSearch.setIcon(new ImageIcon(UserMenuView.class.getResource("/images/pessoas.png")));
		lblBookingSearch.setBounds(27, 11, 200, 34);
		lblBookingSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblBookingSearch.setForeground(Color.WHITE);
		lblBookingSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnSearch.add(lblBookingSearch);
		
		separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
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
		btnExit.setBounds(891, 0, 53, 36);
		header.add(btnExit);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		btnExit.add(lblExit);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	    panelDate = new JPanel();
	    panelDate.setBackground(new Color(118, 187, 223));
	    panelDate.setBounds(256, 84, 688, 121);
	    contentPane.add(panelDate);
	    panelDate.setLayout(null);
	    
	    lblNewLabel_1 = new JLabel("Sistema de reservas Hotel Alura");
	    lblNewLabel_1.setBounds(180, 11, 356, 42);
	    panelDate.add(lblNewLabel_1);
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));
	    
	    lblDate = new JLabel("New label");
	    lblDate.setBounds(35, 64, 294, 36);
	    panelDate.add(lblDate);
	    lblDate.setForeground(Color.WHITE);
	    lblDate.setFont(new Font("Roboto", Font.PLAIN, 33));
	    Date actualDate = new Date(); //fecha y hora actual
	    String date = new SimpleDateFormat("dd/MM/yyyy").format(actualDate); //formatear la fecha en una cadena
	    lblDate.setText("Hoy es " + date); //setear la representacion en cadena de la fecha
	    
	    lblNewLabel = new JLabel("Bienvenido");
	    lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
	    lblNewLabel.setBounds(302, 234, 147, 46);
	    contentPane.add(lblNewLabel);
	    
	    String textDescription = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
	    lblDescription = new JLabel(textDescription);
	    lblDescription.setFont(new Font("Roboto", Font.PLAIN, 17));
	   
	    lblDescription.setBounds(312, 291, 598, 66);
	    contentPane.add(lblDescription);
	    
	    String textoDescripcion1 = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
	    lblDescription_1 = new JLabel(textoDescripcion1);
	    lblDescription_1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescription_1.setBounds(311, 345, 569, 88);
	    contentPane.add(lblDescription_1);
	    
	    lblNewLabel_3 = new JLabel("- Registro de Reservas y Huéspedes");
	    lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblNewLabel_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblNewLabel_3);
	    
	    lblNewLabel_3_1 = new JLabel("- Edición de Reservas y Huéspedes existentes");
	    lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblNewLabel_3_1.setBounds(312, 482, 355, 27);
	    contentPane.add(lblNewLabel_3_1);
	    
	    lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros");
	    lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblNewLabel_3_2.setBounds(312, 520, 295, 27);
	    contentPane.add(lblNewLabel_3_2);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
    
    public JPanel getBtnRegister() {
		return btnRegister;
	}
    
    public JPanel getBtnSearch() {
		return btnSearch;
	}
    
    
}

