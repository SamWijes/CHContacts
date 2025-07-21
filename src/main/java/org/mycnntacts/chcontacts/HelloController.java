package org.mycnntacts.chcontacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

		contactTable.setItems(data.getContacts());
//		contactTable.setItems(contactList);
//		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
//		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
//		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));
//		contactList.add(new Contact("Jhon", "Doe", "875-9658", "first"));

//		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
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
//			contactList.add(contact);
			data.addContact(contact);
			data.saveContacts();
		}
//		dialog.show();
	}

	public void showEditContactDialog() throws IOException {
		Contact selectedContact=contactTable.getSelectionModel().getSelectedItem();

		if (selectedContact==null){
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Not Selected");
			alert.setHeaderText("Select A Contact");
			alert.setContentText("PlZ Select a contact you want to change");
			alert.showAndWait();
			return;
		}
		Dialog<ButtonType> editDialog=new Dialog<>();
		editDialog.initOwner(mainWindow.getScene().getWindow());
		FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("contactDialog.fxml"));
		editDialog.setHeaderText("Edit Contact");

		editDialog.getDialogPane().setContent(fxmlLoader.load());

		ContactDialogController controller=fxmlLoader.getController();
		controller.editContact(selectedContact);


		editDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CANCEL);
		Optional<ButtonType> choice=editDialog.showAndWait();


		if (choice.isPresent() && choice.get()==ButtonType.OK ) {
			controller.updateContact(selectedContact);
			contactTable.refresh();
//			data.deleteContact(selectedContact);
//			data.addContact(contact);
			data.saveContacts();

		}

	}



	public void deleteContact(){
		Contact contact=contactTable.getSelectionModel().getSelectedItem();
		contactList.remove(contact);
	}


}