package com.alura.reservaciones.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alura.reservaciones.model.User;

public class LoginDAO {
	final private Connection con;

	public LoginDAO(Connection con) {
		this.con = con;
	}

	public boolean checkUser(User user) {

		try (this.con) {
			String query = "SELECT * FROM user WHERE username = ? and aes_decrypt(password, ?) = ? ";
			final PreparedStatement statement = this.con.prepareStatement(query);

			try (statement) {
				statement.setString(1, user.getUsername());
				statement.setString(2, user.getUsername());
				statement.setString(3, user.getPassword());

				ResultSet result = statement.executeQuery();

				try (result) {
					return result.next();
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
