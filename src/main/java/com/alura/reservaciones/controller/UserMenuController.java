package com.alura.reservaciones.controller;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.view.UserMenuView;


public class UserMenuController {
	private UserMenuView userMenuView;
	private MyGUI myGUI;
	
	public UserMenuController() {
		this.userMenuView = new UserMenuView();
		this.myGUI = new MyGUI(this.userMenuView);
		
		addEventListeners();
		
	}
	
	public void show() {
		this.userMenuView.setVisible(true);
	}
	
	private void addEventListeners() {
		this.userMenuView.getBtnRegister().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openBookingView();
			}
		});
		
		this.userMenuView.getBtnSearch().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openSearchView();
			}
		});
		
		this.userMenuView.getBtnExit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
	}
	
	private void close() {
		boolean isConfirmedLogOut = this.myGUI.showConfirmDialog("¿Esta seguro que desea cerrar sesión?");
		if(isConfirmedLogOut) {
			this.userMenuView.dispose();
			PrincipalMenuController principalMenuController = new PrincipalMenuController();
			principalMenuController.show();
		}
	}
	private void openBookingView() {
		BookingController bookingController = new BookingController();
		bookingController.show();
		this.userMenuView.dispose();
	}
	
	private void openSearchView() {
		SearchController searchController = new SearchController();
		searchController.show();
		this.userMenuView.dispose();
	}
	

}
