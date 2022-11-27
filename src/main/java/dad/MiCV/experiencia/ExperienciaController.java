package dad.MiCV.experiencia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ExperienciaController implements Initializable {

	private ObjectProperty<Experiencia> experiencia = new SimpleObjectProperty<Experiencia>(new Experiencia());
	private ListProperty<Experiencia> experiencias = new SimpleListProperty<>();

	@FXML
	private Button addButton;

	@FXML
	private Button eliminarButton;

	@FXML
	private GridPane root;

	public ExperienciaController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
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
