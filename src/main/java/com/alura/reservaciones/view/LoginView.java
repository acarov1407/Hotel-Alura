package com.alura.reservaciones.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.reservaciones.utilities.MyColor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel imgHotel;
	private JPanel header;
	private JPanel btnLogin;
	private JPanel btnexit;
	private JSeparator separator;
	private JLabel lblTitle;
	private JSeparator separator_1;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	int xMouse, yMouse;
	private JLabel labelExit;
	private MyColor myColor;


	public LoginView() {
		super("Login");
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		myColor = new MyColor();
		initComponents();
			
	}


	
	private void initComponents() {
		panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(this.myColor.getCustomBlue());
		panel_1.setBounds(484, 0, 304, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		imgHotel = new JLabel("");
		imgHotel.setBounds(0, 0, 304, 538);
		panel_1.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(LoginView.class.getResource("/images/img-hotel-login-.png")));
		
		btnexit = new JPanel();
		btnexit.setBounds(251, 0, 53, 36);
		panel_1.add(btnexit);
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(myColor.getCustomBlue());
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setBackground(this.myColor.getCustomBlue());
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);		
		
		txtUser = new JTextField();
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
					 txtUser.setText("");
					 txtUser.setForeground(Color.black);
			        }
			        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			        	txtPassword.setText("********");
			        	txtPassword.setForeground(Color.gray);
			        }
			}
		});
		txtUser.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUser.setForeground(SystemColor.activeCaptionBorder);
		txtUser.setBounds(65, 256, 324, 32);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		separator = new JSeparator();
		separator.setBackground(this.myColor.getSeparatorColor());
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);
		
		lblTitle = new JLabel("INICIAR SESIÓN");
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		lblTitle.setBounds(65, 149, 202, 26);
		panel.add(lblTitle);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 393, 324, 2);
		panel.add(separator_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("********");
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPassword.getPassword()).equals("********")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
		        }
		        if (txtUser.getText().isEmpty()) {
		        	txtUser.setText("passsword");
		        	txtUser.setForeground(Color.gray);
		        }
			}
		});
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtPassword.setBounds(65, 353, 324, 32);
		panel.add(txtPassword);
		
		lblUser = new JLabel("USUARIO");
		lblUser.setForeground(SystemColor.textInactiveText);
		lblUser.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblUser.setBounds(65, 219, 107, 26);
		panel.add(lblUser);
		
		lblPassword = new JLabel("CONTRASEÑA");
		lblPassword.setForeground(SystemColor.textInactiveText);
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblPassword.setBounds(65, 316, 140, 26);
		panel.add(lblPassword);
		
		btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
		});
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		lblNewLabel = new JLabel("ENTRAR");
		lblNewLabel.setBounds(0, 0, 122, 44);
		btnLogin.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/images/lOGO-50PX.png")));
		lblNewLabel_1.setBounds(65, 65, 48, 59);
		panel.add(lblNewLabel_1);
		
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 784, 36);
		panel.add(header);
		header.setLayout(null);
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

	public JPanel getBtnLogin() {
		return this.btnLogin;
	}
	public JTextField getTxtUser() {
		return txtUser;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}



	public JPanel getBtnexit() {
		return btnexit;
	}
	
	
	

}
