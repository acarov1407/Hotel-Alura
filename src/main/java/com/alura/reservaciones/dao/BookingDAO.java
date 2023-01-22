package com.alura.reservaciones.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.reservaciones.model.Booking;
import com.alura.reservaciones.model.Guest;
import com.alura.reservaciones.utilities.MyDate;

public class BookingDAO {
	final private Connection con;

	public BookingDAO(Connection con) {
		this.con = con;
	}

	public boolean saveBooking(Booking booking) throws SQLException {

		String query = "INSERT INTO booking(id, checkInDate, checkOutDate, price, paymentMethod, guestId) VALUES (?, ?, ?, ?, ?, ?)";
		final PreparedStatement statement = this.con.prepareStatement(query);

		try (statement) {

			statement.setString(1, booking.getId());
			statement.setDate(2, MyDate.javaDateToSQL(booking.getCheckIn()));
			statement.setDate(3, MyDate.javaDateToSQL(booking.getCheckOut()));
			statement.setBigDecimal(4, new BigDecimal(booking.getPrice()));
			statement.setString(5, booking.getPaymentMethod());
			statement.setInt(6, booking.getOwner().getId());

			int rowsAffected = statement.executeUpdate();

			return rowsAffected == 1;

		}

	}

	public List<Booking> getAllBookings() {
		
		List<Booking> bookings = new ArrayList<>();
		Booking booking;

		try {
			String query = "SELECT B.id, B.checkInDate, B.checkOutDate, B.price, B.paymentMethod, G.name, G.surname FROM booking AS B INNER JOIN guest as G where G.id = B.guestId";
			final PreparedStatement statement = this.con.prepareStatement(query);

			try (statement) {
				ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						booking = new Booking(resultSet.getString(1), resultSet.getDate(2),resultSet.getDate(3), resultSet.getDouble(4),
								resultSet.getString(5), new Guest(resultSet.getString(6), resultSet.getString(7)));
						bookings.add(booking);
					}

					return bookings;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Booking> getBookings(String search){
		List<Booking> bookings = new ArrayList<>();
		Booking booking;

		try {
			String query = "SELECT B.id, B.checkInDate, B.checkOutDate, B.price, B.paymentMethod, G.name, G.surname FROM booking AS B INNER JOIN guest as G where G.id = B.guestId"
					+ " AND CONCAT(G.name, ' ', G.surname) like ?";
			final PreparedStatement statement = this.con.prepareStatement(query);

			try (statement) {
				statement.setString(1, "%" + search + "%");
				ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						booking = new Booking(resultSet.getString(1), resultSet.getDate(2), resultSet.getDate(3), resultSet.getDouble(4),
								resultSet.getString(5), new Guest(resultSet.getString(6), resultSet.getString(7)));
						bookings.add(booking);
					}

					return bookings;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean deleteBooking(String id) {
		try {
			String query = "DELETE FROM booking WHERE id = ?";
			final PreparedStatement statement = this.con.prepareStatement(query);
			
			try(statement){
				statement.setString(1, id);
				int result = statement.executeUpdate();
				return result == 1;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean editBooking(Booking booking) {
		try {
			String query = "UPDATE booking SET checkInDate = ?, checkOutDate = ?, price = ?, paymentMethod = ? WHERE id = ?";
			final PreparedStatement statement = this.con.prepareStatement(query);
			
			try(statement){
				statement.setDate(1, MyDate.javaDateToSQL(booking.getCheckIn()));
				statement.setDate(2, MyDate.javaDateToSQL(booking.getCheckOut()));
				statement.setBigDecimal(3, new BigDecimal(booking.getPrice()));
				statement.setString(4, booking.getPaymentMethod());
				statement.setString(5, booking.getId());
				int result = statement.executeUpdate();
				return result == 1;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
