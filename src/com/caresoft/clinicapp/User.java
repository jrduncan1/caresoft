package com.caresoft.clinicapp;

public class User {
	protected Integer id;
	protected int pin;
	
	// Constructor
	public User(Integer id) {
		super();
		this.id = id;
//		this.pin = pin;
	}
	
	// Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	// TO DO: Getters and setters -DONE
	// Implement a constructor that takes an ID
}
