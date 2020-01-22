package formes_javafx;

import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Principal extends Application {
	
	GraphicsContext gc;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Canvas canvas = new Canvas();
		gc = canvas.getGraphicsContext2D();
		
		Pane pane = new Pane();
		pane.getChildren().add(canvas);

		Scene scene = new Scene(pane, 600, 400);
		
		InputStream formes = Principal.class.getResourceAsStream("/txt/test01.txt");
		
		Scanner scanner = new Scanner(formes);
		
		

		
		
		
		
		

		stage.setScene(scene);
		stage.show();
	}
}

