package org.mycnntacts.chcontacts;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.mycnntacts.chcontacts.datamodel.Contact;

public class HelloController {

	@FXML
	private TableView<Contact> contactTable;

	@FXML
	private TableColumn<Contact, String> firstNameCol;

	@FXML
	private TableColumn<Contact, String> lastNameCol;

	@FXML
	private TableColumn<Contact, String> phoneNumCol;

	@FXML
	private TableColumn<Contact, String> notesCol;

	@FXML
	public void initialize() {
//		 Resize policy to fill table width
		contactTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//		// Sample binding (if you're using a Contact class)

//		firstNameCol.cellFactoryProperty().bind(contactTable.getColumns().get(0));

//		firstNameCol.prefWidthProperty().bind(contactTable.widthProperty().multiply(0.2));
//		lastNameCol.prefWidthProperty().bind(contactTable.widthProperty().multiply(0.2));
//		phoneNumCol.prefWidthProperty().bind(contactTable.widthProperty().multiply(0.2));
//		notesCol.prefWidthProperty().bind(contactTable.widthProperty().multiply(0.4));

	}

}