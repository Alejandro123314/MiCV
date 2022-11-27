package dad.MiCV.conocimiento;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	private StringProperty denominacion = new SimpleStringProperty();
	private ObjectProperty<Niveles> nivel = new SimpleObjectProperty<>();

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}

	public ObjectProperty<Niveles> getNivel() {
		return nivel;
	}

	public void setNivel(ObjectProperty<Niveles> nivel) {
		this.nivel = nivel;
	}

}
