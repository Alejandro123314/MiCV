package dad.MiCV.formacion;

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
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class FormacionController implements Initializable {

	private ObjectProperty<Titulo> titulo = new SimpleObjectProperty<Titulo>(new Titulo());
	private ListProperty<Titulo> titulos = new SimpleListProperty<>();

	@FXML
	private GridPane root;

	@FXML
	private Button addButton;

	@FXML
	private Button eliminarButton;

	@FXML
	private TableView<Titulo> formacionTableView;

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
		// TODO Auto-generated method stub

	}

	public GridPane getRoot() {
		return root;

	}

}
