package dad.MiCV;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import dad.MiCV.controller.MainController;
import dad.MiCV.model.Nacionalidad;
import dad.ahorcado.AhorcadoApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application {

	public static Window primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		App.primaryStage = primaryStage;
		
		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(new Scene(MainController.getView()));
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
