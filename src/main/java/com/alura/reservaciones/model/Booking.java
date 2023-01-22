package com.alura.reservaciones.model;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import com.alura.reservaciones.utilities.MyDate;
import com.alura.reservaciones.utilities.MyUtilities;

public class Booking {
	private String id;
	private Date checkIn;
	private Date checkOut;
	private Double price;
	private String paymentMethod;
	private Guest owner;
	private final Double dailyTax = 150000.00;

	public Booking(String id, Date checkIn, Date checkOut, Double price, String paymentMethod, Guest owner) {

		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
		this.paymentMethod = paymentMethod;
		this.owner = owner;

	}

	public Booking(String id, Date checkIn, Date checkOut,  String paymentMethod) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.paymentMethod = paymentMethod;
	}

	public Booking(Date checkIn, Date checkOut) {

		this.id = UUID.randomUUID().toString();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = this.calculatePrice();

	}

	private int getTimeInDays() {
		return MyDate.calculateDaysBetween(checkIn, checkOut);

	}

	public double calculatePrice() {
		return this.dailyTax * this.getTimeInDays();
	}
	
	public String getFormatedPrice() {
		return MyUtilities.formatMoney(this.price, new Locale("es", "CO"));
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public Double getPrice() {
		return price;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public String getId() {
		return this.id;
	}

	public Guest getOwner() {
		return this.owner;
	}
	

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setOwner(Guest owner) {
		this.owner = owner;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return this.checkIn.toString() + this.checkOut.toString() + this.price + this.paymentMethod;
	}

}
