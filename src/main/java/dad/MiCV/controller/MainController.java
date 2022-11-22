package dad.MiCV.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
	
	
	ObjectProperty<PersonalController>personal = new SimpleObjectProperty<>();
	ObjectProperty<ContactoController>cotacto = new SimpleObjectProperty<>();
	ObjectProperty<FormacionController>formacion = new SimpleObjectProperty<>();
	ObjectProperty<ExperienciaController>experiencia = new SimpleObjectProperty<>();
	ObjectProperty<PersonalController>nacional = new SimpleObjectProperty<>();
	
	
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
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
		}
		
		public TabPane getView() {
			return tabPane;

		}

}
