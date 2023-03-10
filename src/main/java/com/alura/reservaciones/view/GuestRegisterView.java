package com.alura.reservaciones.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.alura.reservaciones.enums.Nationalities;
import com.alura.reservaciones.utilities.MyColor;
import com.alura.reservaciones.utilities.MyDate;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class GuestRegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtPhoneNumber;
	private JTextField txtBookingId;
	private JDateChooser txtBirthDay;
	private JComboBox<Format> txtNationality;
	private JLabel lblExit;
	private JLabel lblBack;
	private JPanel header;
	private JPanel btnBack;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblBirthday;
	private JLabel lblNationality;
	private JLabel lblPhoneNumber;
	private JLabel lblTitle;
	private JLabel lblBookingId;
	private JSeparator separator_1_2;
	private JSeparator separator_1_2_1;
	private JSeparator separator_1_2_2;
	private JSeparator separator_1_2_3;
	private JSeparator separator_1_2_4;
	private JSeparator separator_1_2_5;
	private JLabel lblSave;
	private JPanel btnSave;
	private JPanel panel;
	private JLabel imgBackground;
	private JLabel logo;
	private JPanel btnExit;
	private int xMouse, yMouse;
	private MyColor myColor;



	public GuestRegisterView() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GuestRegisterView.class.getResource("/images/lOGO-50PX.png")));
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		myColor = new MyColor();
		initComponents();
		

	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		btnBack = new JPanel();
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(Color.white);
				lblBack.setForeground(Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(myColor.getCustomBlue());
				lblBack.setForeground(Color.white);
			}
		});
		btnBack.setLayout(null);
		btnBack.setBackground(this.myColor.getCustomBlue());
		btnBack.setBounds(0, 0, 53, 36);
		header.add(btnBack);

		lblBack = new JLabel("<");
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblBack.setBounds(0, 0, 53, 36);
		btnBack.add(lblBack);

		txtName = new JTextField();
		txtName.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtName.setBounds(560, 135, 285, 33);
		txtName.setBackground(Color.WHITE);
		txtName.setColumns(10);
		txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtName);

		txtSurname = new JTextField();
		txtSurname.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSurname.setBounds(560, 204, 285, 33);
		txtSurname.setColumns(10);
		txtSurname.setBackground(Color.WHITE);
		txtSurname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtSurname);
		

		txtBirthDay = new JDateChooser(MyDate.parseDate("2000-07-14"));
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtBirthDay.getDateEditor();
		editor.setEnabled(false);
		editor.setBackground(Color.WHITE);
		editor.setDisabledTextColor(SystemColor.textHighlight);
		editor.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtBirthDay.setBounds(560, 278, 285, 36);
		txtBirthDay.getCalendarButton()
				.setIcon(new ImageIcon(GuestRegisterView.class.getResource("/images/icon-reservas.png")));
		txtBirthDay.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtBirthDay.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtBirthDay);

		txtNationality = new JComboBox<Format>();
		txtNationality.setBounds(560, 350, 289, 36);
		txtNationality.setBackground(SystemColor.text);
		txtNationality.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtNationality.setModel(new DefaultComboBoxModel(Nationalities.values()));
		contentPane.add(txtNationality);

		lblName = new JLabel("NOMBRE");
		lblName.setBounds(562, 119, 253, 14);
		lblName.setForeground(SystemColor.textInactiveText);
		lblName.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblName);

		lblSurname = new JLabel("APELLIDO");
		lblSurname.setBounds(560, 189, 255, 14);
		lblSurname.setForeground(SystemColor.textInactiveText);
		lblSurname.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblSurname);

		lblBirthday = new JLabel("FECHA DE NACIMIENTO");
		lblBirthday.setBounds(560, 256, 255, 14);
		lblBirthday.setForeground(SystemColor.textInactiveText);
		lblBirthday.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblBirthday);

		lblNationality = new JLabel("NACIONALIDAD");
		lblNationality.setBounds(560, 326, 255, 14);
		lblNationality.setForeground(SystemColor.textInactiveText);
		lblNationality.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblNationality);

		lblPhoneNumber = new JLabel("TEL??FONO");
		lblPhoneNumber.setBounds(562, 406, 253, 14);
		lblPhoneNumber.setForeground(SystemColor.textInactiveText);
		lblPhoneNumber.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblPhoneNumber);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPhoneNumber.setBounds(560, 424, 285, 33);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBackground(Color.WHITE);
		txtPhoneNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtPhoneNumber);

		lblTitle = new JLabel("REGISTRO HU??SPED");
		lblTitle.setBounds(598, 55, 239, 42);
		lblTitle.setForeground(this.myColor.getCustomBlue());
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitle);

		lblBookingId = new JLabel("N??MERO DE RESERVA");
		lblBookingId.setBounds(560, 474, 253, 14);
		lblBookingId.setForeground(SystemColor.textInactiveText);
		lblBookingId.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		contentPane.add(lblBookingId);

		txtBookingId = new JTextField();
		txtBookingId.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtBookingId.setBounds(560, 495, 285, 33);
		txtBookingId.setColumns(10);
		txtBookingId.setBackground(Color.WHITE);
		txtBookingId.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtBookingId.setEditable(false);
		contentPane.add(txtBookingId);

		separator_1_2 = new JSeparator();
		separator_1_2.setBounds(560, 170, 289, 2);
		separator_1_2.setForeground(this.myColor.getSeparatorColor());
		separator_1_2.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2);

		separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBounds(560, 240, 289, 2);
		separator_1_2_1.setForeground(this.myColor.getSeparatorColor());
		separator_1_2_1.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2_1);

		separator_1_2_2 = new JSeparator();
		separator_1_2_2.setBounds(560, 314, 289, 2);
		separator_1_2_2.setForeground(this.myColor.getSeparatorColor());
		separator_1_2_2.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2_2);

		separator_1_2_3 = new JSeparator();
		separator_1_2_3.setBounds(560, 386, 289, 2);
		separator_1_2_3.setForeground(this.myColor.getSeparatorColor());
		separator_1_2_3.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2_3);

		separator_1_2_4 = new JSeparator();
		separator_1_2_4.setBounds(560, 457, 289, 2);
		separator_1_2_4.setForeground(this.myColor.getSeparatorColor());
		separator_1_2_4.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2_4);

		separator_1_2_5 = new JSeparator();
		separator_1_2_5.setBounds(560, 529, 289, 2);
		separator_1_2_5.setForeground(this.myColor.getSeparatorColor());
		separator_1_2_5.setBackground(this.myColor.getSeparatorColor());
		contentPane.add(separator_1_2_5);

		btnSave = new JPanel();
		btnSave.setBounds(723, 560, 122, 35);
		btnSave.setLayout(null);
		btnSave.setBackground(this.myColor.getCustomBlue());
		contentPane.add(btnSave);
		btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		lblSave = new JLabel("GUARDAR");
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSave.setBounds(0, 0, 122, 35);
		btnSave.add(lblSave);

		panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(this.myColor.getCustomBlue());
		contentPane.add(panel);
		panel.setLayout(null);

		imgBackground = new JLabel("");
		imgBackground.setBounds(0, 121, 479, 502);
		panel.add(imgBackground);
		imgBackground.setIcon(new ImageIcon(GuestRegisterView.class.getResource("/images/registro.png")));

		logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panel.add(logo);
		logo.setIcon(new ImageIcon(GuestRegisterView.class.getResource("/images/Ha-100px.png")));


		btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				lblExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnExit.setBackground(Color.WHITE);
			     lblExit.setForeground(Color.black);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(857, 0, 53, 36);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(SystemColor.black);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnExit.add(lblExit);
		header.add(btnExit);
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

	public JTextField getTxtName() {
		return txtName;
	}

	public JTextField getTxtSurname() {
		return txtSurname;
	}

	public JTextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public JDateChooser getTxtBirthDay() {
		return txtBirthDay;
	}

	public JComboBox<Format> getTxtNationality() {
		return txtNationality;
	}

	public JPanel getBtnBack() {
		return btnBack;
	}

	public JPanel getBtnSave() {
		return btnSave;
	}

	public JTextField getTxtNreserva() {
		return txtBookingId;
	}

	public JPanel getBtnExit() {
		return btnExit;
	}
	
	
	
	
	

}
