package org.mycnntacts.chcontacts;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.mycnntacts.chcontacts.datamodel.Contact;

public class ContactDialogController {


	@FXML public TextField fName;
	@FXML public TextField lName;
	@FXML public TextField phNum;
	@FXML public TextField notes;

	public Contact processInput() {
		return new Contact(fName.getText(), lName.getText(),phNum.getText(), notes.getText() );
	}

}
