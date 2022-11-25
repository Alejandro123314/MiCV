package dad.MiCV.contacto;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {

	private StringProperty numero = new SimpleStringProperty();
	private ObjectProperty<TipoTelefono> personal = new SimpleObjectProperty<>();

	public final StringProperty numeroProperty() {
		return this.numero;
	}

	public final String getNumero() {
		return this.numeroProperty().get();
	}

	public final void setNumero(final String numero) {
		this.numeroProperty().set(numero);
	}

	public ObjectProperty<TipoTelefono> getPersonal() {
		return personal;
	}

	public void setPersonal(ObjectProperty<TipoTelefono> personal) {
		this.personal = personal;
	}

}
