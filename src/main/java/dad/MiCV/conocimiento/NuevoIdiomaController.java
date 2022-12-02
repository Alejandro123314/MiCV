package dad.MiCV.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.MiCV.App;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NuevoIdiomaController implements Initializable {

	private ObjectProperty<Idioma> idioma = new SimpleObjectProperty<Idioma>(new Idioma());

	@FXML
	private Button addButton;

	@FXML
	private Button cancelarButton;

	@FXML
	private TextField certificacionTexttField;

	@FXML
	private TextField denominacionTextField;

	@FXML
	private Button limpiarButton;

	@FXML
	private ComboBox<Niveles> nivelComboBox;

	@FXML
	private GridPane root;

	private Stage stage;

	public NuevoIdiomaController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoIdiomaView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		ObservableList<Niveles> niveles = FXCollections.observableArrayList(new ArrayList<Niveles>());
		for (int i = 0; i < Niveles.values().length; i++) {
			niveles.add(Niveles.values()[i]);
		}

		nivelComboBox.getItems().addAll(niveles);
		idioma.get().getNivel().bind(nivelComboBox.getSelectionModel().selectedItemProperty());
		idioma.get().getDenominacion().bindBidirectional(denominacionTextField.textProperty());
		idioma.get().certificaionProperty().bindBidirectional(certificacionTexttField.textProperty());

		stage = new Stage();
		stage.setTitle("Nuevo conocimiento");
		stage.setScene(new Scene(getView()));
		stage.initOwner(App.primaryStage);
		stage.initModality(Modality.APPLICATION_MODAL);

		addButton.setOnAction(e -> onAddButton(e));
		cancelarButton.setOnAction(e -> onCancelarButton(e));
		limpiarButton.setOnAction(e -> onLimpiarButton(e));
	}

	private void onLimpiarButton(ActionEvent e) {
		nivelComboBox.getSelectionModel().clearSelection();
		nivelComboBox.setValue(null);

	}

	public GridPane getView() {
		return root;
	}

	@FXML
	void onCancelarButton(ActionEvent event) {
		stage.close();
	}

	@FXML
	void onAddButton(ActionEvent event) {

		stage.close();

	}

	public void show() {
		stage.showAndWait();
	}

	public final ObjectProperty<Idioma> idiomaProperty() {
		return this.idioma;
	}

	public final Idioma getIdioma() {
		return this.idiomaProperty().get();
	}

}
