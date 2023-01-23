package com.alura.reservaciones.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alura.reservaciones.utilities.MyColor;

import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class PrincipalMenuView extends JFrame {

	private JPanel contentPane;
	private JLabel labelExit;
	private JPanel btnLogin;
	private Panel panel;
	private JLabel imgBackground;
	private JLabel logo;
	private JPanel panel_1;
	private JLabel lblCopyR;
	private JPanel header;
	private JPanel btnexit;
	private JLabel imgLogin;
	private JLabel lblTitle;
	private MyColor myColor;
	private int xMouse, yMouse;


	public PrincipalMenuView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalMenuView.class.getResource("/images/aH-40px.png")));
		setBounds(100, 100, 910, 537);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
				
		myColor = new MyColor();
		initComponents();
			
	}
	
	
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		panel = new Panel();
		panel.setBackground(Color.white);
		panel.setBounds(0, 0, 910, 537);
		contentPane.add(panel);
		panel.setLayout(null);
		
		imgBackground = new JLabel("");
		imgBackground.setBounds(-50, 0, 732, 501);
		imgBackground.setIcon(new ImageIcon(PrincipalMenuView.class.getResource("/images/menu-img.png")));
		panel.add(imgBackground);
		
		logo = new JLabel("");
		logo.setBackground(this.myColor.getCustomBlack());
		logo.setBounds(722, 80, 150, 156);
		logo.setIcon(new ImageIcon(PrincipalMenuView.class.getResource("/images/aH-150px.png")));
		panel.add(logo);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 910, 37);
		panel_1.setBackground(this.myColor.getCustomWhite());
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblCopyR = new JLabel("Desarrollado por Andrés Caro © 2023");
		lblCopyR.setBounds(315, 11, 284, 19);
		lblCopyR.setForeground(this.myColor.getCustomBlackBlue());
		lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_1.add(lblCopyR);
		
		//Barra para controlar la ventana 
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
		header.setBackground(this.myColor.getCustomWhite());
		panel.add(header);
		
		//Botón salir
		btnexit = new JPanel();
		btnexit.setBackground(this.myColor.getCustomWhite());
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(myColor.getCustomBlack());
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(myColor.getCustomWhite());
			     labelExit.setForeground(myColor.getCustomBlack());
			}
		});
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBackground(this.myColor.getCustomWhite());
		labelExit.setForeground(this.myColor.getCustomBlack());
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		//Botón Login
		btnLogin = new JPanel(); 
		btnLogin.setBounds(754, 300, 83, 70);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		panel.add(btnLogin);
		
		imgLogin = new JLabel("");
		imgLogin.setBackground(this.myColor.getCustomBlack());
		imgLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imgLogin);
		imgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imgLogin.setIcon(new ImageIcon(PrincipalMenuView.class.getResource("/images/login.png")));
		
		lblTitle = new JLabel("LOGIN");
		lblTitle.setBounds(754, 265, 83, 24);
		lblTitle.setBackground(SystemColor.window);
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Light", Font.PLAIN, 20));
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


	public JPanel getBtnexit() {
		return btnexit;
	}
    
    
}

