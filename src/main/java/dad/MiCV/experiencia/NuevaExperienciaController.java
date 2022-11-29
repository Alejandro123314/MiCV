package dad.MiCV.experiencia;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NuevaExperienciaController implements Initializable {
	
	StringProperty denominacion = new SimpleStringProperty();
	StringProperty empleador = new SimpleStringProperty();
	ObjectProperty<LocalDate> desde = new SimpleObjectProperty<LocalDate>();
	ObjectProperty<LocalDate> hasta = new SimpleObjectProperty<LocalDate>();
	
	@FXML
    private TextField denominacionTextField;

    @FXML
    private DatePicker desdeDatePicker;

    @FXML
    private TextField empleadorTextField;

    @FXML
    private DatePicker hastaDatePicker;

    @FXML
    private GridPane root;
    
    public NuevaExperienciaController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoExperiencia.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	denominacion.bind(denominacionTextField.textProperty());
		empleador.bind(empleadorTextField.textProperty());
		desde.bind(desdeDatePicker.valueProperty());
		hasta.bind(hastaDatePicker.valueProperty());
		
	}

	public final StringProperty denominacionProperty() {
		return this.denominacion;
	}
	

	public final String getDenominacion() {
		return this.denominacionProperty().get();
	}
	

	public final void setDenominacion(final String denominacion) {
		this.denominacionProperty().set(denominacion);
	}
	

	public final StringProperty empleadorProperty() {
		return this.empleador;
	}
	

	public final String getEmpleador() {
		return this.empleadorProperty().get();
	}
	

	public final void setEmpleador(final String empleador) {
		this.empleadorProperty().set(empleador);
	}
	

	public final ObjectProperty<LocalDate> desdeProperty() {
		return this.desde;
	}
	

	public final LocalDate getDesde() {
		return this.desdeProperty().get();
	}
	

	public final void setDesde(final LocalDate desde) {
		this.desdeProperty().set(desde);
	}
	

	public final ObjectProperty<LocalDate> hastaProperty() {
		return this.hasta;
	}
	

	public final LocalDate getHasta() {
		return this.hastaProperty().get();
	}
	

	public final void setHasta(final LocalDate hasta) {
		this.hastaProperty().set(hasta);
	}

	
	


}
