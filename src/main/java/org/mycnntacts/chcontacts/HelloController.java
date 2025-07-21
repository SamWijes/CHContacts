package org.mycnntacts.chcontacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;
import org.mycnntacts.chcontacts.datamodel.Contact;
import org.mycnntacts.chcontacts.datamodel.ContactData;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

public class HelloController {

	@FXML
	public GridPane mainWindow;
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

	private ContactData data;

	@FXML
	public void initialize() {
		data=new ContactData();
		data.loadContacts();
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


	public void showAddDialog() throws IOException {

		Dialog<ButtonType> dialog=new Dialog<>();
		dialog.setTitle("Add Contact");
		dialog.initOwner(mainWindow.getScene().getWindow());
//		Parent root=FXMLLoader.load(getClass().getResource("contactDialog.fxml"));
		FXMLLoader loader=new FXMLLoader(getClass().getResource("contactDialog.fxml"));
		dialog.getDialogPane().setContent(loader.load());

		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
		Optional<ButtonType> result=dialog.showAndWait();
		if (result.isPresent() && result.get()==ButtonType.OK){

			ContactDialogController controller = loader.getController();
			Contact contact= controller.processInput();
			contactList.add(contact);
			data.saveContacts();
		}
//		dialog.show();
	}

	public void deleteContact(){
		Contact contact=contactTable.getSelectionModel().getSelectedItem();
		contactList.remove(contact);
	}


}