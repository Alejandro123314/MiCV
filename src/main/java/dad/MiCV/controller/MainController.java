package dad.MiCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.MiCV.App;
import dad.MiCV.conocimiento.ConocimientosController;
import dad.MiCV.contacto.ContactoController;
import dad.MiCV.experiencia.ExperienciaController;
import dad.MiCV.formacion.FormacionController;
import dad.MiCV.personal.PersonalController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	

	PersonalController personalController = new PersonalController();
	FormacionController formacionController = new FormacionController();
	ContactoController contactoController = new ContactoController();
	ExperienciaController experienciaController = new ExperienciaController();
	ConocimientosController conocimientosController = new ConocimientosController();

	@FXML
	private Menu AyudaMenu;

	@FXML
	private Menu archivoMenu;

	@FXML
	private MenuItem nuevoItem;

	@FXML
	private Tab conocimientosTab;

	@FXML
	private Tab contactoTab;

	@FXML
	private Tab experienciaTab;

	@FXML
	private MenuItem guardarItem;

	@FXML
	private MenuItem guardar_comoItem;

	@FXML
	private MenuItem salirItem;

	@FXML
	private MenuItem abrirItem;

	@FXML
	private Tab formacionTab;

	@FXML
	private MenuBar menuBar;

	@FXML
	private Tab personalTab;

	@FXML
	private BorderPane root;

	@FXML
	private TabPane tabPane;

	public MainController() throws IOException {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Image nuevaImagen = new Image(getClass().getResourceAsStream("/images/nuevo.gif"));
		nuevoItem.setGraphic(new ImageView(nuevaImagen));
		
		Image abrirImagen = new Image(getClass().getResourceAsStream("/images/abrir.gif"));
		abrirItem.setGraphic(new ImageView(abrirImagen));
		
		Image guardarImagen = new Image(getClass().getResourceAsStream("/images/guardar.gif"));
		guardarItem.setGraphic(new ImageView(guardarImagen));
		
		conocimientosTab.setContent(conocimientosController.getRoot());
		personalTab.setContent(personalController.getRoot());
		contactoTab.setContent(contactoController.getRoot());
		experienciaTab.setContent(experienciaController.getRoot());
		formacionTab.setContent(formacionController.getRoot());
		
		salirItem.setOnAction(e -> salir(e));

	}

	private void salir(ActionEvent e) {
		Alert alerta = new Alert(AlertType.CONFIRMATION);
		alerta.setTitle("Exit");
		alerta.setHeaderText("¿Seguro que quieres cerrar?");
		alerta.setContentText("si sales los datos se reinician");
		Optional<ButtonType> resultado = alerta.showAndWait();
		if(resultado.get()==ButtonType.OK) {
			App.primaryStage.close();
		}
	}


	public BorderPane getView() {
		return root;

	}

}
