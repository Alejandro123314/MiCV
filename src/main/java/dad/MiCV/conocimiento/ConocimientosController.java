package dad.MiCV.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.MiCV.experiencia.Experiencia;
import dad.MiCV.formacion.NuevoTituloController;
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

public class ConocimientosController implements Initializable {

	private ListProperty<Conocimiento> conocimientos = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Conocimiento>()));
	private ObjectProperty<Conocimiento> conocimientoSeleccionado = new SimpleObjectProperty<>();
	private ListProperty<Niveles> niveles = new SimpleListProperty<>();

	@FXML
	private Button addConocimientoButton;

	@FXML
	private Button addIdiomaButton;

	@FXML
	private TableView<Conocimiento> conocimientoTableView;

	@FXML
	private TableColumn<Conocimiento, String> denominacionColumn;

	@FXML
	private Button eliminarButton;

	@FXML
	private TableColumn<Niveles, Object> nivelColumn;

	@FXML
	private GridPane root;

	public ConocimientosController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		conocimientoTableView.setItems(conocimientos);

		denominacionColumn.setCellValueFactory(c -> c.getValue().getDenominacion());

		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		addConocimientoButton.setOnAction(e -> aniadirConocimiento(e));
		addIdiomaButton.setOnAction(e -> aniadirIdioma(e));
		eliminarButton.setOnAction(e -> eliminar(e));

	}

	private void eliminar(ActionEvent e) {
		if(conocimientoSeleccionado.get() != null) {
			conocimientos.remove(conocimientoSeleccionado.get());
		}
	}

	private void aniadirIdioma(ActionEvent e) {
		NuevoTituloController controller = new NuevoTituloController();
		Dialog<Conocimiento> dialogo = new Dialog();
		dialogo.setTitle("Nuevo conocimiento");
		
		ButtonType aceptarButton = new ButtonType("Crear",ButtonData.OK_DONE);
		dialogo.getDialogPane().getButtonTypes().addAll(aceptarButton, ButtonType.CANCEL);
		
		dialogo.getDialogPane().setContent(controller.getRoot());
		Optional<Conocimiento> resultado = dialogo.showAndWait();
	}

	private void aniadirConocimiento(ActionEvent e) {
		NuevoTituloController controller = new NuevoTituloController();
		Dialog<Conocimiento> dialogo = new Dialog();
		dialogo.setTitle("Nuevo conocimiento");
		
		ButtonType aceptarButton = new ButtonType("Crear",ButtonData.OK_DONE);
		dialogo.getDialogPane().getButtonTypes().addAll(aceptarButton, ButtonType.CANCEL);
		
		dialogo.getDialogPane().setContent(controller.getRoot());
		Optional<Conocimiento> resultado = dialogo.showAndWait();
	}

	public GridPane getRoot() {
		return root;

	}

}
