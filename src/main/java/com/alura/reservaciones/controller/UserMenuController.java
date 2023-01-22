package com.alura.reservaciones.controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import com.alura.reservaciones.view.UserMenuView;


public class UserMenuController {
	private UserMenuView menuUsuarioFrame;
	
	public UserMenuController() {
		this.menuUsuarioFrame = new UserMenuView();
		this.menuUsuarioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addEventListeners();
		
	}
	
	public void show() {
		this.menuUsuarioFrame.setVisible(true);
	}
	
	private void addEventListeners() {
		this.menuUsuarioFrame.getBtnRegister().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openBookingView();
			}
		});
		
		this.menuUsuarioFrame.getBtnSearch().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openSearchView();
			}
		});
	}
	
	private void openBookingView() {
		BookingController bookingController = new BookingController();
		bookingController.show();
		this.menuUsuarioFrame.dispose();
	}
	
	private void openSearchView() {
		SearchController searchController = new SearchController();
		searchController.show();
		this.menuUsuarioFrame.dispose();
	}
	

}
