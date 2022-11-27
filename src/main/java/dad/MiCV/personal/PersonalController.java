package dad.MiCV.personal;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>(new Personal());
	private ObservableList<String> paises = FXCollections.observableArrayList();
	private StringProperty paisSeleccionado = new SimpleStringProperty();
	
	private ListProperty<Nacionalidad> nacionalidades = new SimpleListProperty<>();
	private ObjectProperty<Nacionalidad> nacionalidadSeleccionado = new SimpleObjectProperty<Nacionalidad>();
	private ListProperty<Nacionalidad> todasNacionalidades = new SimpleListProperty<>();
	@FXML
	private TextField apellidosTextField;

	@FXML
	private Button botonAdd;

	@FXML
	private Button botonEliminar;

	@FXML
	private TextField codigoTextField;

	@FXML
	private TextArea direccionTextField;

	@FXML
	private TextField dniTextField;

	@FXML
	private DatePicker fechaDatePick;

	@FXML
	private TextField localidadTextField;

	@FXML
	private ListView<Nacionalidad> nacionalidaListView;

	@FXML
	private TextField nombreTextField;

	@FXML
	private ComboBox<String> paisComboBox;

	@FXML
	private GridPane root;
	

	public PersonalController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		dniTextField.textProperty().bindBidirectional(personal.get().identificaionProperty());
		nombreTextField.textProperty().bindBidirectional(personal.get().nombreProperty());
		apellidosTextField.textProperty().bindBidirectional(personal.get().apellidosProperty());
		direccionTextField.textProperty().bindBidirectional(personal.get().direccionProperty());
		codigoTextField.textProperty().bindBidirectional(personal.get().codigoPostalProperty());
		localidadTextField.textProperty().bindBidirectional(personal.get().loacalidadProperty());
		fechaDatePick.valueProperty().bindBidirectional(personal.get().fechaNacimientoProperty());
		
		paisComboBox.setItems(paises);
		paisComboBox.valueProperty().bindBidirectional(paisSeleccionado);
		paisSeleccionado.bindBidirectional(personal.get().paisProperty());
		
		personal.get().nacionalidadesProperty().bindBidirectional(nacionalidades);
		nacionalidaListView.itemsProperty().bind(nacionalidades);
		nacionalidadSeleccionado.bind(nacionalidaListView.getSelectionModel().selectedItemProperty());
		
		botonEliminar.setOnAction(e -> eliminar(e));
		botonAdd.setOnAction(e -> add(e));
	}

	private void add(ActionEvent e) {
		ChoiceDialog<Nacionalidad> dialogo = new ChoiceDialog<>();
//		dialogo. llenar
		dialogo.setTitle("Nueva Nacionalidad");
		dialogo.setHeaderText("Añadir nacionalidad");
		dialogo.setContentText("Seleccione una nacionalidad");
		Optional<Nacionalidad> resultado = dialogo.showAndWait();
		if(resultado.isPresent()) {
			nacionalidades.add(resultado.get());
		}
	}

	private void eliminar(ActionEvent e) {
		if(nacionalidadSeleccionado.get() != null) {
			nacionalidades.remove(nacionalidadSeleccionado);
		}
	}

	public GridPane getRoot() {
		return root;
	}
	

}
