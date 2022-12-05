package dad.MiCV.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import dad.MiCV.App;
import dad.MiCV.conocimiento.Conocimiento;
import dad.MiCV.conocimiento.ConocimientosController;
import dad.MiCV.contacto.Contacto;
import dad.MiCV.contacto.ContactoController;
import dad.MiCV.contacto.Email;
import dad.MiCV.contacto.Telefono;
import dad.MiCV.contacto.Web;
import dad.MiCV.experiencia.Experiencia;
import dad.MiCV.experiencia.ExperienciaController;
import dad.MiCV.formacion.FormacionController;
import dad.MiCV.formacion.Titulo;
import dad.MiCV.personal.Nacionalidad;
import dad.MiCV.personal.Personal;
import dad.MiCV.personal.PersonalController;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
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
import javafx.stage.FileChooser;

public class MainController implements Initializable {
	
	private ObjectProperty<Personal> personal = new SimpleObjectProperty<Personal>(new Personal());
	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>(new Contacto());
	private ListProperty<Titulo> titulos = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Titulo>()));
	private ListProperty<Experiencia> experiencias = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Experiencia>()));
	private ListProperty<Conocimiento> conocimientos = new SimpleListProperty<>(
			FXCollections.observableList(new ArrayList<Conocimiento>()));
	
	private File file;

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
		
		personal.bindBidirectional(personalController.personalProperty());
		contacto.bindBidirectional(contactoController.contactoProperty());
		titulos.bindBidirectional(formacionController.formacionController());
		experiencias.bindBidirectional(experienciaController.experienciasProperty());
		conocimientos.bindBidirectional(conocimientosController.conocimientoProperty());
		
		salirItem.setOnAction(e -> salir(e));
		nuevoItem.setOnAction(e -> nuevo(e));
		abrirItem.setOnAction(e -> abrir(e));
		guardar_comoItem.setOnAction(e -> guardarComo(e));
		guardarItem.setOnAction(e -> guardar(e));

	}

	private void guardar(ActionEvent e) {
		if(file != null) {
			Gson gson = new Gson();
			try {
				gson.toJson(personal.get(),new FileWriter(file));
			} catch (JsonIOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			guardarComo(e);
		}
	}


	private void guardarComo(ActionEvent e) {
		FileChooser fileCh = new FileChooser();
		fileCh.setTitle("guardar");
		fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("json", "*.json"));
		File f = fileCh.showSaveDialog(App.primaryStage);
		Gson gson = new Gson();
		try {
			gson.toJson(personal.get(),new FileWriter(f));
		} catch (JsonIOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	private void abrir(ActionEvent e) {
		FileChooser fileCh = new FileChooser();
		fileCh.getExtensionFilters().add(new FileChooser.ExtensionFilter("json", "*.json"));
		file = fileCh.showOpenDialog(App.primaryStage);
		if(file != null) {
			Gson gson = new Gson();
			try {
				Reader reader = Files.newBufferedReader(file.toPath());
				Personal p = gson.fromJson(reader, Personal.class);
				personal.setValue(p);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}


	private void nuevo(ActionEvent e) {
		
		file = null;
		
		personal.get().setApellidos(null); 
		personal.get().setCodigoPostal(null);
		personal.get().setDireccion(null);
		personal.get().setFechaNacimiento(null);
		personal.get().setIdentificaion(null);
		personal.get().setLoacalidad(null);
		personal.get().setNacionalidades(new SimpleListProperty<>(
				FXCollections.observableList(new ArrayList<Nacionalidad>())));
		personal.get().setNombre(null);
		personal.get().setPais(null);
		
		contacto.get().setEmails(new SimpleListProperty<Email>(FXCollections.observableList(new ArrayList<Email>())));
		contacto.get().setTelefonos(new SimpleListProperty<Telefono>(FXCollections.observableList(new ArrayList<Telefono>())));
		contacto.get().setWebs(new SimpleListProperty<Web>(FXCollections.observableList(new ArrayList<Web>())));
		
		titulos.clear();
		experiencias.clear();
		conocimientos.clear();
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
