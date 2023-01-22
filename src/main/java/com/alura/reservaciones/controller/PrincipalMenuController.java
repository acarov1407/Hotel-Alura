package com.alura.reservaciones.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.alura.reservaciones.view.PrincipalMenuView;

public class PrincipalMenuController {
	private PrincipalMenuView principalMenuFrame;
	
	public PrincipalMenuController(PrincipalMenuView principalMenuFrame) {
		this.principalMenuFrame = principalMenuFrame;
	}
	
	public PrincipalMenuController() {
		this.principalMenuFrame = new PrincipalMenuView();
		this.principalMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addEventListeners();
	}
	
	public void show() {
		this.principalMenuFrame.setVisible(true);
	}
	
	private void addEventListeners() {
		
		this.principalMenuFrame.getBtnLogin().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					openLoginFrame();
			}
		});
	}
	
	private void openLoginFrame() {
		LoginController loginController = new LoginController();
		loginController.show();
		this.principalMenuFrame.dispose();
	}
}
