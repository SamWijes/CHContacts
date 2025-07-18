module org.mycnntacts.chcontacts {
	requires javafx.controls;
	requires javafx.fxml;


	opens org.mycnntacts.chcontacts to javafx.fxml;
	exports org.mycnntacts.chcontacts;
}