package dad.MiCV.conocimiento;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.MiCV.contacto.TipoTelefono;
import dad.MiCV.experiencia.Experiencia;
import dad.MiCV.formacion.NuevoTituloController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

public class ConocimientosController implements Initializable {

	private ListProperty<Conocimiento> conocimientos = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Conocimiento>()));
	private ObjectProperty<Conocimiento> conocimientoSeleccionado = new SimpleObjectProperty<>();

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
	private TableColumn<Conocimiento, Niveles> nivelColumn;

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
		
		ObservableList<Niveles> tipos = FXCollections.observableArrayList(new ArrayList<Niveles>());
		for (int i = 0; i < Niveles.values().length; i++) {
			tipos.add(Niveles.values()[i]);		
		}

		conocimientoTableView.setItems(conocimientos);

		denominacionColumn.setCellValueFactory(c -> c.getValue().getDenominacion());

		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		nivelColumn.setCellValueFactory(c -> c.getValue().getNivel());
		nivelColumn.setCellFactory(ComboBoxTableCell.forTableColumn(tipos));
		conocimientoSeleccionado.bind(conocimientoTableView.getSelectionModel().selectedItemProperty());
		
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
		NuevoIdiomaController controller = new NuevoIdiomaController();
		controller.show();
		conocimientos.add(controller.getIdioma());
	}

	private void aniadirConocimiento(ActionEvent e) {
		NuevoConocimientoController controller = new NuevoConocimientoController();
		controller.show();
		conocimientos.add(controller.getConocimiento());
	}

	public GridPane getRoot() {
		return root;

	}
	
	public ListProperty<Conocimiento> conocimientoProperty(){
		return conocimientos;
	}

}
