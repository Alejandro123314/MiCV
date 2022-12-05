package dad.MiCV.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class ContactoController implements Initializable {

	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>(new Contacto());
	private ObjectProperty<Telefono> telefonoSeleccionado = new SimpleObjectProperty<Telefono>(); 
	private ObjectProperty<Email> emailSeleccionado = new SimpleObjectProperty<Email>(); 
	private ObjectProperty<Web> urlSeleccionado = new SimpleObjectProperty<Web>(); 
	

	@FXML
	private VBox root;

	@FXML
	private Button addEmailButton;

	@FXML
	private Button addTelefonoButton;

	@FXML
	private Button addWebButton;

	@FXML
	private Button eliminarEmailButton;

	@FXML
	private Button eliminarTelefonoButton;

	@FXML
	private Button eliminarWebButton;

	@FXML
	private TableView<Email> emailTableView;
	
    @FXML
    private TableColumn<Email, String> emailColumn;   

	@FXML
	private TableView<Telefono> telefonoTableView;
	
	@FXML
	private TableColumn<Telefono, String> numeroColumn;

	@FXML
	private TableColumn<Telefono, TipoTelefono> tipoColumn;

	@FXML
	private TableView<Web> webTableView;
	
	@FXML
    private TableColumn<Web, String> urlColumn;

	public ContactoController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		numeroColumn.setCellValueFactory(t -> t.getValue().numeroProperty());
		tipoColumn.setCellValueFactory(t -> t.getValue().getPersonal());
		
		numeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ObservableList<TipoTelefono> tipos = FXCollections.observableArrayList(new ArrayList<TipoTelefono>());
		for (int i = 0; i < TipoTelefono.values().length; i++) {
			tipos.add(TipoTelefono.values()[i]);		
		}
		
		tipoColumn.setCellFactory(ComboBoxTableCell.forTableColumn(tipos));
		
		telefonoSeleccionado.bind(telefonoTableView.selectionModelProperty().get().selectedItemProperty());
		emailSeleccionado.bind(emailTableView.selectionModelProperty().get().selectedItemProperty());
		urlSeleccionado.bind(webTableView.selectionModelProperty().get().selectedItemProperty());
		
		
		emailTableView.itemsProperty().bind(contacto.get().emailsProperty());
		telefonoTableView.itemsProperty().bind(contacto.get().telefonosProperty());
		webTableView.itemsProperty().bind(contacto.get().websProperty());
		
		emailColumn.setCellValueFactory(c -> c.getValue().EmailProperty());
		emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		urlColumn.setCellValueFactory(c -> c.getValue().urlProperty());
		urlColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		addTelefonoButton.setOnAction(e -> aniadirTelefono(e));
		eliminarTelefonoButton.setOnAction(e -> eliminarTelefono(e));
		
		addEmailButton.setOnAction(e -> aniadirEmail(e));
		eliminarEmailButton.setOnAction(e -> eliminarEmail(e));
		
		addWebButton.setOnAction(e -> aniadirWeb(e));
		eliminarWebButton.setOnAction(e -> eliminarWeb(e));

	}

	private void eliminarWeb(ActionEvent e) {
		if(urlSeleccionado.get() != null) {
			contacto.get().websProperty().remove(urlSeleccionado.get());
		}
	}

	private void aniadirWeb(ActionEvent e) {
		TextInputDialog dialogo = new TextInputDialog("http://");
		dialogo.setTitle("Nueva web");
		dialogo.setHeaderText("Crear una nueva direccion web");
		dialogo.setContentText("URL:");
		Optional<String> resultado = dialogo.showAndWait();
		
		resultado.ifPresent(web -> {
			Web nuevoWeb = new Web();
			nuevoWeb.setUrl(web);
			contacto.get().websProperty().add(nuevoWeb);
		});
	}

	private void eliminarEmail(ActionEvent e) {
		if(emailSeleccionado.get() != null) {
			contacto.get().emailsProperty().remove(emailSeleccionado.get());
		}
	}

	private void aniadirEmail(ActionEvent e) {
		TextInputDialog dialogo = new TextInputDialog();
		dialogo.setTitle("Nuevo e-mail");
		dialogo.setHeaderText("Crear una nueva direccion de correo");
		dialogo.setContentText("E-mail:");
		Optional<String> resultado = dialogo.showAndWait();
		

		resultado.ifPresent(email -> {
			Email nuevoEmail = new Email();
			nuevoEmail.setEmail(email);
			contacto.get().emailsProperty().add(nuevoEmail);
		});
	}

	private void eliminarTelefono(ActionEvent e) {
		if(telefonoSeleccionado.get() != null) {
			contacto.get().telefonosProperty().remove(telefonoSeleccionado.get());
		}
	}

	private void aniadirTelefono(ActionEvent e) {
		Dialog<Pair<String, TipoTelefono>> dialogo = new Dialog<>();
		dialogo.setTitle("Nuevo Telefono");
		dialogo.setHeaderText("Introduzca el nuevo número de telefono");
		
		ButtonType addButton = new ButtonType("añadir", ButtonData.OK_DONE);
		dialogo.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20,150,10,10));
		
		TextField telefono = new TextField();
		telefono.setPromptText("Numero de telefono");
		
		ComboBox<TipoTelefono> combo = new ComboBox<>();
		ObservableList<TipoTelefono> tipos = FXCollections.observableArrayList(new ArrayList<TipoTelefono>());
		for (int i = 0; i < TipoTelefono.values().length; i++) {
			tipos.add(TipoTelefono.values()[i]);		
		}
		combo.setItems(tipos);
		
		grid.add(new Label("Numero:"), 0, 0);
		grid.add(new Label("Tipo:"), 0, 1);
		grid.add(telefono, 1, 0);
		grid.add(combo, 1, 1);
		
		dialogo.getDialogPane().setContent(grid);
				
		dialogo.setResultConverter(dialogoButton -> {
			if(dialogoButton == addButton) {
				return new Pair<String, TipoTelefono>(telefono.getText(), combo.selectionModelProperty().get().getSelectedItem());
			}
			return null;
		});
		
		Optional<Pair<String, TipoTelefono>> resultado = dialogo.showAndWait();
		resultado.ifPresent(telefonoTipo ->{
			Telefono nuevoTelefono = new Telefono();
			
			nuevoTelefono.setNumero(telefonoTipo.getKey());
			nuevoTelefono.setPersonal(new SimpleObjectProperty<TipoTelefono>(telefonoTipo.getValue()));
			contacto.get().telefonosProperty().add(nuevoTelefono);
		});
		
	}

	public VBox getRoot() {
		return root;

	}
	
	public ObjectProperty<Contacto> contactoProperty() {
		return contacto;
	}

}
