package com.lcode.web.jdbc;

public class Student {
	
	public int id;
	public String firstName;
	public String lastName;
	public String email;
	public boolean grad;
	
	
	public Student(int id, String firstName, String lastName, String email, boolean grad) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.grad = grad;
	}


	public Student(String firstName, String lastName, String email, boolean grad) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.grad = grad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isGrad() {
		return grad;
	}


	public void setGrad(boolean grad) {
		this.grad = grad;
	}
	
	
	

}
