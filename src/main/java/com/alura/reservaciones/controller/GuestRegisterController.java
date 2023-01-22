package com.alura.reservaciones.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.alura.reservaciones.dao.BookingDAO;
import com.alura.reservaciones.dao.GuestDAO;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.Booking;
import com.alura.reservaciones.model.Guest;
import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.view.GuestRegisterView;

public class GuestRegisterController {
	private GuestRegisterView guestRegisterView;
	private Booking booking;
	private Guest guest;
	private BookingDAO bookingDAO;
	private GuestDAO guestDAO;
	private MyGUI myGUI;

	public GuestRegisterController(Booking booking) {
		this.guestRegisterView = new GuestRegisterView();
		this.booking = booking;
		this.guestRegisterView.getTxtNreserva().setText(this.booking.getId());
		
		this.myGUI = new MyGUI(this.guestRegisterView);
		
		addEventListeners();
	}

	public void show() {
		this.guestRegisterView.setVisible(true);
	}

	private void addEventListeners() {
		this.guestRegisterView.getBtnBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});

		this.guestRegisterView.getBtnSave().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleSave();
			}
		});

		this.guestRegisterView.getBtnExit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
		});
	}

	private void back() {
		BookingController bookingController = new BookingController();
		bookingController.show();
		this.guestRegisterView.dispose();
	}

	private void exit() {
		PrincipalMenuController principalMenuController = new PrincipalMenuController();
		principalMenuController.show();
		this.guestRegisterView.dispose();
	}

	private void openSuccessView() {
		this.guestRegisterView.dispose();
		SuccessController successController = new SuccessController();
		successController.show();
	}

	private void handleSave() {

		getGuestData();

		if (validateForm()) {
			saveData();
			openSuccessView();
		}
	}
	
	private void saveData() {
		Connection con = new ConnectionFactory().createConnection();
		
		try {
			saveGuest(con);
			saveBooking(con);
			this.guestDAO.commitSave();
		}catch(SQLException e) {
			this.myGUI.showMessage("Ha ocurrido un error al intentar registar los datos!");
			throw new RuntimeException(e);
		}
				
		
	}

	private void saveBooking(Connection con) throws SQLException {
			bookingDAO = new BookingDAO(con);
			bookingDAO.saveBooking(this.booking);	

	}

	private void saveGuest(Connection con) {
		guestDAO = new GuestDAO(con);
		Integer guestId = guestDAO.saveGuest(this.guest);
		this.guest.setId(guestId); 
		this.booking.setOwner(this.guest);
	}

	private void getGuestData() {

		String name = this.guestRegisterView.getTxtName().getText();
		String surname = this.guestRegisterView.getTxtSurname().getText();
		Date birthday = this.guestRegisterView.getTxtBirthDay().getDate();
		String nationality = this.guestRegisterView.getTxtNationality().getSelectedItem().toString();
		String phoneNumber = this.guestRegisterView.getTxtPhoneNumber().getText();
		guest = new Guest(name, surname, birthday, nationality, phoneNumber);

	}

	private boolean validateForm() {

		return this.myGUI.validateGuestForm(this.guest);
	}



}
