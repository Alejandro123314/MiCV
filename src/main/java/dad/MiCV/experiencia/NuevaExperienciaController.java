package dad.MiCV.experiencia;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dad.MiCV.App;
import dad.MiCV.formacion.Titulo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NuevaExperienciaController implements Initializable {
	
	ObjectProperty<Experiencia> experiencia = new SimpleObjectProperty<Experiencia>(new Experiencia());
	
	  @FXML
	    private Button cancelarButton;

	    @FXML
	    private TextField denominacionTextField;

	    @FXML
	    private DatePicker desdeDatePicker;

	    @FXML
	    private TextField empleadorTextField;

	    @FXML
	    private DatePicker hastaDatePicker;

	    @FXML
	    private Button okButton;

	    @FXML
	    private DialogPane root;

	    private Stage stage;
    
    public NuevaExperienciaController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevaExperiencia.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	experiencia.get().getDenominacion().bind(denominacionTextField.textProperty());
    	experiencia.get().getEmpleador().bind(empleadorTextField.textProperty());
    	experiencia.get().getDesde().bind(desdeDatePicker.valueProperty());
    	experiencia.get().getHasta().bind(hastaDatePicker.valueProperty());
    	
    	okButton.setOnAction(e -> onOkButton(e));
		cancelarButton.setOnAction(e -> onCancelarButton(e));
		
		stage = new Stage();
		stage.setTitle("Nueva experiencia");
		stage.setScene(new Scene(getView()));
		stage.initOwner(App.primaryStage);
		stage.initModality(Modality.APPLICATION_MODAL);
		
	}

    public DialogPane getView() {
		return root;
	}

	@FXML
	void onCancelarButton(ActionEvent event) {
		stage.close();
	}


	@FXML
	void onOkButton(ActionEvent event) {

	stage.close();

	}

	public void show() {
		stage.showAndWait();
	}

	public ObjectProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}

	public Experiencia getExperiencia() {
		return this.experienciaProperty().get();
	}

	
	


}
