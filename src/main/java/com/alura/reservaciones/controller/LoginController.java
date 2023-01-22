package com.alura.reservaciones.controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.alura.reservaciones.dao.LoginDAO;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.User;
import com.alura.reservaciones.view.LoginView;

public class LoginController {
	
	private LoginDAO loginDAO;
	private LoginView loginFrame;
	private User user;
	
	public LoginController(LoginView loginFrame) {
		this.loginFrame = loginFrame;
	}
	
	public LoginController() {
		this.loginFrame = new LoginView();
		this.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addEventListeners();
	}
	
	public void show() {
		this.loginFrame.setVisible(true);
	}
	
	public void addEventListeners() {
		this.loginFrame.getBtnLogin().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
	}
	
	private void login() {
		
		String username = this.loginFrame.getTxtUser().getText();
		String password = new String(this.loginFrame.getTxtPassword().getPassword()); 
		
		user = new User(username, password);	
		
		boolean userExists = checkUser(user);

		if (userExists) {
			openUserMenu();
		} else {
			JOptionPane.showMessageDialog(this.loginFrame, "Usuario o Contraseña no válidos");
		} 
		
	}
	
	private void openUserMenu() {
		UserMenuController userMenu = new UserMenuController();
		userMenu.show();
		this.loginFrame.dispose();
	}
	
	private boolean checkUser(User user) {
		loginDAO = new LoginDAO(new ConnectionFactory().createConnection());
		return loginDAO.checkUser(user);
	}
}
