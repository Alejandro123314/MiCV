package dad.MiCV.experiencia;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.MiCV.formacion.NuevoTituloController;
import dad.MiCV.formacion.Titulo;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

public class ExperienciaController implements Initializable {

	private ListProperty<Experiencia> experiencias = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Experiencia>()));
	private ObjectProperty<Experiencia> experienciaSeleccionado = new SimpleObjectProperty<>();

	@FXML
	private Button addButton;

	@FXML
	private TableColumn<Experiencia, String> denominacionColumn;

	@FXML
	private TableColumn<Experiencia, LocalDate> desdeColumn;

	@FXML
	private Button eliminarButton;

	@FXML
	private TableColumn<Experiencia, String> empleadorColumn;

	@FXML
	private TableView<Experiencia> experienciaTableView;

	@FXML
	private TableColumn<Experiencia, LocalDate> hastaColumn;

	@FXML
	private GridPane root;

	public ExperienciaController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		experienciaTableView.setItems(experiencias);
		
		denominacionColumn.setCellValueFactory(c -> c.getValue().getDenominacion());
		empleadorColumn.setCellValueFactory(c -> c.getValue().getEmpleador());
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		empleadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		desdeColumn.setCellValueFactory(c -> c.getValue().getDesde());
		hastaColumn.setCellValueFactory(c -> c.getValue().getHasta());
		
		experienciaSeleccionado.bind(experienciaTableView.selectionModelProperty().get().selectedItemProperty());
		
		addButton.setOnAction(e -> aniadir(e));
		eliminarButton.setOnAction(e -> eliminar(e));

	}

	private void eliminar(ActionEvent e) {
		if(experienciaSeleccionado.get() != null) {
			experiencias.remove(experienciaSeleccionado.get());
		}
	}

	private void aniadir(ActionEvent e) {
		NuevaExperienciaController controller = new NuevaExperienciaController();
		controller.show();
		experiencias.add(controller.getExperiencia());
	}

	public GridPane getRoot() {
		return root;
	}

	public ListProperty<Experiencia> experienciasProperty() {
		return experiencias;
	}
}
