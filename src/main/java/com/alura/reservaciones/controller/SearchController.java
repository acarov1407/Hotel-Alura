package com.alura.reservaciones.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.alura.reservaciones.dao.BookingDAO;
import com.alura.reservaciones.dao.GuestDAO;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.Booking;
import com.alura.reservaciones.model.Guest;
import com.alura.reservaciones.utilities.MyDate;
import com.alura.reservaciones.utilities.MyGUI;
import com.alura.reservaciones.view.SearchView;

public class SearchController {
	private SearchView searchView;
	private GuestDAO guestDAO;
	private BookingDAO bookingDAO;
	private MyGUI myGUI;
	private Connection con;

	public SearchController() {
		this.searchView = new SearchView();
		this.con = new ConnectionFactory().createConnection();
		this.myGUI = new MyGUI(this.searchView);
		
		this.guestDAO = new GuestDAO(this.con);
		this.bookingDAO = new BookingDAO(this.con);
		addEventListeners();
	}

	public void show() {
		this.searchView.setVisible(true);
	}

	private void addEventListeners() {
		this.searchView.getBtnBack().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});

		this.searchView.getBtnExit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});

		this.searchView.getBtnSearch().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleSearch();
			}
		});

		this.searchView.getBtnDelete().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleDelete();
			}
		});

		this.searchView.getBtnEdit().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleEdit();
			}
		});
	}

	private void back() {
		this.searchView.dispose();
		UserMenuController userMenu = new UserMenuController();
		userMenu.show();
	}

	private void close() {
		back();
	}

	private void handleSearch() {
		String search = this.searchView.getTxtSearch().getText().trim();

		int tabIndex = this.searchView.getTabSearch().getSelectedIndex();

		switch (tabIndex) {
		case 0:
			if ("".equals(search))
				searchAllGuests();
			else
				searchGuest(search);
			break;
		case 1:
			if ("".equals(search))
				searchAllBookings();
			else
				searchBooking(search);
			break;
		default:
			break;
		}

	}

	private void searchGuest(String search) {
		List<Guest> guests = guestDAO.getGuests(search);

		showGuests(guests);
	}

	private void searchAllGuests() {
		List<Guest> guests = guestDAO.getAllGuests();

		showGuests(guests);

	}

	private void showGuests(List<Guest> guests) {

		clearGuests();

		if (guests.isEmpty()) {
			this.myGUI.showMessage("La busqueda no arrojo resultados");
			return;
		}

		for (Guest guest : guests) {
			this.searchView.getModelGuest().addRow(guest);
		}

	}

	private void searchBooking(String search) {
		List<Booking> bookings = bookingDAO.getBookings(search);

		showBookings(bookings);
	}

	private void searchAllBookings() {
		List<Booking> bookings = bookingDAO.getAllBookings();

		showBookings(bookings);
	}

	private void showBookings(List<Booking> bookings) {

		clearBookings();

		if (bookings.isEmpty()) {
			this.myGUI.showMessage("La busqueda no arrojo resultados");
			return;
		}

		for (Booking booking : bookings) {
			this.searchView.getModelBooking().addRow(booking);

		}

	}

	private void handleEdit() {

		int tabIndex = this.searchView.getTabSearch().getSelectedIndex();
		switch (tabIndex) {
		case 0:
			editGuest();
			break;
		case 1:
			editBooking();
			break;
		}
	}

	private void editGuest() {

		Guest guest = getSelectedGuestData();

		boolean isValidGuest = this.myGUI.validateGuestForm(guest);
		boolean isEdited = false;

		if (!isValidGuest) {
			return;
		}

		boolean confirmEdit = this.myGUI.showConfirmDialog("¿Esta seguro que desea guardar los cambios hechos?");

		if (!confirmEdit) {
			return;
		}

		isEdited = this.guestDAO.editGuest(guest);

		this.myGUI.showEditMessage(isEdited);

		searchAllGuests();

	}

	private void editBooking() {
		Booking booking = getSelectedBookingData();
		boolean isValidBooking = MyDate.validateDates(booking.getCheckIn(), booking.getCheckOut());

		if (!isValidBooking) {
			this.myGUI.showMessage("Debe introducir fechas válidas");
			return;
		}

		booking.setPrice(booking.calculatePrice());

		boolean confirmEdit = this.myGUI.showConfirmDialog("¿Esta seguro que desea guardar los cambios hechos?");

		if (!confirmEdit) {
			return;
		}

		boolean isEdited = this.bookingDAO.editBooking(booking);

		this.myGUI.showEditMessage(isEdited);

		searchAllBookings();

	}

	private void handleDelete() {

		boolean confirmDelete = this.myGUI.showConfirmDialog("¿Esta seguro que desea borrar este registro?");

		if (!confirmDelete)
			return;

		int tabIndex = this.searchView.getTabSearch().getSelectedIndex();
		switch (tabIndex) {
		case 0:
			this.myGUI.showMessage("Solo se permite eliminar reservas");
			break;
		case 1:
			deleteBooking();
			break;
		}
	}

	private Guest getSelectedBookingOwner() {

		int selectedRow = this.myGUI.getSelectedRow(this.searchView.getTbBooking());
		Guest guest = (Guest) this.searchView.getTbBooking().getValueAt(selectedRow, 5);
		return guest;
	}



	private void deleteBooking() {
		Integer ownerId = getSelectedBookingOwner().getId();
		
		try {
			boolean isDeletedBooking = this.bookingDAO.deleteBooking(getSelectedBookingId());	
			boolean isDeletedBookingOwner = this.guestDAO.deleteGuest(ownerId);
			if(isDeletedBooking && isDeletedBookingOwner) {
				this.bookingDAO.toCommit();
				this.bookingDAO.enableAutoCommit();
				this.myGUI.showDeleteBookingMessage(isDeletedBooking && isDeletedBookingOwner);
			}
			
		}catch(SQLException e) {
			this.myGUI.showMessage("Ha ocurrido un error al intentar eliminar la reserva");
			throw new RuntimeException(e);
		}finally {
			searchAllBookings();
		}	

	}

	private Integer getSelectedGuestId() {

		int selectedRow = this.myGUI.getSelectedRow(this.searchView.getTbGuest());

		Integer id = Integer.valueOf(String.valueOf(this.searchView.getTbGuest().getValueAt(selectedRow, 0)));
		return id;
	}

	private Guest getSelectedGuestData() {

		int selectedRow = this.myGUI.getSelectedRow(this.searchView.getTbGuest());

		Integer id = getSelectedGuestId();
		String name = String.valueOf(this.searchView.getTbGuest().getValueAt(selectedRow, 1));
		String surname = String.valueOf(this.searchView.getTbGuest().getValueAt(selectedRow, 2));
		Date birthDay = (Date) this.searchView.getTbGuest().getValueAt(selectedRow, 3);
		String nationality = String.valueOf(this.searchView.getTbGuest().getValueAt(selectedRow, 4));
		String phoneNumber = String.valueOf(this.searchView.getTbGuest().getValueAt(selectedRow, 5));

		Guest selectedGuest = new Guest(id, name, surname, birthDay, nationality, phoneNumber);

		return selectedGuest;
	}

	private String getSelectedBookingId() {

		int selectedRow = this.myGUI.getSelectedRow(this.searchView.getTbBooking());

		String id = String.valueOf(this.searchView.getTbBooking().getValueAt(selectedRow, 0));
		return id;
	}

	private Booking getSelectedBookingData() {

		int selectedRow = this.myGUI.getSelectedRow(this.searchView.getTbBooking());

		String id = getSelectedBookingId();
		Date checkIn = (Date) this.searchView.getTbBooking().getValueAt(selectedRow, 1);
		Date checkOut = (Date) this.searchView.getTbBooking().getValueAt(selectedRow, 2);

		String paymentMethod = String.valueOf(this.searchView.getTbBooking().getValueAt(selectedRow, 4));

		Booking selectedBooking = new Booking(id, checkIn, checkOut, paymentMethod);
		return selectedBooking;
	}

	private void clearGuests() {
		this.searchView.getModelGuest().clear();

	}

	private void clearBookings() {
		this.searchView.getModelBooking().clear();
	}

}
