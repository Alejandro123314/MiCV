package dad.MiCV.conocimiento;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.MiCV.formacion.Titulo;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class ConocimientosController implements Initializable {

	private ObjectProperty<Idioma> idioma = new SimpleObjectProperty<Idioma>(new Idioma());
	private ObjectProperty<Conocimiento> conocimiento = new SimpleObjectProperty<Conocimiento>(new Conocimiento());
	private ListProperty<Conocimiento> conocimientos = new SimpleListProperty<>();
	private ListProperty<Niveles> niveles = new SimpleListProperty<>();
	
	@FXML
	private Button addConocimientoButton;

	@FXML
	private Button addIdiomaButton;

	@FXML
	private TableView<Conocimiento> conocimientoTableView;

	@FXML
	private Button eliminarButton;

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
		// TODO Auto-generated method stub

	}
	
	public GridPane getRoot() {
		return root;

	}

}
