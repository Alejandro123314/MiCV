package dad.MiCV.conocimiento;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	private StringProperty denominacion = new SimpleStringProperty();
	private ObjectProperty<Niveles> nivel = new SimpleObjectProperty<>();
	
	public StringProperty getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(StringProperty denominacion) {
		this.denominacion = denominacion;
	}
	public ObjectProperty<Niveles> getNivel() {
		return nivel;
	}
	public void setNivel(ObjectProperty<Niveles> nivel) {
		this.nivel = nivel;
	}

	

}
