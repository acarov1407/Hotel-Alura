package com.alura.reservaciones.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.alura.reservaciones.dao.LoginDAO;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.User;
import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.view.LoginView;

public class LoginController {

	private LoginDAO loginDAO;
	private LoginView loginView;
	private User user;
	private MyGUI myGUI;


	public LoginController() {
		this.loginView = new LoginView();
		this.myGUI = new MyGUI(this.loginView);
		addEventListeners();
	}

	public void show() {
		this.loginView.setVisible(true);
	}

	public void addEventListeners() {
		this.loginView.getBtnLogin().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});

		this.loginView.getBtnexit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
	}

	private void close() {
		this.loginView.dispose();
		PrincipalMenuController principalMenuController = new PrincipalMenuController();
		principalMenuController.show();
	}

	private void login() {

		String username = this.loginView.getTxtUser().getText();
		String password = new String(this.loginView.getTxtPassword().getPassword());

		user = new User(username, password);

		boolean userExists = checkUser(user);

		if (userExists) {
			openUserMenu();
		} else {
			this.myGUI.showMessage("Usuario o contraseña no válidos");
		}

	}

	private void openUserMenu() {
		UserMenuController userMenu = new UserMenuController();
		userMenu.show();
		this.loginView.dispose();
	}

	private boolean checkUser(User user) {
		loginDAO = new LoginDAO(new ConnectionFactory().createConnection());
		return loginDAO.checkUser(user);
	}

}
