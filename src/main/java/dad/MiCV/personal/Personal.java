package dad.MiCV.personal;

import java.time.LocalDate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Personal {
	
	private StringProperty identificaion = new SimpleStringProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellidos = new SimpleStringProperty();
	private StringProperty direccion = new SimpleStringProperty();
	private StringProperty codigoPostal = new SimpleStringProperty();
	private StringProperty loacalidad = new SimpleStringProperty();
	private StringProperty pais = new SimpleStringProperty();
	private ObjectProperty<LocalDate> fechaNacimiento = new SimpleObjectProperty<>( LocalDate.now());
	private ListProperty<Nacionalidad> nacionalidades = new SimpleListProperty<>();
	
	public final StringProperty identificaionProperty() {
		return this.identificaion;
	}
	
	public final String getIdentificaion() {
		return this.identificaionProperty().get();
	}
	
	public final void setIdentificaion(final String identificaion) {
		this.identificaionProperty().set(identificaion);
	}
	
	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public final String getNombre() {
		return this.nombreProperty().get();
	}
	
	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	
	public final StringProperty apellidosProperty() {
		return this.apellidos;
	}
	
	public final String getApellidos() {
		return this.apellidosProperty().get();
	}
	
	public final void setApellidos(final String apellidos) {
		this.apellidosProperty().set(apellidos);
	}
	
	public final StringProperty direccionProperty() {
		return this.direccion;
	}
	
	public final String getDireccion() {
		return this.direccionProperty().get();
	}
	
	public final void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}
	
	public final StringProperty codigoPostalProperty() {
		return this.codigoPostal;
	}
	
	public final String getCodigoPostal() {
		return this.codigoPostalProperty().get();
	}
	
	public final void setCodigoPostal(final String codigoPostal) {
		this.codigoPostalProperty().set(codigoPostal);
	}
	
	public final StringProperty loacalidadProperty() {
		return this.loacalidad;
	}
	
	public final String getLoacalidad() {
		return this.loacalidadProperty().get();
	}
	
	public final void setLoacalidad(final String loacalidad) {
		this.loacalidadProperty().set(loacalidad);
	}
	
	public final StringProperty paisProperty() {
		return this.pais;
	}
	
	public final String getPais() {
		return this.paisProperty().get();
	}
	
	public final void setPais(final String pais) {
		this.paisProperty().set(pais);
	}
	
	public final ObjectProperty<LocalDate> fechaNacimientoProperty() {
		return this.fechaNacimiento;
	}
	
	public final LocalDate getFechaNacimiento() {
		return this.fechaNacimientoProperty().get();
	}
	
	public final void setFechaNacimiento(final LocalDate fechaNacimiento) {
		this.fechaNacimientoProperty().set(fechaNacimiento);
	}
	
	public final ListProperty<Nacionalidad> nacionalidadesProperty() {
		return this.nacionalidades;
	}
	
	public final ObservableList<Nacionalidad> getNacionalidades() {
		return this.nacionalidadesProperty().get();
	}
	
	public final void setNacionalidades(final ObservableList<Nacionalidad> nacionalidades) {
		this.nacionalidadesProperty().set(nacionalidades);
	}
	
}
