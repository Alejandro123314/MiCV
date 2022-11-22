package dad.MiCV.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.Initializable;

public class ContactoController implements Initializable {

	IntegerProperty numero = new SimpleIntegerProperty();
	StringProperty direccion = new SimpleStringProperty();
	StringProperty url = new SimpleStringProperty();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
