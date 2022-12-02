package dad.MiCV.formacion;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import dad.MiCV.App;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class NuevoTituloController implements Initializable {

	ObjectProperty<Titulo> titulo = new SimpleObjectProperty<Titulo>(new Titulo());


    @FXML
    private Button cancelarButton;

    @FXML
    private TextField denominacionTextField;

    @FXML
    private DatePicker desdeDatePicker;

    @FXML
    private DatePicker hastaDatePicker;

    @FXML
    private Button okButton;

    @FXML
    private TextField organizadorTextField;

    @FXML
    private DialogPane root;
    
    private Stage stage;

	public NuevoTituloController() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoTitulo.fxml"));
			loader.setController(this);
			loader.load();
			
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		titulo.get().getDenominacion().bind(denominacionTextField.textProperty());
		titulo.get().getOrganizador().bind(organizadorTextField.textProperty());
		titulo.get().getDesde().bind(desdeDatePicker.valueProperty());
		titulo.get().getHasta().bind(hastaDatePicker.valueProperty());
		
		okButton.setOnAction(e -> onOkButton(e));
		cancelarButton.setOnAction(e -> onCancelarButton(e));
		
		stage = new Stage();
		stage.setTitle("Conectar al servidor");
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

	public ObjectProperty<Titulo> tituloProperty() {
		return this.titulo;
	}

	public Titulo getTitulo() {
		return this.tituloProperty().get();
	}


}
