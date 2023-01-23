package com.alura.reservaciones.controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.view.PrincipalMenuView;

public class PrincipalMenuController {
	private PrincipalMenuView principalMenuFrame;
	private MyGUI myGUI;
	
	public PrincipalMenuController() {
		this.principalMenuFrame = new PrincipalMenuView();
		this.principalMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myGUI = new MyGUI(this.principalMenuFrame);
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
		
		this.principalMenuFrame.getBtnexit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
	}
	
	private void openLoginFrame() {
		LoginController loginController = new LoginController();
		loginController.show();
		this.principalMenuFrame.dispose();
	}
	
	private void close() {
		boolean isCloseConfirmed = this.myGUI.showConfirmDialog("¿Esta seguro que desea salir de la aplicación?");
		if(isCloseConfirmed) {
			System.exit(0);
		}
	}
}
