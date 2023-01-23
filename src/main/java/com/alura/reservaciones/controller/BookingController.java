package com.alura.reservaciones.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;
import com.alura.reservaciones.model.Booking;
import com.alura.reservaciones.utilities.MyDate;
import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.utilities.MyUtilities;
import com.alura.reservaciones.view.BookingView;

public class BookingController {

	private BookingView bookingView;
	private Booking booking;
	private MyGUI myGUI;

	public BookingController() {
		this.bookingView = new BookingView();
		this.myGUI = new MyGUI(this.bookingView);

		addEventListeners();

		handleCheckOutChange();
	}

	private void addEventListeners() {

		this.bookingView.getTxtCheckOutDate().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				String propertyName = evt.getPropertyName();
				if ("date".equals(propertyName)) {
					handleCheckOutChange();
				}
			}
		});
		;

		this.bookingView.getBtnBack().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});

		this.bookingView.getBtnNext().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleNextButton();
			}
		});

		this.bookingView.getBtnExit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
	}

	public void show() {
		this.bookingView.setVisible(true);
		;
	}

	private void resetForm() {

		this.bookingView.getTxtCheckInDate().setDate(new Date());
		this.bookingView.getTxtCheckOutDate().setDate(MyDate.getTomorrowDate(null));
		this.bookingView.txtPaymentMethod.setSelectedIndex(0);
	}

	private void back() {

		boolean isConfirmedAbort = this.myGUI.showConfirmDialog("¿Esta seguro que quiere volver al menú principal?");

		if (isConfirmedAbort) {
			this.bookingView.dispose();
			UserMenuController userMenuController = new UserMenuController();
			userMenuController.show();
		}

	}

	private void close() {
		back();
	}

	private void handleCheckOutChange() {
		getBookingDatesData();
		setBookingPrice();
	}

	private void handleNextButton() {
		getBookingData();
		if (validateDates())
			openGuestRegisterView();
	}

	private void openGuestRegisterView() {

		GuestRegisterController guestRegisterController = new GuestRegisterController(this.booking);
		guestRegisterController.show();
		this.bookingView.dispose();
	}

	public void setBookingPrice() {

		if (validateDates()) {
			this.bookingView.getTxtPrice()
					.setText(MyUtilities.formatMoney(this.booking.getPrice(), new Locale("es", "CO")));
		}

	}

	private boolean validateDates() {

		boolean areValidDates = MyDate.validateDates(this.booking.getCheckIn(), this.booking.getCheckOut());

		if (!areValidDates) {
			this.myGUI.showMessage("Debe introducir fechas válidas");
			this.resetForm();
			return false;
		}

		return true;
	}

	private void getBookingData() {
		getBookingDatesData();
		booking.setPaymentMethod(this.bookingView.getTxtPaymentMethod().getSelectedItem().toString());
	}

	private void getBookingDatesData() {
		booking = new Booking(this.bookingView.getTxtCheckInDate().getDate(),
				this.bookingView.getTxtCheckOutDate().getDate());
	}

}
