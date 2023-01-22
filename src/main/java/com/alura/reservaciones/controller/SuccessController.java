package com.alura.reservaciones.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.alura.reservaciones.view.SuccessView;


public class SuccessController {
	private SuccessView successView;
	
	public SuccessController() {
		successView = new SuccessView();
		addEventListeners();
	}
	
	public void show() {
		this.successView.setVisible(true);
	}
	
	private void addEventListeners() {
		this.successView.getBtnOk().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPrincipalMenu();
			}
		});
	}
	
	private void openPrincipalMenu() {
		this.successView.dispose();
		UserMenuController userMenuController = new UserMenuController();
		userMenuController.show();
		
	}
}
