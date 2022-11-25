package dad.MiCV.formacion;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {
	
	private ObjectProperty<LocalDate> desde = new SimpleObjectProperty<>();
	private ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	public ObjectProperty<LocalDate> getDesde() {
		return desde;
	}
	public void setDesde(ObjectProperty<LocalDate> desde) {
		this.desde = desde;
	}
	public ObjectProperty<LocalDate> getHasta() {
		return hasta;
	}
	public void setHasta(ObjectProperty<LocalDate> hasta) {
		this.hasta = hasta;
	}
	public StringProperty getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(StringProperty denominacion) {
		this.denominacion = denominacion;
	}
	public StringProperty getOrganizador() {
		return organizador;
	}
	public void setOrganizador(StringProperty organizador) {
		this.organizador = organizador;
	}
}
