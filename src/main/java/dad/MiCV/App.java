package dad.MiCV;

import dad.MiCV.controller.MainController;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application {

	MainController mController;

	public static Window primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		App.primaryStage = primaryStage;

		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(new Scene(mController.getView()));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
