package dad.MiCV.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
	
	private StringProperty Email = new SimpleStringProperty();

	public final StringProperty EmailProperty() {
		return this.Email;
	}
	

	public final String getEmail() {
		return this.EmailProperty().get();
	}
	

	public final void setEmail(final String Email) {
		this.EmailProperty().set(Email);
	}
	

}
