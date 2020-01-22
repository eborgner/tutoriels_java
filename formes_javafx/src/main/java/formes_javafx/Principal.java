package formes_javafx;

import java.io.InputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Principal extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage st) throws Exception {
		
		Canvas cv = new Canvas(600, 400);
		GraphicsContext gc = cv.getGraphicsContext2D();
		
		
		Pane p = new Pane();
		p.getChildren().add(cv);

		Scene sc = new Scene(p, 600, 400);
		
		InputStream in = Principal.class.getResourceAsStream("/entrees/01.txt");
		
		Scanner scan = new Scanner(in);
		
		while(scan.hasNext()) {

			String n = scan.next();

			Color c = Color.valueOf(scan.next());
			gc.setFill(c);
			
			int x = scan.nextInt();
			int y = scan.nextInt();
			

			switch(n) {
			
			case "Cercle":
				int r = scan.nextInt();
				gc.fillArc(x-r/2, y-r/2, r, r, 0, 360, ArcType.ROUND);
				break;

			case "Carre":
				int t = scan.nextInt();
				gc.fillRect(x, y, t, t);
				break;

			case "Rectangle":
				int l = scan.nextInt();
				int ll = scan.nextInt();
				gc.fillRect(x, y, l, ll);
				break;
			}
		}

		scan.close();

		st.setScene(sc);
		st.show();
	}
}

