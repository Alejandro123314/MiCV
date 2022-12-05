package dad.MiCV.formacion;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.MiCV.App;
import dad.MiCV.contacto.Telefono;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

public class FormacionController implements Initializable {

	private ListProperty<Titulo> titulos = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Titulo>()));
	private ObjectProperty<Titulo> tituloSeleccionado = new SimpleObjectProperty<>();

	@FXML
	private Button addButton;

	@FXML
	private TableColumn<Titulo, String> denominacionColumn;

	@FXML
	private TableColumn<Titulo, LocalDate> desdeColumn;

	@FXML
	private Button eliminarButton;

	@FXML
	private TableView<Titulo> formacionTableView;

	@FXML
	private TableColumn<Titulo, LocalDate> hastaColumn;

	@FXML
	private TableColumn<Titulo, String> organizadorColumn;

	@FXML
	private GridPane root;

	public FormacionController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		formacionTableView.setItems(titulos);
		
		denominacionColumn.setCellValueFactory(c -> c.getValue().getDenominacion());
		organizadorColumn.setCellValueFactory(c -> c.getValue().getOrganizador());
		denominacionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		organizadorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		desdeColumn.setCellValueFactory(c -> c.getValue().getDesde());
		hastaColumn.setCellValueFactory(c -> c.getValue().getHasta());
//		desdeColumn.setCellFactory(DateCell.);
//		hastaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tituloSeleccionado.bind(formacionTableView.selectionModelProperty().get().selectedItemProperty());
		
		addButton.setOnAction(e -> aniadir(e));
		eliminarButton.setOnAction(e -> eliminar(e));
	}

	private void eliminar(ActionEvent e) {
		if(tituloSeleccionado.get() != null) {
			titulos.remove(tituloSeleccionado.get());
		}
	}

	private void aniadir(ActionEvent e) {
		NuevoTituloController controller = new NuevoTituloController();
		controller.show();
		titulos.add(controller.getTitulo());
	}

	public GridPane getRoot() {
		return root;

	}
	
	public ListProperty<Titulo> formacionController(){
		return titulos;
	}

}
