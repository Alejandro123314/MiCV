package dad.MiCV.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.MiCV.personal.Personal;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ContactoController implements Initializable {

	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<Contacto>(new Contacto());
	private ListProperty<Telefono> telefonos = new SimpleListProperty<>();
	private ListProperty<Email> emails = new SimpleListProperty<>();
	private ListProperty<Web> webs = new SimpleListProperty<>();

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
	private TableView<Telefono> telefonoTableView;

	@FXML
	private TableView<Web> webTableView;

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
		
		emailTableView.itemsProperty().bind(emails);
		telefonoTableView.itemsProperty().bind(telefonos);
		webTableView.itemsProperty().bind(webs);

	}
	
	public VBox getRoot() {
		return root;

	}

}
