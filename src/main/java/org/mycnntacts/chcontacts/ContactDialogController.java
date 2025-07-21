package org.mycnntacts.chcontacts;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.mycnntacts.chcontacts.datamodel.Contact;

public class ContactDialogController {


	@FXML private TextField fName;
	@FXML private TextField lName;
	@FXML private TextField phNum;
	@FXML private TextField notes;

	public Contact processInput() {
		return new Contact(fName.getText(), lName.getText(),phNum.getText(), notes.getText() );
	}

	public void updateContact(Contact contact) {
		contact.setFirstName(fName.getText());
		contact.setLastName(lName.getText());
		contact.setPhoneNumber(phNum.getText());
		contact.setNotes(notes.getText());
	}
	public void editContact(Contact contact) {
		fName.setText(contact.getFirstName());
		lName.setText(contact.getLastName());
		phNum.setText(contact.getPhoneNumber());
		notes.setText(contact.getNotes());
	}
}
