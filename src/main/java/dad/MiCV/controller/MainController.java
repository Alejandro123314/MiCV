package dad.MiCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.MiCV.conocimiento.ConocimientosController;
import dad.MiCV.contacto.ContactoController;
import dad.MiCV.experiencia.ExperienciaController;
import dad.MiCV.formacion.FormacionController;
import dad.MiCV.personal.PersonalController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

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
	private Tab conocimientosTab;

	@FXML
	private Tab contactoTab;

	@FXML
	private Tab experienciaTab;

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

		conocimientosTab.setContent(conocimientosController.getView);
		personalTab.setContent(personalController.getView);
		contactoTab.setContent(contactoController.getView);
		experienciaTab.setContent(experienciaController.getView);
		formacionTab.setContent(formacionController.getView);

	}

	public TabPane getView() {
		return tabPane;

	}

}
