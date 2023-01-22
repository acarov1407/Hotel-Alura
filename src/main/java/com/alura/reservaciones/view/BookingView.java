package com.alura.reservaciones.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import com.alura.reservaciones.enums.PaymentMethods;
import com.alura.reservaciones.utilities.MyDate;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.text.Format;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class BookingView extends JFrame {

	private JPanel contentPane;
	public JTextField txtPrice;
	public JDateChooser txtCheckInDate;
	public JDateChooser txtCheckOutDate;
	public JComboBox<Format> txtPaymentMethod;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel lblPriceSymbol; 
	private JLabel lblBack;
	private JPanel panel;
	private JSeparator separator_1_2;
	private JSeparator separator_1_3;
	private JSeparator separator_1_1;
	private JLabel lblCheckIn;
	private JLabel lblCheckOut;
	private JLabel lblPrice;
	private JLabel lblPaymentMethod;
	private JLabel lblTitle;
	private JPanel panel_1;
	private JLabel logo;
	private JLabel imgBackground;
	private JPanel btnExit;
	private JPanel header;
	private JPanel btnBack;
	private JSeparator separator_1;
	private JPanel btnNext;
	private JLabel lblNext;
            
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BookingView() {
		super("Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookingView.class.getResource("/images/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		txtCheckInDate = new JDateChooser(new Date());
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtCheckInDate.getDateEditor();
		editor.setEnabled(false);
		editor.setBackground(new Color(255, 255, 255));
		editor.setDisabledTextColor(SystemColor.textHighlight);
		txtCheckInDate.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtCheckInDate.getCalendarButton().setIcon(new ImageIcon(BookingView.class.getResource("/images/icon-reservas.png")));
		txtCheckInDate.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtCheckInDate.setBounds(68, 161, 289, 35);
		txtCheckInDate.getCalendarButton().setBounds(268, 0, 21, 33);
		txtCheckInDate.setBackground(Color.WHITE);
		txtCheckInDate.setBorder(new LineBorder(SystemColor.window));
		txtCheckInDate.setDateFormatString("yyyy-MM-dd");
		txtCheckInDate.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtCheckInDate);
		
		lblPriceSymbol = new JLabel("$");
		lblPriceSymbol.setVisible(false);
		lblPriceSymbol.setBounds(121, 332, 17, 25);
		lblPriceSymbol.setForeground(SystemColor.textHighlight);
		lblPriceSymbol.setFont(new Font("Roboto", Font.BOLD, 17));
		
		panel.add(lblPriceSymbol);
		
		lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		
		txtCheckOutDate = new JDateChooser(MyDate.getTomorrowDate(null));
		JTextFieldDateEditor editor_2 = (JTextFieldDateEditor) txtCheckOutDate.getDateEditor();
		editor_2.setEnabled(false);
		editor_2.setBackground(new Color(255, 255, 255));
		editor_2.setDisabledTextColor(SystemColor.textHighlight);
		txtCheckOutDate.getCalendarButton().setIcon(new ImageIcon(BookingView.class.getResource("/images/icon-reservas.png")));
		txtCheckOutDate.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtCheckOutDate.setBounds(68, 246, 289, 35);
		txtCheckOutDate.getCalendarButton().setBounds(267, 1, 21, 31);
		txtCheckOutDate.setBackground(Color.WHITE);
		txtCheckOutDate.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtCheckOutDate.setDateFormatString("yyyy-MM-dd");
		txtCheckOutDate.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtCheckOutDate.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtCheckOutDate);
		
	
		
		txtPrice = new JTextField();
		txtPrice.setBackground(SystemColor.text);
		txtPrice.setHorizontalAlignment(SwingConstants.LEFT);
		txtPrice.setForeground(Color.BLACK);
		txtPrice.setBounds(78, 328, 200, 33);
		txtPrice.setEditable(false);
		txtPrice.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtPrice);
		txtPrice.setColumns(20);
		
		lblPrice = new JLabel("VALOR DE LA RESERVA");
		lblPrice.setForeground(SystemColor.textInactiveText);
		lblPrice.setBounds(72, 303, 196, 14);
		lblPrice.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblPrice);
		
		txtPaymentMethod = new JComboBox<Format>();
		txtPaymentMethod.setBounds(68, 417, 289, 38);
		txtPaymentMethod.setBackground(SystemColor.text);
		txtPaymentMethod.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtPaymentMethod.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPaymentMethod.setModel(new DefaultComboBoxModel(PaymentMethods.values()));
		panel.add(txtPaymentMethod);
		
		lblPaymentMethod = new JLabel("FORMA DE PAGO");
		lblPaymentMethod.setForeground(SystemColor.textInactiveText);
		lblPaymentMethod.setBounds(68, 382, 187, 24);
		lblPaymentMethod.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblPaymentMethod);
		
		lblTitle = new JLabel("SISTEMA DE RESERVAS");
		lblTitle.setBounds(109, 60, 219, 42);
		lblTitle.setForeground(new Color(12, 138, 199));
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitle);
		
		panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(BookingView.class.getResource("/images/Ha-100px.png")));
		
		imgBackground = new JLabel("");
		imgBackground.setBounds(0, 140, 500, 409);
		panel_1.add(imgBackground);
		imgBackground.setBackground(Color.WHITE);
		imgBackground.setIcon(new ImageIcon(BookingView.class.getResource("/images/reservas-img-3.png")));
		
		btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnExit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setBounds(429, 0, 53, 36);
		panel_1.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);
		
		btnBack = new JPanel();
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(12, 138, 199));
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
		lblBack.setBounds(0, 0, 53, 36);
		btnBack.add(lblBack);
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
		
		btnNext = new JPanel();
		btnNext.setLayout(null);
		btnNext.setBackground(SystemColor.textHighlight);
		btnNext.setBounds(238, 493, 122, 35);
		panel.add(btnNext);
		btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		lblNext = new JLabel("SIGUIENTE");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNext.setBounds(0, 0, 122, 35);
		btnNext.add(lblNext);
	}

	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
	    

		public JDateChooser getTxtCheckOutDate() {
			return txtCheckOutDate;
		}

		public JPanel getBtnBack() {
			return btnBack;
		}

		public JPanel getBtnNext() {
			return btnNext;
		}

		public JDateChooser getTxtCheckInDate() {
			return txtCheckInDate;
		}

		public JTextField getTxtPrice() {
			return txtPrice;
		}

		public JComboBox<Format> getTxtPaymentMethod() {
			return txtPaymentMethod;
		}
		
		

		
		
		
	    
	    
}

