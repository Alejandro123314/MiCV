package dad.MiCV;

import dad.MiCV.controller.MainController;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application {

	MainController mainController;

	public static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mainController = new MainController();		
		App.primaryStage = primaryStage;

		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(new Scene(mainController.getView()));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
