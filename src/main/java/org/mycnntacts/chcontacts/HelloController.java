package org.mycnntacts.chcontacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

	private ObservableList<Contact> contactList= FXCollections.observableArrayList();

	@FXML
	public void initialize() {
//		 Resize policy to fill table width
		contactTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		contactTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		contactTable.setItems(contactList);
		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));

		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		notesCol.setCellValueFactory(new PropertyValueFactory<>("notes"));


	}

}