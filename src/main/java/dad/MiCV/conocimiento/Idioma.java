package dad.MiCV.conocimiento;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento {

	private StringProperty certificaion = new SimpleStringProperty();

	public final StringProperty certificaionProperty() {
		return this.certificaion;
	}
	

	public final String getCertificaion() {
		return this.certificaionProperty().get();
	}
	

	public final void setCertificaion(final String certificaion) {
		this.certificaionProperty().set(certificaion);
	}
	
	
}
