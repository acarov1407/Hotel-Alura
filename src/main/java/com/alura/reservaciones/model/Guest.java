package com.alura.reservaciones.model;

import java.util.Date;

public class Guest {
	private Integer id;
	private String name;
	private String surname;
	private Date birthDay;
	private String nationality;
	private String phoneNumber;

	
	public Guest(Integer id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public Guest(String name, String surname, Date birthDay, String nationality, String phoneNumber) {
		this.name = name;
		this.surname = surname;
		this.birthDay = birthDay;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
	}
	
	public Guest(Integer id, String name, String surname, Date birthDay, String nationality, String phoneNumber) {
		this(name, surname, birthDay, nationality, phoneNumber);
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getNationality() {
		return nationality;
	}
	

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		return String.format("%s %s", this.name, this.surname);
	}
	
	
	
}
