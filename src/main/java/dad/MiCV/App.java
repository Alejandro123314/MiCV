package dad.MiCV;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import dad.MiCV.model.Nacionalidad;
import javafx.application.Application;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		URI uri = App.class.getResource("csvnacionalidades.csv/").toURI();
		List<String> items =Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
		List<Nacionalidad> nacionaliades = items.stream()
					.map(Nacionalidad::new)
					.collect(Collectors.toList());
		
		ChoiceDialog<Nacionalidad> dialog = new ChoiceDialog<Nacionalidad>();
		dialog.getItems().setAll(nacionaliades);
		dialog.setSelectedItem(nacionaliades.get(0));
		dialog.setTitle("Eleccion");
		dialog.setHeaderText("Elige una opción");
		dialog.setContentText("Opción:");
		Nacionalidad n = dialog.showAndWait().orElse(null);
		System.out.println(n);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
