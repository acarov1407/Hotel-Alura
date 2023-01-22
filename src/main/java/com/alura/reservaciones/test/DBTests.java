package com.alura.reservaciones.test;

import com.alura.reservaciones.dao.GuestDAO;
import com.alura.reservaciones.factory.ConnectionFactory;
import com.alura.reservaciones.model.Guest;

public class DBTests {
	public static void main(String[] args) {
		GuestDAO gd = new GuestDAO(new ConnectionFactory().createConnection());
		for(Guest guest : gd.getAllGuests()) {
			System.out.println(guest.getName());
		}
	}
}
