package org.mycnntacts.chcontacts.datamodel;

public class Contact {
	private  String firstName;
	private  String lastName;
	private  String phoneNumber;
	private  String notes;

	public Contact() {
	}

	@Override
	public String toString() {
		return firstName;
	}

	public Contact(String firstName, String lastName, String phoneNumber, String notes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.notes = notes;
	}

	public void setFirstName(String data) {
		firstName=data;
	}

	public void setLastName(String data) {
		lastName=data;
	}

	public void setPhoneNumber(String data) {
		phoneNumber=data;
	}

	public void setNotes(String data) {
		notes=data;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getNotes() {
		return notes;
	}
}
