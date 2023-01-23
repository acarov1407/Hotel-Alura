package com.alura.reservaciones.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alura.reservaciones.model.Guest;
import com.alura.reservaciones.utilities.MyDate;

public class GuestDAO {
final private Connection con;
	
	public GuestDAO(Connection con) {
		this.con = con;
	}
	
	public int saveGuest(Guest guest) {
		try {
			
			this.con.setAutoCommit(false);
			
			String query = "INSERT INTO guest(name, surname, birthday, nationality, phoneNumber) VALUES (?, ?, ?, ?, ?)";
			final PreparedStatement statement = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

			try (statement) {
				
				statement.setString(1, guest.getName());
				statement.setString(2,guest.getSurname());
				statement.setDate(3, MyDate.javaDateToSQL(guest.getBirthDay()));
				statement.setString(4, guest.getNationality());
				statement.setString(5, guest.getPhoneNumber());
				
				statement.execute();
			
				ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					int generatedId = 0;
					while(resultSet.next()) {
						generatedId = resultSet.getInt(1);
						break;
					}
					
					return generatedId;
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean editGuest(Guest guest) {
		try {
			String query = "UPDATE guest SET name = ?, surname = ?, birthday = ?, nationality = ?, phoneNumber = ? WHERE id = ?";
			final PreparedStatement statement = this.con.prepareStatement(query);
			
			try(statement){
				statement.setString(1, guest.getName());
				statement.setString(2, guest.getSurname());
				statement.setDate(3, MyDate.javaDateToSQL(guest.getBirthDay()));
				statement.setString(4, guest.getNationality());
				statement.setString(5, guest.getPhoneNumber());
				statement.setInt(6, guest.getId());
				int result = statement.executeUpdate();
				return result == 1;
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Guest> getAllGuests() {
		
		List<Guest> guests = new ArrayList<>();
		Guest guest;
		
		try {
			String query = "SELECT * FROM guest";
			final PreparedStatement statement = this.con.prepareStatement(query);	
			
			try(statement){
				ResultSet resultSet = statement.executeQuery();
				
				try(resultSet){
					while(resultSet.next()) {
						guest = new Guest(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
								resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6));
						guests.add(guest);
					}
					
					return guests;
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Guest> getGuests(String search) {
		List<Guest> guests = new ArrayList<>();
		Guest guest;
		
		try {
			String query = "SELECT * FROM guest WHERE concat(name,' ',surname) like ?";
			
			final PreparedStatement statement = this.con.prepareStatement(query);	
			
			try(statement){
				statement.setString(1, "%" + search + "%");
				ResultSet resultSet = statement.executeQuery();
				
				try(resultSet){
					while(resultSet.next()) {
						guest = new Guest(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
								resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6));
						guests.add(guest);
					}
					
					return guests;
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean deleteGuest(Integer id) throws SQLException {
		
			String query = "DELETE FROM guest WHERE id = ?";
			final PreparedStatement statement = this.con.prepareStatement(query);
			
			try(statement){
				statement.setInt(1, id);
				int result = statement.executeUpdate();
				return result == 1;
			}
			
	}
	
	public void toCommit() {
		try {
			this.con.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
