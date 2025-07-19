module org.mycnntacts.chcontacts {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.xml;


	opens org.mycnntacts.chcontacts to javafx.fxml;
	exports org.mycnntacts.chcontacts;
	exports org.mycnntacts.chcontacts.datamodel;
	opens org.mycnntacts.chcontacts.datamodel to javafx.fxml;
}