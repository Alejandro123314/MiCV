package dad.MiCV.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Contacto {

	private ObjectProperty<Telefono> telefonos = new SimpleObjectProperty<>();
	private ObjectProperty<Email> emails = new SimpleObjectProperty<>();
	private ObjectProperty<Web> webs = new SimpleObjectProperty<>();

	public ObjectProperty<Web> getWebs() {
		return webs;
	}

	public void setWebs(ObjectProperty<Web> webs) {
		this.webs = webs;
	}

	public ObjectProperty<Email> getEmails() {
		return emails;
	}

	public void setEmails(ObjectProperty<Email> emails) {
		this.emails = emails;
	}

	public ObjectProperty<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ObjectProperty<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

}
